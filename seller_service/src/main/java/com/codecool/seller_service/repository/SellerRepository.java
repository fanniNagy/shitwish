package com.codecool.seller_service.repository;

import com.codecool.seller_service.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findSellerById(Long id);

    @Query(value = "DELETE FROM Seller s where s.id = :id")
    void deleteSellerById(@Param("id") long id);



}
