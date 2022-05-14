package com.ttruong.saveourfaves.adapter;

import com.ttruong.model.BusinessV1;
import com.ttruong.saveourfaves.model.Business;

public class BusinessAdapter {
    public static BusinessV1 convert(Business business) {
        return new BusinessV1()
                .name(business.getName())
                .giftCardURL(business.getGiftCardURL());
    }
}