package com.patika.messaging.repository;

import com.patika.messaging.domain.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO,Long> {
    @Query(
            value = "SELECT * FROM users ORDER BY random() LIMIT 1",
            nativeQuery = true)
    UserDTO getRandomUser();
}
