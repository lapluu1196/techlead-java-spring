package com.dinhlap.javaspring.repository.sakila;

import com.dinhlap.javaspring.dto.sakilaDTO.Query16;
import com.dinhlap.javaspring.entity.sakila.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    @Query("SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query16(s.storeId, SUM(p.amount)) " +
            "FROM Store s " +
            "JOIN s.staffMembers st " +
            "JOIN Payment p ON st.staffId = p.staff.staffId " +
            "WHERE YEAR(p.paymentDate) = 2021 " +
            "GROUP BY s.storeId")
    List<Query16> query16();
}
