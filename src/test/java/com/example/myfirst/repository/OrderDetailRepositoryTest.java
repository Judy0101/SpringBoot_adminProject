package com.example.myfirst.repository;

import com.example.myfirst.MyfirstApplicationTests;
import com.example.myfirst.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends MyfirstApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());

        //어떤 사람?
        orderDetail.setUserId(7L);

        //어떤 상품?
        orderDetail.setItemId(1L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}

