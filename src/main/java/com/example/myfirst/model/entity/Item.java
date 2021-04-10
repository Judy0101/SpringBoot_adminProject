package com.example.myfirst.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderDetailList", "partner"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // Item N : 1 Partner
    @ManyToOne
    private Partner partner;
    
    // Item 1 : N OrderDetail
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;


    //1:N

    //LAZY=지연로딩, EAGER = 즉시로딩

    // LAZY =  SELECT * FROM  item where id = ?
    // 1:N일떄 추천

    // EAGER = 연관관계 테이블 모두 조인한다. 그러므로 너무 큰 테이블에서는 지연이 일어날 수 있다.
    // 1:1 일때 추천하는 방식
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?


}
