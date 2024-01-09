package com.application.worksheetshare.entity.Embeddable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
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
