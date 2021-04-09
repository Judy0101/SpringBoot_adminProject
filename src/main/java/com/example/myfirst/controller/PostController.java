package com.example.myfirst.controller;

import com.example.myfirst.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
     //HTML <Form>
    //ajax 검색
    // http post body -> data
    // json, xml, mutipart-form/ text-plain

    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){

        return searchParam;
    }


}
