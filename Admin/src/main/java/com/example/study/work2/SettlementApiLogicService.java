package com.example.study.work2;

import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.repository.ItemRepository;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SettlementApiLogicService {

    @Autowired
    SettlementRepository settlementRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    // 회원 생성시 Settlement도 같이 생성된다.
    public void create(Long userId){

        Settlement settlement = Settlement.builder()
                .id(userId)
                .price(BigDecimal.ONE) // 생성시 0으로 초기화 한다.
                .build();

        settlementRepository.save(settlement);
    }

    // 누계 조회
    public Header<SettlementApiResponse> read(Long id) {

        return settlementRepository.findById(id).map(settlement -> response(settlement))
                .orElseGet(()-> Header.ERROR("User 아이디가 없습니다."));
    }

    //물건 구입하면 새로 추가 한다.
    public Header<SettlementApiResponse> updateTotalPrice(Long userId, Long itemId) throws NullPointerException{

        // 아이템과 유저의 정보를 찾아 낸다.
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Item> itemOptional = itemRepository.findById(itemId);

        if(userOptional.isPresent() && itemOptional.isPresent()){
            BigDecimal price = itemOptional.get().getPrice(); // 아이템의 값을 추가 한다.

            return settlementRepository.findById(userId)
                    .map(settlement ->{
                        settlement.setPrice(settlement.getPrice().add(price));
                        return settlement;
                    })
                    .map(settlement -> settlementRepository.save(settlement))
                    .map(this::response)
                    .orElseGet(()->Header.ERROR("No Data!!"));
        }
        return Header.ERROR("데이터 없습니다");
    }

    private Header<SettlementApiResponse> response(Settlement settlement){
        SettlementApiResponse settlementApiResponse = SettlementApiResponse.builder()
                .id(settlement.getId())
                .price(settlement.getPrice())
                .build();
        
        return Header.OK(settlementApiResponse);
    }
}
