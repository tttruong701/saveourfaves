package com.ttruong.saveourfaves.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@Table
public class Business {
    @PrimaryKey
    private String id;
    private String name;
    private String giftCardURL;
}
