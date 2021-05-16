package com.example.study.model.entity;


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

    // 1 : N
    // LAZY = 지연로딩, EAGER = 즉시로딩

    // 연관관계에서 설정에서 select 안함
    //LAZE = SELECT * FROM item where id =?

    // EAGER = 연관관계에 설정된 모든 테이블을 select해서 조인을 한다.
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    //where item.id = ?
    // JOIN item item0_

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
