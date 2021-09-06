package com.ttruong.saveourfaves.service;

import com.ttruong.model.BusinessV1;
import com.ttruong.saveourfaves.accessor.BusinessAccessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessAccessor businessAccessor;

    public Flux<BusinessV1> findAllBusinesses() {
        return businessAccessor.findAllBusinesses()
                .map(b -> new BusinessV1()
                        .id(Long.parseLong(b.getId()))
                        .name(b.getName())
                        .giftCardURL(b.getGiftCardURL()));
    }

    public Mono<Boolean> updateBusiness(BusinessV1 business) {
        return Mono.just(businessAccessor.updateBusiness(business));
    }
}
