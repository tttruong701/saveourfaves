package com.ttruong.saveourfaves.accessor;

import com.ttruong.saveourfaves.model.Business;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface BusinessRepository extends ReactiveCassandraRepository<Business, String> {
}
