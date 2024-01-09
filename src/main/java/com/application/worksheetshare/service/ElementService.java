package com.application.worksheetshare.service;

import com.application.worksheetshare.entity.Element;
import com.application.worksheetshare.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.worksheetshare.service.generic.GenericService;

import java.util.List;

@Service
public class ElementService extends GenericService<Element, Long>{
    private final ElementRepository elementRepository;

    @Autowired
    public ElementService(ElementRepository elementRepository) {
        super(elementRepository);
        this.elementRepository = elementRepository;
    }

}
