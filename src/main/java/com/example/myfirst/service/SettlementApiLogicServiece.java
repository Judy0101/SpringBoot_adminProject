package com.example.myfirst.service;



import com.example.myfirst.model.entity.Item;
import com.example.myfirst.model.entity.Partner;
import com.example.myfirst.model.entity.Settlement;
import com.example.myfirst.model.entity.User;
import com.example.myfirst.model.enurmclass.UserStatus;
import com.example.myfirst.model.network.Header;
import com.example.myfirst.model.network.request.SettlementApiRequest;
import com.example.myfirst.model.network.response.SettlementApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SettlementApiLogicServiece  extends BaseService<SettlementApiRequest, SettlementApiResponse, Settlement> {

    @Override
    public Header<SettlementApiResponse> create(Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    public Header<SettlementApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(settlement -> response(settlement))
                .orElseGet(() -> Header.ERROR("데이터 없음"));

    }


    @Override
    public Header<SettlementApiResponse> update(Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    public Header<SettlementApiResponse> response(Settlement settlement){

        SettlementApiResponse body = SettlementApiResponse.builder()
                .userId(settlement.getUserId())
                .price(settlement.getPrice())
                .build();

        return Header.OK(body);
    }
}
