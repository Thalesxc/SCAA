package com.tfprojarqAC.AssCache;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CacheService {

    private final Map<Long, Subscription> cache = new ConcurrentHashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);
    private final ScaaClient scaaClient;
    private final RestTemplate restTemplate;

    @Autowired
    public CacheService(ScaaClient scaaClient, RestTemplate restTemplate) {
        this.scaaClient = scaaClient;
        this.restTemplate = restTemplate;
    }

    public boolean getSubscription(Long appId) {

        Subscription subscription = cache.get(appId);

        if (subscription == null) {
            subscription = scaaClient.getSubscription(appId);
            if (subscription == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subscription not found");
            }
            cache.put(appId, subscription);
        }

        return isSubscriptionValid(subscription);
    }

    private boolean isSubscriptionValid(Subscription subscription) {
        return subscription.endDate().atStartOfDay().isAfter(LocalDateTime.now());
    }

    @RabbitListener(queues = "#{queue.name}")
    public void receive(Subscription subscription) {
        logger.info("Received update subscription validation date: ", subscription);
        cache.put(subscription.appId(), subscription);
    }
}
    