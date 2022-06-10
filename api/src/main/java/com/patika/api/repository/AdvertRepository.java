package com.patika.api.repository;

import com.patika.api.domain.SaleAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<SaleAdvertisement, Long> {
}
