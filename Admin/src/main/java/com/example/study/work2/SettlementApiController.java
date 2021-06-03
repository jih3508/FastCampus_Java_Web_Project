package com.example.study.work2;

import com.example.study.model.network.Header;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/settlement")
public class SettlementApiController {

    private SettlementApiLogicService settlementApiLogicService;

    @GetMapping("{id}")
    public Header<SettlementApiResponse> read(@PathVariable(name = "id") Long id){
        return settlementApiLogicService.read(id);
    }
}
