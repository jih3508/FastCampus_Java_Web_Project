package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderDetailRepositotyTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));

        //orderDetail.setOrderGroupId(1L); // 장바구니
        //orderDetail.setItemId(1L);      // 상품품

        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }

    @Test
    public void read(){
        Optional<OrderDetail> findOrderDetail = orderDetailRepository.findById(1L);

        findOrderDetail.ifPresent(orderDetail->{
            System.out.println(orderDetail);
        });

        assertNotNull(findOrderDetail);
    }

    @Test
    public void update() {
        Optional<OrderDetail> findOrderDetail = orderDetailRepository.findById(2L);

        System.out.println(findOrderDetail);
        assertNotNull(findOrderDetail);

        findOrderDetail.ifPresent(orderDetail -> {
            orderDetail.setArrivalDate(orderDetail.getArrivalDate().plusDays(1));
            orderDetail.setUpdatedAt(LocalDateTime.now());
            orderDetail.setUpdatedBy("Admin01");

            OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);

            System.out.println(orderDetail);
            assertNotNull(orderDetail);
        });
    }

    @Test
    public void delete(){
        Optional<OrderDetail> findOrderDetail = orderDetailRepository.findById(3L);

        System.out.println(findOrderDetail);
        findOrderDetail.ifPresent(orderDetail -> orderDetailRepository.delete(orderDetail));
        Optional<OrderDetail> checkOrderDetail = orderDetailRepository.findById(3L);

        assertFalse(checkOrderDetail.isPresent());
    }

}
