package com.cognizant.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Component
public class LogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String method = exchange.getRequest().getMethod().name();
        String uri = exchange.getRequest().getURI().toString();
        long time = Instant.now().toEpochMilli();

        System.out.println("HTTP Method: " + method);
        System.out.println("URI: " + uri);
        System.out.println("Time: " + time);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
