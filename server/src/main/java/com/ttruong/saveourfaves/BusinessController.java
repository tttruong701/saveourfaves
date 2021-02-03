package com.ttruong.saveourfaves;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@AllArgsConstructor
public class BusinessController {

    private final BusinessRepository businessRepository;

    @GetMapping("/get/business")
    public Mono<List<Business>> getAllBusiness() {
        return businessRepository.findAllBusinesses().collectList();
    }
}

