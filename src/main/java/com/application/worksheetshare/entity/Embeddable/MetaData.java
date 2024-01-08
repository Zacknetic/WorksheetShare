package com.application.worksheetshare.entity.Embeddable;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Embeddable
public class MetaData {

    private Date creationDate;
    private Date lastModifiedDate;
    private String createdBy; //TODO: update data type to 'User'
    private String modifiedBy;
}
