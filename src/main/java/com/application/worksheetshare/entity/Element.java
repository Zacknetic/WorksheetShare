package com.application.worksheetshare.entity;

import com.application.worksheetshare.entity.Embeddable.Base;
import com.application.worksheetshare.entity.Embeddable.MetaData;
import com.application.worksheetshare.entity.Embeddable.Relationship;
import com.application.worksheetshare.entity.Embeddable.Transformation;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "elements")
public class Element {

    public enum ElementType {
    TEXTBOX, IMAGE, CODE_CONTEXT_WINDOW, EQUATION, GRID
}

    // Constructor for byte array content
    public Element(Base base, Transformation transformation, MetaData metaData, MultipartFile imageFile) throws IOException {

        initializeCommonFields(base.getName(), transformation, metaData.getCreatedBy(), ElementType.IMAGE);
       String url = this.saveImage(imageFile);
       this.setUrlContent(url);
    }

    // Constructor for String content
    public Element(Base base, Transformation transformation, MetaData metaData, String content) {
        initializeCommonFields(base.getName(), transformation, metaData.getCreatedBy(), ElementType.TEXTBOX);
        this.setTextContent(content);
    }

    private String saveImage(MultipartFile imageFile) throws IOException {
        // Define the path where you want to save the files
        Path path = Paths.get("C:\\Users\\zack\\Pictures\\WorksheetShare\\" + imageFile.getOriginalFilename());
        Files.copy(imageFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        // Return the URL to access the file
        return "/getImage/" + imageFile.getOriginalFilename();
    }

    // Private method to handle common initialization
    private void initializeCommonFields(String name, Transformation transformation, String creatorUsername, ElementType elementType) {
        this.metadata = new MetaData();
        this.base = new Base();
        this.metadata.setCreationDate(new Date());
        this.metadata.setLastModifiedDate(new Date());
        this.metadata.setCreatedBy(creatorUsername);
        this.metadata.setModifiedBy(creatorUsername);
        this.base.setName(name);
        this.setTransformation(transformation);
        this.elementType = elementType;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Base base;

    @Embedded
    private Transformation transformation;

    @ElementCollection
    @CollectionTable(name = "element_relationships", joinColumns = @JoinColumn(name = "element_id"))
    private Set<Relationship> relationships = new HashSet<>();

    @Embedded
    private MetaData metadata;

    @Enumerated(EnumType.STRING) // Store the enum as a string
    private ElementType elementType;

    @Lob
    private byte[] imageContent; // For storing text, use String. For binary data (like images), use byte[].

    @Lob
    private String textContent; // For storing text, use String. For binary data (like images), use byte[].
    @Lob
    private String urlContent; // For storing text, use String. For binary data (like images), use byte[].
}