package com.patika.api.service;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface AdvertService {
    SaleAdvertisement createAdvert(SaleAdvertisement saleAdvertisement, Long userId);
    List<SaleAdvertisement> getAllByUser(Long userId);
    List<SaleAdvertisement> findSaleAdvertisementsByTitleContainingIgnoreCase(String title);
    List<SaleAdvertisement> findSaleAdvertisementsByDetailsContainingIgnoreCase(String detail);
    List<SaleAdvertisement> findSaleAdvertisementsByCreatedAtOrderByCreatedAtAsc(LocalDateTime time);
    List<SaleAdvertisement> findSaleAdvertisementsByCreatedAtOrderByCreatedAtDesc(LocalDateTime time);
    List<SaleAdvertisement> findSaleAdvertisementsByPriceBetween(String price1, String price2);

}
