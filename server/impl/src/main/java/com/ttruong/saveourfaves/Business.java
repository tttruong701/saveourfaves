package com.ttruong.saveourfaves;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Business {
    private String name;
    private String giftCardURL;
}
