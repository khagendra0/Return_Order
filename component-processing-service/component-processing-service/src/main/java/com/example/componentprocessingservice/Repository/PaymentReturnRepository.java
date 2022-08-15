package com.example.componentprocessingservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.componentprocessingservice.Entity.PaymentReturnEntity;

public interface PaymentReturnRepository extends JpaRepository<PaymentReturnEntity,Integer> {

}
