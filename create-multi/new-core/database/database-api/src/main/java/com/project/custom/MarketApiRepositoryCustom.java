package com.project.custom;


import com.project.dto.ItemDto;

import java.util.List;

public interface MarketApiRepositoryCustom{
    List<ItemDto> findItemAndFile(List<Long> itemIds, Long userId);
    List<ItemDto> findItemAndFileRefactor(Long userId);
}
