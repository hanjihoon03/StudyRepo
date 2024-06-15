package com.custom;


import com.apidto.UserPurchaseDto;

import java.util.List;

public interface PurchaseApiRepositoryCustom {
    List<UserPurchaseDto> purchaseList(Long id);
}
