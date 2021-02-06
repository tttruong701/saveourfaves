package com.ttruong.saveourfaves;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;

import com.ttruong.api.BusinessApi;
import com.ttruong.model.Business;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
public class BusinessController implements BusinessApi {

    private final BusinessRepository businessRepository;

    @Override
    public Mono<ResponseEntity<Void>> deleteBusiness(Long businessId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> getAllBusiness(ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Business>> getBusinessById(Long businessId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> updateBusiness(Mono<Business> business, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> updateBusinessWithForm(Long businessId, String name, String status, ServerWebExchange exchange) {
        return null;
    }

//    @GetMapping("/get/business")
//    public Mono<List<Business>> getAllBusiness() {
//        return businessRepository.findAllBusinesses().collectList();
//    }
}

