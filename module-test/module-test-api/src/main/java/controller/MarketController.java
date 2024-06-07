package controller;

import lombok.RequiredArgsConstructor;
import market.Market;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BizService;

@RestController
@RequiredArgsConstructor
public class MarketController {
    private final BizService bizService;

    @GetMapping("/market")
    public String saveMarket() {
        Market market = new Market("item1",100);
        return "OK";
    }
}
