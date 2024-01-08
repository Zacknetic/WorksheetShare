package com.application.worksheetshare.service;

import com.application.worksheetshare.entity.Worksheet;
import com.application.worksheetshare.repository.WorksheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksheetService {

    @Autowired
    private WorksheetRepository worksheetRepository;

    public List<Worksheet> findAllWorksheets() {
        return worksheetRepository.findAll();
    }
}
