package com.ttruong.saveourfaves.service;

import com.ttruong.model.BusinessV1;
import com.ttruong.saveourfaves.accessor.BusinessRepository;
import com.ttruong.saveourfaves.adapter.BusinessAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ttruong.saveourfaves.adapter.DalAdapter.convert;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;

    public Flux<BusinessV1> findAllBusinesses() {
        return businessRepository.findAll()
                .map(BusinessAdapter::convert);
    }

    public Mono<Void> updateBusiness(BusinessV1 business) {
        return businessRepository.insert(convert(business))
                .then();
    }

    public Mono<Void> deleteBusiness(String businessId) {
        return businessRepository.deleteById(businessId);
    }

    public Mono<BusinessV1> getBusiness(String businessId) {
        return businessRepository.findById(businessId)
                .map(BusinessAdapter::convert);
    }
}