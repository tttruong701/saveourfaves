package com.ttruong.saveourfaves.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Override
    protected String getContactPoints() {
        return "127.0.0.1"; // TODO Reference constant file
    }


    @Override
    protected String getKeyspaceName() {
        return "master"; // TODO Reference constant file
    }
}
