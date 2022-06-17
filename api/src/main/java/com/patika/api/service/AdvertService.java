package com.patika.api.service;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdvertService {
    SaleAdvertisement createAdvert(SaleAdvertisement saleAdvertisement, Long userId);

    List<SaleAdvertisement> getAllByUser(Long userId);

    SaleAdvertisement save(SaleAdvertisement advertisement);
}
