package com.tfprojarqAC.AssCache;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tfprojarq")
public interface ScaaClient {

    @GetMapping("/servcad/assinvalida/{codass}")
    Subscription getSubscription(@PathVariable("codass") Long id);
}
