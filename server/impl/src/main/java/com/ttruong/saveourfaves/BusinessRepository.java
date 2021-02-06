package com.ttruong.saveourfaves;

import reactor.core.publisher.Flux;

public class BusinessRepository {

    public Flux<Business> findAllBusinesses() {
        return Flux.just(
                // TODO Find cleaner creation
                new Business.BusinessBuilder().name("Bahn Thai").giftCardURL("https://www.bahnthai.net/gift-cards").build(),
                new Business.BusinessBuilder().name("Chicago Fire Grill").giftCardURL("https://chicagofiregrill.com/").build()
        );
    }
}
