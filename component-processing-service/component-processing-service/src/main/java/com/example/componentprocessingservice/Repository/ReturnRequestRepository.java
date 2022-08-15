package com.example.componentprocessingservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.componentprocessingservice.Entity.ReturnRequestEntity;

@Repository
public interface ReturnRequestRepository extends JpaRepository<ReturnRequestEntity,Integer> {
	
	

}
