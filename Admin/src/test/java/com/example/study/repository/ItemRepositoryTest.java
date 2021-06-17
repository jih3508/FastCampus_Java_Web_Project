package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.enumclass.ItemStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private  ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus(ItemStatus.REGISTERED);
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북 입니다.");
        item.setPrice(BigDecimal.valueOf(900000));
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        //item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);

    }

    @Test
    public  void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);
        Assertions.assertTrue(item.isPresent());
    }

    @Test
    void update(){
        Optional<Item> updateItem = itemRepository.findByTitle("삼성 겔럭시 S20");

        updateItem.ifPresent(item -> {
            item.setPrice(BigDecimal.valueOf(100000));
            item.setContent("2020년형 스마트폰 S 시리즈 입니다.");
            item.setUpdatedAt(LocalDateTime.now());
            item.setUpdatedBy("Partner02");

            Item saveItem = itemRepository.save(item);

            System.out.println(saveItem);
            assertNotNull(saveItem);
        });
    }

    @Test
    void delete(){

        Optional<Item> deleteItem = itemRepository.findById(3L);

        System.out.println(deleteItem);
        assertNotNull(deleteItem);

        deleteItem.ifPresent(item -> itemRepository.delete(item));

        Optional<Item> checkItem = itemRepository.findById(3L);


        assertFalse(checkItem.isPresent());
    }
}
