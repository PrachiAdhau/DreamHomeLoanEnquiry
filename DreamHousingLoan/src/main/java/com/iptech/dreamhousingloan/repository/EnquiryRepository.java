package com.iptech.dreamhousingloan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.iptech.dreamhousingloan.model.Enquiry;

import jakarta.transaction.Transactional;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	


}
