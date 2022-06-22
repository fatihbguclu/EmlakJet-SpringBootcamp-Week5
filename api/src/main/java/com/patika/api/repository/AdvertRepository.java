package com.patika.api.repository;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<SaleAdvertisement, Long> {
    List<SaleAdvertisement> getAllByUser(User user);
    List<SaleAdvertisement> findSaleAdvertisementsByTitleContainingIgnoreCase(String title);
    List<SaleAdvertisement> findSaleAdvertisementsByDetailsContainingIgnoreCase(String detail);
    List<SaleAdvertisement> findSaleAdvertisementsByCreatedAtOrderByCreatedAtAsc(LocalDateTime time);
    List<SaleAdvertisement> findSaleAdvertisementsByCreatedAtOrderByCreatedAtDesc(LocalDateTime time);
    List<SaleAdvertisement> findSaleAdvertisementsByPriceBetween(String price1, String price2);
}
