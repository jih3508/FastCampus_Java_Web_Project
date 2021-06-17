package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(), type);
        Assertions.assertEquals(newCategory.getTitle(), title);

    }

    @Test
    public void read(){

        String type = "COMPUTER";

        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        // select * from category where type = 'COMPUTER';

        optionalCategory.ifPresent(c -> {

            Assertions.assertEquals(c.getType(), type);

            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }

    @Test
    public void update(){
        Optional<Category> optionalCategory = categoryRepository.findById(2L);

        optionalCategory.ifPresent( category -> {
            category.setType("MOBILE_PHONE");
            category.setUpdatedAt(LocalDateTime.now());
            category.setUpdatedBy("SmartPhone CEO");

            categoryRepository.save(category);
        });

        Optional<Category> category = categoryRepository.findByType("MOBILE_PHONE");
        category.ifPresent(checkCategory -> {
            System.out.println(checkCategory);
        });

        assertTrue(category.isPresent());
    }

    @Test
    void delete(){
        Optional<Category> optionalCategory = categoryRepository.findById(3L);

        assertNotNull(optionalCategory);

        optionalCategory.ifPresent(category -> {
            System.out.println(category);
            categoryRepository.delete(category);
        });

        Optional<Category> category = categoryRepository.findById(3L);

        assertFalse(category.isPresent());
    }


}
