package com.ttruong.saveourfaves.accessor;

import com.ttruong.model.BusinessV1;
import com.ttruong.saveourfaves.model.Business;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BusinessAccessor {
    private static final Map<String, Business> businesses = new ConcurrentHashMap<>();
    private static int nextId = 0;

    public Flux<Business> findAllBusinesses() {
        return Flux.fromIterable(businesses.values());
//        return Flux.just(
//                Business.builder().id("1").name("Bahn Thai").giftCardURL("https://www.bahnthai.net/gift-cards").build(),
//                Business.builder().id("2").name("Chicago Fire Grill").giftCardURL("https://chicagofiregrill.com/").build()
//        );
    }

    public Boolean updateBusiness(BusinessV1 businessV1) {
        businesses.put(businessV1.getName(), Business.builder().id(String.valueOf(++nextId)).name(businessV1.getName()).giftCardURL(businessV1.getGiftCardURL()).build());
        return true;
    }
}
