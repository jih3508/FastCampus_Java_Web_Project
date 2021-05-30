package com.example.study.work2;

import com.example.study.model.entity.OrderGroup;
import com.example.study.model.network.Header;
import com.example.study.repository.OrderGroupRepository;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SettlementApiLogicService {

    @Autowired
    SettlementRepository settlementRepository;

    @Autowired
    OrderGroupRepository orderGroupRepository;

    @Autowired
    UserRepository userRepository;


    public Header<SettlementApiResponse> read(Long id) {

        return settlementRepository.findById(id).map(settlement -> response(settlement))
                .orElseGet(()->{
                    userRepository.findById(id).ifPresent( user -> {


                        // settlement 생성
                       Settlement settlement = Settlement.builder()
                                .id(user.getId())
                                .price(BigDecimal.valueOf(2000))
                                .build();
                        // 저장
                        settlementRepository.save(settlement);
                        }
                    );
                    return Header.ERROR("User 아이디가 없습니다.");
                });
    }

    private Header<SettlementApiResponse> response(Settlement settlement){
        SettlementApiResponse settlementApiResponse = SettlementApiResponse.builder()
                .id(settlement.getId())
                .price(settlement.getPrice())
                .build();
        
        return Header.OK(settlementApiResponse);
    }
}
