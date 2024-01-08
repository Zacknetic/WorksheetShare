package com.application.worksheetshare.service;

import com.application.worksheetshare.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementService {
    private final ElementRepository elementRepository;

    @Autowired
    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public List<Element> findAllElements() {
        return elementRepository.findAll();
    }

    public Element findElementByID(Long id) {
        return elementRepository.findById(id).orElseThrow(() -> new RuntimeException("Element with id (" + id + ") not found."));
    }
//
//    public void addElement(Element element) {
//        elementRepository.save(element);
//    }
//
//    public void updateElement(Element element) {
//        elementRepository.save(element);
//    }
//
//    public String deleteElementById(Long id) {
//        Element element = elementRepository.findById(id).orElseThrow(() -> new RuntimeException("Element with id (" + id + ") not found."));
//        elementRepository.delete(element);
//
//        retur
}
