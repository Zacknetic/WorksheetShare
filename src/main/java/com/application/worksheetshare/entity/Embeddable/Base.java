package com.application.worksheetshare.entity.Embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Embeddable
public class Base {

    @NonNull
    @Column(name = "name", length = 100)
    private String name;

}
