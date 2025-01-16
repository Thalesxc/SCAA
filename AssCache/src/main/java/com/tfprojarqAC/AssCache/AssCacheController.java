package com.tfprojarqAC.AssCache;

import org.codehaus.stax2.ri.typed.ValueDecoderFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
public class AssCacheController {

    private final CacheService cacheService;

    public AssCacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/{appId}")
    public boolean  checkSubscription(@PathVariable Long appId) {
        return cacheService.getSubscription(appId);
    }
}
