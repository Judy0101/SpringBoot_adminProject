package com.example.myfirst.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;

    //1:N

    //LAZY=지연로딩, EAGER = 즉시로딩

    // LAZY =  SELECT * FROM  item where id = ?
    // 1:N일떄 추천

    // EAGER = 연관관계 테이블 모두 조인한다. 그러므로 너무 큰 테이블에서는 지연이 일어날 수 있다.
    // 1:1 일때 추천하는 방식
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
