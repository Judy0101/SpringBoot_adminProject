package com.example.myfirst.service;

import com.example.myfirst.ifs.CrudInterface;
import com.example.myfirst.model.network.Header;
import com.example.myfirst.model.network.request.UserApuRequest;
import com.example.myfirst.model.network.response.UserApiResponse;
import com.example.myfirst.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService implements CrudInterface<UserApuRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    // 1. request data
    // 2. user 생성
    // 3. 생성된 데이터 ->  UserApiResponse return
    @Oerride
    public Header<UserApiResponse> create(UserApuRequest request) {
        return null;
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(UserApuRequest request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
