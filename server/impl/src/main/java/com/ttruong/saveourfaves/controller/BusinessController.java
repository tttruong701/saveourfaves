package com.ttruong.saveourfaves.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.ttruong.api.V1Api;
import com.ttruong.model.BusinessV1;
import com.ttruong.saveourfaves.service.BusinessService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class BusinessController implements V1Api {

    private final BusinessService businessService;

    @Override
    public Mono<ResponseEntity<Void>> deleteBusiness(Long businessId, ServerWebExchange exchange) {
        return null;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @Override
    public Mono<ResponseEntity<Flux<BusinessV1>>> getAllBusiness(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok()
                .body(businessService.findAllBusinesses()));
    }

    @Override
    public Mono<ResponseEntity<BusinessV1>> getBusinessById(Long businessId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> updateBusiness(Mono<BusinessV1> businessV1, ServerWebExchange exchange) {
        return null;
    }

}

