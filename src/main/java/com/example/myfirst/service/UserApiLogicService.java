package com.example.myfirst.service;

import com.example.myfirst.ifs.CrudInterface;
import com.example.myfirst.model.entity.Item;
import com.example.myfirst.model.entity.OrderGroup;
import com.example.myfirst.model.entity.User;
import com.example.myfirst.model.enurmclass.UserStatus;
import com.example.myfirst.model.network.Header;
import com.example.myfirst.model.network.Pagination;
import com.example.myfirst.model.network.request.UserApiRequest;
import com.example.myfirst.model.network.response.ItemApiResponse;
import com.example.myfirst.model.network.response.OrderGroupApiResponse;
import com.example.myfirst.model.network.response.UserApiResponse;
import com.example.myfirst.model.network.response.UserOrderInfoApiResponse;
import com.example.myfirst.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderGroupLogicService orderGroupLogicService;

    @Autowired
    private ItemApiLogicService itemApiLogicService;
    // 1. request data
    // 2. user 생성
    // 3. 생성된 데이터 ->  UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {


        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        // 3. 생성된 데이터 -> userApiResponse return

        return Header.OK(response(newUser));

    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        // id -> repository getOne, getById
//        Optional<User> optional = userRepository.findById(id);

        // user -> userApiResponse return

        return userRepository.findById(id)
                .map(user -> response(user))
                .map(userApiResponse -> Header.OK(userApiResponse))
                .orElseGet( //user가 없다면
                        () -> Header.ERROR("데이터 없음")
                );



    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        //1. data
        UserApiRequest userApiRequest = request.getData();
        //2. id -> user 데이터를 찾고

        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            //3. update
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());

            return user;
            //4. userApiResponse
        })
                .map(user -> userRepository.save(user)) //update
                .map(updateUser -> response(updateUser))//userApiResponse
                .map(Header::OK)
                .orElseGet(()-> Header.ERROR("데이터 없음"));


    }

    @Override
    public Header delete(Long id) {

        // 1.id -> repository -> user
        Optional<User> optional = userRepository.findById(id);

        // 2.repository -> delete
        return optional.map(user -> {
            userRepository.delete(user);
            return Header.OK();
        })
        .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    private UserApiResponse response(User user){
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) //todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return

        return userApiResponse;
    }

    public Header<List<UserApiResponse>> seach(Pageable pageable) {

        Page<User> users = userRepository.findAll(pageable);
        List<UserApiResponse> userApiResponseList = users.stream()
                .map(user -> response(user))
                .collect(Collectors.toList());

        // List<UserApiResponse>
        // Header<List<UserApiResponse>>

        Pagination pagination = Pagination.builder()
                .totalPages(users.getTotalPages())
                .totalElements(users.getTotalElements())
                .currentPage(users.getNumber())
                .currentElements(users.getNumberOfElements())
                .build();

        return Header.OK(userApiResponseList, pagination);

    }

    public Header<UserOrderInfoApiResponse> orderInfo(Long id) {

        // user
        User user = userRepository.getOne(id);
        UserApiResponse userApiResponse = response(user);


        // orderGroup
        List<OrderGroup> orderGroupList = user.getOrderGroupList();
        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroupList.stream()
                .map(orderGroup -> {
                    OrderGroupApiResponse orderGroupApiResponse =  orderGroupLogicService.response(orderGroup).getData();

                    // item api response

                    List<ItemApiResponse> itemApiResponseList = orderGroup.getOrderDetailList().stream()
                            .map(detail -> detail.getItem())
                            .map(item -> itemApiLogicService.response(item).getData())
                            .collect(Collectors.toList());


                    orderGroupApiResponse.setItemApiResponseList(itemApiResponseList);
                    return orderGroupApiResponse;
                })

                .collect(Collectors.toList());

        userApiResponse.setOrderGroupApiResponseList(orderGroupApiResponseList);

        UserOrderInfoApiResponse userOrderInfoApiResponse = UserOrderInfoApiResponse.builder()
                .userApiResponse(userApiResponse)
                .build();

        return Header.OK(userOrderInfoApiResponse);
        // item
     //   List<Item> itemList = orderGroup.

    }
}
