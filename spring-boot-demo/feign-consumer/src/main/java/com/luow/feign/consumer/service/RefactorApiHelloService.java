package com.luow.feign.consumer.service;

import com.luow.didispace.service.ApiHelloService;
import com.luow.feign.consumer.service.impl.ApiHelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "hello-demo", fallback = ApiHelloServiceFallback.class)
public interface RefactorApiHelloService extends ApiHelloService {
}
