package com.ecomerce2.repositories;

import com.ecomerce2.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository  extends JpaRepository<Payments, Long> {
}
