package com.ttruong.saveourfaves.adapter;

import com.ttruong.model.BusinessV1;
import com.ttruong.saveourfaves.model.Business;

import java.util.UUID;

public class DalAdapter {
    public static Business convert(BusinessV1 business) {
        return Business.builder()
                .id(UUID.randomUUID().toString())
                .name(business.getName())
                .giftCardURL(business.getGiftCardURL())
                .build();
    }
}
