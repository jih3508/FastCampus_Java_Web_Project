package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.AdminUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdminUserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create(){
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("AdminUser02");
        adminUser.setPassword("AdminUser02");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");
        /*adminUser.setCreatedAt(LocalDateTime.now());
       adminUser.setCreatedBy("AdminServer");*/

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        Assertions.assertNotNull(newAdminUser);

        newAdminUser.setAccount("CHANGE");
        adminUserRepository.save(newAdminUser);
    }

    @Test
    void read(){

        Optional<AdminUser> checkAdminUser = adminUserRepository.findById(2L);

        assertNotNull(checkAdminUser);
    }

    @Test
    void update(){

        Optional<AdminUser> checkAdminUser = adminUserRepository.findById(2L);

        checkAdminUser.ifPresent(adminUser -> {
            adminUser.setRole("MASTER");
            adminUser.setUpdatedAt(LocalDateTime.now());
            adminUser.setUpdatedBy("AdminSeverManage01");

            AdminUser newAdminUser = adminUserRepository.save(adminUser);
            System.out.println(newAdminUser);
            assertNotNull(newAdminUser);
        });
    }

    @Test
    void delete(){

        Optional<AdminUser> checkAdminUser = adminUserRepository.findById(3L);

        System.out.println(checkAdminUser);
        assertNotNull(checkAdminUser);

        checkAdminUser.ifPresent(adminUser -> adminUserRepository.delete(adminUser));

        checkAdminUser = adminUserRepository.findById(3L);

        assertNotNull(checkAdminUser);
    }
}
