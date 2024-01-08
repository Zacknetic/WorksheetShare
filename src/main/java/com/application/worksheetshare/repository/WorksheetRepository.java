package com.application.worksheetshare.repository;

import com.application.worksheetshare.entity.Worksheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorksheetRepository extends JpaRepository<Worksheet, Long>, JpaSpecificationExecutor<Worksheet> {
    List<Worksheet> findByNameContaining(String name);
}
