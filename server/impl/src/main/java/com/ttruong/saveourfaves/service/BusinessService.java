package com.ttruong.saveourfaves.service;

import org.springframework.stereotype.Service;

import com.ttruong.model.BusinessV1;
import com.ttruong.saveourfaves.accessor.BusinessAccessor;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

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
}
