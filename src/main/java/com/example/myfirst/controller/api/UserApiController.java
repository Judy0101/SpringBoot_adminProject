package com.example.myfirst.controller.api;

import com.example.myfirst.ifs.CrudInterface;
import com.example.myfirst.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {


    @Override
    @PostMapping("") // /api/user
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header read(@PathVariable(name= "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header update() {
        return null;
    }



    @Override
    @DeleteMapping("{id}") // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }
}