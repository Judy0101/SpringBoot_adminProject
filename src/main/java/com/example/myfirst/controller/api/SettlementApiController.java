package com.example.myfirst.controller.api;

import com.example.myfirst.controller.CrudController;
import com.example.myfirst.ifs.CrudInterface;
import com.example.myfirst.model.entity.Settlement;
import com.example.myfirst.model.network.request.SettlementApiRequest;
import com.example.myfirst.model.network.response.SettlementApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/* Create SQL
CREATE TABLE `settlement` (
  `user_id` bigint NOT NULL,
  `price` decimal(12,4) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


INSERT INTO study.settlement (user_id, price)
	select user_id, sum(total_price) from study.order_group
    group by user_id

 */
@Slf4j
@RestController
@RequestMapping("/api/settlement")
public class SettlementApiController extends CrudController<SettlementApiRequest, SettlementApiResponse, Settlement> {
}
