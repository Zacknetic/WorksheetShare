package com.application.worksheetshare.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.application.worksheetshare.entity.*;
import com.application.worksheetshare.entity.Embeddable.Base;
import com.application.worksheetshare.entity.Embeddable.MetaData;
import com.application.worksheetshare.entity.Embeddable.Transformation;
import com.application.worksheetshare.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/elements")
public class ElementController {
    private final ElementService elementService;

    @Autowired
    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    // POST endpoint for uploading an image
    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(
            @RequestPart(value = "content") MultipartFile content,
            @RequestPart("base") String baseJson,
            @RequestPart("metaData") String metaDataJson,
            @RequestPart("transformation") String transformationJson) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Base base = objectMapper.readValue(baseJson, Base.class);
        MetaData metaData = objectMapper.readValue(metaDataJson, MetaData.class);
        Transformation transformation = objectMapper.readValue(transformationJson, Transformation.class);

        // Handle the image file and other data
        if (content != null && !content.isEmpty()) {
//            byte[] imageBytes = content.getBytes();

            // Create an Element object and set the fields
            Element element = new Element(base, transformation, metaData, content);

            // Save the Element object using service layer
            Element savedElement = elementService.save(element);

            return ResponseEntity.ok(savedElement);
        } else {
            return ResponseEntity.badRequest().body("Image file is missing");
        }
    }

    @PostMapping("/text")
    public ResponseEntity<?> uploadText(
            @RequestPart(value = "content") String content,
            @RequestPart("base") String baseJson,
            @RequestPart("metaData") String metaDataJson,
            @RequestPart("transformation") String transformationJson) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Base base = objectMapper.readValue(baseJson, Base.class);
        MetaData metaData = objectMapper.readValue(metaDataJson, MetaData.class);
        Transformation transformation = objectMapper.readValue(transformationJson, Transformation.class);

        // Handle the image file and other data
        if (content != null && !content.isEmpty()) {
            // Create an Element object and set the fields
            Element element = new Element(base, transformation, metaData, content);

            // Save the Element object using service layer
            Element savedElement = elementService.save(element);

            return ResponseEntity.ok(savedElement);
        } else {
            return ResponseEntity.badRequest().body("Text is missing");
        }
    }

//     GET: Retrieve all elements
    @GetMapping
    public ResponseEntity<List<Element>> findAllElements() {
        List<Element> elements = elementService.findAll();
        return ResponseEntity.ok(elements);
    }

    // GET: Retrieve a single element by ID
    @GetMapping("/{id}")
    public ResponseEntity<Element> findElementById(@PathVariable Long id) {
        Element element = elementService.findById(id);
        return ResponseEntity.ok(element);
    }


//    // PUT: Update an existing element
//    @PutMapping("/{id}")
//    public ResponseEntity<Element> updateElement(@PathVariable Long id, @RequestBody Element element) {
//        Element updatedElement = elementService.save(element);
//        return ResponseEntity.ok(updatedElement);
//    }
//
//    // DELETE: Delete an element
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteElementById(@PathVariable Long id) {
//        elementService.deleteById(id);
//        return ResponseEntity.ok("Element successfully deleted with id: " + id);
//    }
}

