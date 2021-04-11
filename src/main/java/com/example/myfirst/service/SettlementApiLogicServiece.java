package com.example.myfirst.service;



import com.example.myfirst.model.entity.Partner;
import com.example.myfirst.model.entity.Settlement;
import com.example.myfirst.model.network.Header;
import com.example.myfirst.model.network.request.SettlementApiRequest;
import com.example.myfirst.model.network.response.PartnerApiResponse;
import com.example.myfirst.model.network.response.SettlementApiResponse;

public class SettlementApiLogicServiece  extends BaseService<SettlementApiRequest, SettlementApiResponse, Settlement> {
    @Override
    public Header<SettlementApiResponse> create(Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    public Header<SettlementApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<SettlementApiResponse> update(Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
//
//    private Header<SettlementApiResponse> response(Settlement settlement){
//
//        PartnerApiResponse body = PartnerApiResponse.builder()
//                .id(settlement.getUserID())
//                .price(settlement.getPrice())
//                .build();
//
//        return Header.OK(body);
//    }
}
