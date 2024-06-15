package com.custom;



import com.base.item.*;
import com.dto.BookAndFileDto;
import com.dto.ClothesAndFileDto;
import com.dto.ElectronicsAndFileDto;
import com.dto.FoodAndFileDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ItemRepositoryCustom{
//    List<BookAndFileDto> findBookWithUploadFile();
//    List<ClothesAndFileDto> findClothesWithUploadFile();
//    List<ElectronicsAndFileDto> findElectronicsWithUploadFile();
//    List<FoodAndFileDto> findFoodWithUploadFile();

    List<Item> findItemsByUserId(Long userId);
    Book findBook(Long id);
    Clothes findClothes(Long id);
    Electronics findElectronics(Long id);
    Food findFood(Long id);

    //paging
    Page<BookAndFileDto> pagingBook(Pageable pageable);
    Page<ClothesAndFileDto> pagingClothes(Pageable pageable);
    Page<FoodAndFileDto> pagingFood(Pageable pageable);
    Page<ElectronicsAndFileDto> pagingElectronics(Pageable pageable);




}
