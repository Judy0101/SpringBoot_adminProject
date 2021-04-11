package com.example.myfirst.controller.api;

import com.example.myfirst.ifs.CrudInterface;
import com.example.myfirst.model.network.Header;
import com.example.myfirst.model.network.request.UserApuRequest;
import com.example.myfirst.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApuRequest, UserApiResponse> {


    @Override
    @PostMapping("") // /api/user
    public Header<UserApiResponse> create(@RequestBody UserApuRequest userApuRequest) {
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name= "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(@RequestBody UserApuRequest request) {
        return null;
    }



    @Override
    @DeleteMapping("{id}") // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
