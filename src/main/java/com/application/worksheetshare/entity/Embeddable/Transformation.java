package com.application.worksheetshare.entity.Embeddable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Transformation {

    private float x_coordinate;  // X-coordinate on the page
    private float y_coordinate;  // Y-coordinate on the page
    private float width;
    private float height;
    private float rotation;   // In degrees
    private int z_index;

    //TODO: scale (fixed / unfixed)

}
