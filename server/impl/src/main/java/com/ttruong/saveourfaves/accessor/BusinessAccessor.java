package com.ttruong.saveourfaves.accessor;

import com.ttruong.saveourfaves.model.Business;

import reactor.core.publisher.Flux;

public class BusinessAccessor {

    public Flux<Business> findAllBusinesses() {
        return Flux.just(
                Business.builder().id("1").name("Bahn Thai").giftCardURL("https://www.bahnthai.net/gift-cards").build(),
                Business.builder().id("2").name("Chicago Fire Grill").giftCardURL("https://chicagofiregrill.com/").build()
        );
    }
}
