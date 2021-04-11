package com.example.myfirst.controller.api;

import com.example.myfirst.controller.CrudController;
import com.example.myfirst.model.entity.Settlement;
import com.example.myfirst.model.network.request.SettlementApiRequest;
import com.example.myfirst.model.network.response.SettlementApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/settlement")
public class SettlementApiController extends CrudController<SettlementApiRequest, SettlementApiResponse, Settlement> {
}
