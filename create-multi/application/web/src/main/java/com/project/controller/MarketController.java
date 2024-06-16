package com.project.controller;

import com.project.User;
import com.project.subdomain.Tier;
import com.project.SessionConst;
import com.project.dto.ItemDto;
import com.project.dto.MarketPayDtoV2;
import com.project.service.MarketService;
import com.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class MarketController {

    private final MarketService marketService;
    private final UserService userService;


    /**
     * 사용자의 장바구니를 구매하기 전 목록을 확인하고 user의 할인 적용시 금액과 총 가격을 보여주는 컨트롤러
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/purchase")
    public String purchase(Model model, HttpSession session) {
        User user = (User) session.getAttribute(SessionConst.LOGIN_USER);

        List<MarketPayDtoV2> shoppingBasket = marketService.purchaseItem(user.getId());
        model.addAttribute("items", shoppingBasket);

        int totalPrice = marketService.purchaseTotalPrice(shoppingBasket, user);
        model.addAttribute("totalPrice", totalPrice);
        Tier userTier = userService.findUserTier(user.getId());

        int discountAmount = marketService.discountAmount(totalPrice, userTier);
        model.addAttribute("discount", discountAmount);

        return "order/purchase";
    }


    /**
     * purchase의 성능 최적화 이전 컨트롤러로 차이를 테스트하기 위해 살려둔 컨트롤러
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/purchaseV2")
    public String purchaseV2(Model model, HttpSession session) {
        User user = (User) session.getAttribute(SessionConst.LOGIN_USER);

        List<ItemDto> itemDtos = marketService.purchaseItemV2(session);
        model.addAttribute("items", itemDtos);

        int totalPrice = marketService.purchaseTotalPriceV2(itemDtos, user);
        model.addAttribute("totalPrice", totalPrice);

        Tier userTier = userService.findUserTier(user.getId());


        int discountAmount = marketService.discountAmount(totalPrice, userTier);
        model.addAttribute("discount", discountAmount);

        return "order/purchaseV2";
    }


    /**
     * 장바구니 목록에서 삭제하기 윈하는 아이템을 삭제하는 컨트롤러
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/purchase/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        // 삭제 작업 수행
        User user = (User) session.getAttribute(SessionConst.LOGIN_USER);

        marketService.deleteMarketItem(id, user.getId());

        // 삭제 후 목록 페이지로 redirect
        return "redirect:/purchase";
    }

    @GetMapping("/buy")
    public String buyItem() {

        return "order/kakaopay";
    }


}
