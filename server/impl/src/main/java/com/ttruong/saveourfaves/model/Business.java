package com.ttruong.saveourfaves.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Business {
    private String id;
    private String name;
    private String giftCardURL;
}
