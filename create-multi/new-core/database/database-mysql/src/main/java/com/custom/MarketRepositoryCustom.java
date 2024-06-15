package com.custom;


import com.dto.ItemDto;
import com.dto.MarketPayDto;
import com.dto.MarketPayDtoV2;

import java.util.List;

public interface MarketRepositoryCustom {

     List<ItemDto> findItemAndFile(List<Long> itemIds, Long userId);
     void deleteMarketOfItem(Long itemId, Long userId);
     void deleteMarketOfUser(Long userId);
     List<MarketPayDto> shoppingBasket(Long id);

     List<MarketPayDtoV2> shoppingBasketV2(Long id);


}
