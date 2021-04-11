package com.example.myfirst.controller.api;

import com.example.myfirst.controller.CrudController;
import com.example.myfirst.ifs.CrudInterface;
import com.example.myfirst.model.entity.Item;
import com.example.myfirst.model.network.Header;
import com.example.myfirst.model.network.request.ItemApiRequest;
import com.example.myfirst.model.network.response.ItemApiResponse;
import com.example.myfirst.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {



}
