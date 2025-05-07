package com.ecomerce2.repositories;

import com.ecomerce2.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentsRepository  extends JpaRepository<Payments, Long> {
     Optional<Payments> findById(Long id);

}
