package com.example.myfirst.model.enurmclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;


@AllArgsConstructor
@Getter
public enum  OrderType {

    ALL(0, "묶음", "모든 상품을 묶음"),
    EACH(1,"개별", "모든 상품을 준비되는 대로 발송")
    ;

    private Integer id;
    private String title;
    private String description;


}
