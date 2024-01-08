package com.application.worksheetshare.entity.Embeddable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Transformation {
    private Long containerId;
    private float xPosition;  // X-coordinate on the page
    private float yPosition;  // Y-coordinate on the page
    private float width;
    private float height;
    private float rotation;   // In degrees
    private int zIndex;

    //TODO: scale (fixed / unfixed)

}
