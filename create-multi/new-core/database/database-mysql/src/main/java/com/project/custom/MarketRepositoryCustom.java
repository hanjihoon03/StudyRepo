package com.project.custom;


import com.project.dto.ItemDto;
import com.project.dto.MarketPayDto;
import com.project.dto.MarketPayDtoV2;

import java.util.List;

public interface MarketRepositoryCustom {

     List<ItemDto> findItemAndFile(List<Long> itemIds, Long userId);
     void deleteMarketOfItem(Long itemId, Long userId);
     void deleteMarketOfUser(Long userId);
     List<MarketPayDto> shoppingBasket(Long id);

     List<MarketPayDtoV2> shoppingBasketV2(Long id);


}
