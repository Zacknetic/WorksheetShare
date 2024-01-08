package com.application.worksheetshare.entity.Embeddable;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Embeddable
public class Relationship {

    private String relationshipType; // e.g., "alignment", "anchoring"
    private Long targetElementId; // ID of the other element involved in the relationship

    // Other attributes depending on the relationship type
    private String alignmentType; // e.g., "left", "right", "center"
    private float distance; // For proximity relationships
    private int zIndex; // For stacking order
}
