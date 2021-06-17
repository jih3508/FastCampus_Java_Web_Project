package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParterRepositoryTest extends StudyApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        //Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        //partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);
        Assertions.assertNotNull(newPartner);
        Assertions.assertEquals(newPartner.getName(), name);

    }

    @Test
    public void read(){
        Optional<Partner> partner = partnerRepository.findByBusinessNumber("1234567890123");

        assertTrue(partner.isPresent());


    }

    @Test
    void update(){
        Optional<Partner> updatePartner = partnerRepository.findById(2L);

        updatePartner.ifPresent(partner -> {
            partner.setName("Partner02");
            partner.setCeoName("이지은");
            partner.setAddress("성남 판교");
            partner.setUpdatedAt(LocalDateTime.now());
            partner.setUpdatedBy("IU fan");

            Partner savePartner = partnerRepository.save(partner);

            System.out.println(savePartner);
        });
    }

    @Test
    void delete(){
        Optional<Partner> deletePartner = partnerRepository.findByBusinessNumber("123412341234");

        System.out.println("삭제될 레코드:" + deletePartner);

        deletePartner.ifPresent(partner -> partnerRepository.delete(partner));

        Optional<Partner> checkPartner =  partnerRepository.findById(3L);

        assertFalse(checkPartner.isPresent());

    }



}
