package com.example.myfirst.controller.api;

import com.example.myfirst.controller.CrudController;
import com.example.myfirst.model.entity.Partner;
import com.example.myfirst.model.network.request.PartnerApiRequest;
import com.example.myfirst.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
