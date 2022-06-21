package com.patika.messaging.repository;

import com.patika.messaging.domain.SaleAdvertisementDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<SaleAdvertisementDTO, Long> {
}
