package com.example.myfirst.controller.api;

import com.example.myfirst.controller.CrudController;
import com.example.myfirst.ifs.CrudInterface;
import com.example.myfirst.model.entity.OrderGroup;
import com.example.myfirst.model.network.Header;
import com.example.myfirst.model.network.request.OrderGroupApiRequest;
import com.example.myfirst.model.network.response.OrderGroupApiResponse;
import com.example.myfirst.service.OrderGroupLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {



//
//    @Override
//    @PostMapping("")
//    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
//        return orderGroupLogicService.create(request);
//    }
//
//    @Override
//    @GetMapping("{id}")
//    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
//        return orderGroupLogicService.read(id);
//    }
//
//    @PutMapping("")
//    @Override
//    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
//        return orderGroupLogicService.update(request);
//    }
//
//    @Override
//    @DeleteMapping("{id}")
//    public Header delete(@PathVariable Long id) {
//        return orderGroupLogicService.delete(id);
//    }
}
