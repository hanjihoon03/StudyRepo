package com.project.custom;


import com.project.apidto.UserPurchaseDto;

import java.util.List;

public interface PurchaseApiRepositoryCustom {
    List<UserPurchaseDto> purchaseList(Long id);
}
