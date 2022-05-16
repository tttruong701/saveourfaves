package com.ttruong.saveourfaves.controller;

import com.ttruong.api.V1Api;
import com.ttruong.model.BusinessV1;
import com.ttruong.saveourfaves.service.BusinessService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", methods = { OPTIONS, GET,  PUT })
public class BusinessController implements V1Api {

    private final BusinessService businessService;

    @Override
    public Mono<ResponseEntity<Void>> deleteBusiness(String businessId, ServerWebExchange exchange) {
        return businessService.deleteBusiness(businessId)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    @Override
    public Mono<ResponseEntity<Flux<BusinessV1>>> getAllBusiness(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok(businessService.findAllBusinesses()));
    }

    @Override
    public Mono<ResponseEntity<BusinessV1>> getBusinessById(String businessId, ServerWebExchange exchange) {
        return businessService.getBusiness(businessId)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Void>> updateBusiness(Mono<BusinessV1> businessV1, ServerWebExchange exchange) {
        return businessV1.flatMap(businessService::updateBusiness)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}