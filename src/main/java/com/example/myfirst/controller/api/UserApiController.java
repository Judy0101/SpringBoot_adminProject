package com.example.myfirst.controller.api;

import com.example.myfirst.ifs.CrudInterface;
import com.example.myfirst.model.network.Header;
import com.example.myfirst.model.network.request.UserApiRequest;
import com.example.myfirst.model.network.response.UserApiResponse;
import com.example.myfirst.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로깅 방법
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size=15) Pageable pageable){
        log.info("{}", pageable);
        return userApiLogicService.seach(pageable);
    }
    @Override
    @PostMapping("") // /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request); //-> request.toString(), ABC
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name= "id") Long id) {
        log.info("read id : { } "+ id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {

        log.info("update data : { } " + request);
        return userApiLogicService.update(request);

    }



    @Override
    @DeleteMapping("{id}") // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        log.info("delete : {}" + id);
        return userApiLogicService.delete(id);

    }
}
