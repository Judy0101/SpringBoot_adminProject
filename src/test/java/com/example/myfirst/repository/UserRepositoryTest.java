package com.example.myfirst.repository;


import com.example.myfirst.MyfirstApplicationTests;
import com.example.myfirst.model.entity.Item;
import com.example.myfirst.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends MyfirstApplicationTests {

    //Dependency Injection(DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        String account = "Test03";
        String password = "Test01";
        String status = "REGISTERD";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
//        user.setCreatedAt(createdAt);
//        user.setCreatedBy(createdBy);

// builder을 이용하면 생성자를 따로만들지 않아도 된다. => Lombok의 builder 패턴
        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);




    }

    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
//      업데이트 chin 패턴

//        user
//                .setEmail("")
//                .setPhoneNumber("")
//                .setStatus("");
//
//        User u = new User("").setAccount("").setEmail("");

        if(user != null){
            user.getOrderGroupList().stream().forEach(orderGroup -> {


                System.out.println("-------------------주문 묶음 --------------");
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("-------------주문 상세---------");

                orderGroup.getOrderDetailList().forEach(orderDetail -> {
//                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
//                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품 : "+orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " +orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());



                });

            });
        }

        Assert.assertNotNull(user);

    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional
    //데이터 베이스에서 롤백을 시켜 실질적으로 영향 no
    public void delete(){
        Optional<User> user = userRepository.findById(2L);

        Assert.assertTrue(user.isPresent());
        //삭제되기 위해서는 존재해야함

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
        
        Optional<User> deletUser = userRepository.findById(2L);
        
        Assert.assertFalse(deletUser.isPresent());
    }
}
