package com.iptech.dreamhousingloan.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iptech.dreamhousingloan.model.Cibil;
import com.iptech.dreamhousingloan.model.Enquiry;


@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{




    @Query("SELECT e FROM Enquiry e WHERE e.cibilScore IS NULL")

public  List<Enquiry> findByCibilScore();




	




}
