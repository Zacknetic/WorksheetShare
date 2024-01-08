package com.application.worksheetshare.entity;

import com.application.worksheetshare.entity.Embeddable.Base;
import com.application.worksheetshare.entity.Embeddable.MetaData;
import com.application.worksheetshare.entity.Embeddable.Relationship;
import com.application.worksheetshare.entity.Embeddable.Transformation;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

enum ElementType {
    TEXTBOX, IMAGE, CODE_CONTEXT_WINDOW, EQUATION, GRID
}

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "elements")
public class Element {

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
    private String content; // For storing text, use String. For binary data (like images), use byte[].

}