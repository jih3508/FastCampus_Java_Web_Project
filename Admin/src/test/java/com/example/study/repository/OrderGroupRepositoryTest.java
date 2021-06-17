package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderGroup;
import com.example.study.model.enumclass.OrderType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderGroupRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){

        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setStatus("COMPLETE");
        orderGroup.setOrderType(OrderType.ALL);
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setRevName("홍길동");
        orderGroup.setPaymentType("CARD");
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer");
        //orderGroup.setUserId(1L);

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        Assertions.assertNotNull(newOrderGroup);
    }

    @Test
    public void read(){

        Optional<OrderGroup> checkOrderGroup = orderGroupRepository.findById(2L);

        assertNotNull(checkOrderGroup);
    }

    @Test
    public void update(){

        Optional<OrderGroup> findOrderGroup = orderGroupRepository.findById(2L);

        findOrderGroup.ifPresent(orderGroup -> {
            orderGroup.setOrderType(OrderType.EACH);
            orderGroup.setRevName("사나");
            orderGroup.setTotalQuantity(1);
            orderGroup.setUpdatedAt(LocalDateTime.now());
            orderGroup.setUpdatedBy("Admin02");

            OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

            assertNotNull(newOrderGroup);
            System.out.println(newOrderGroup);
        });
    }

    @Test
    void delete() {

        Optional<OrderGroup> findOrderGroup = orderGroupRepository.findById(3L);

        System.out.println(findOrderGroup);
        assertNotNull(findOrderGroup);

        findOrderGroup.ifPresent(orderGroup -> orderGroupRepository.delete(orderGroup));

        Optional<OrderGroup> checkOrderGroup = orderGroupRepository.findById(3L);

        assertFalse(checkOrderGroup.isPresent());
    }

}
