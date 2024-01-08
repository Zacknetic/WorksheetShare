package com.application.worksheetshare.entity;

import com.application.worksheetshare.entity.Embeddable.Base;
import com.application.worksheetshare.entity.Embeddable.Relationship;
import com.application.worksheetshare.entity.Embeddable.Transformation;

import com.application.worksheetshare.entity.Embeddable.MetaData;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "containers")
public class Container {


    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Base base;

    @Embedded
    private Transformation transformation;

    @Embedded
    private MetaData metadata;

    @ElementCollection
    @CollectionTable(name = "container_relationships", joinColumns = @JoinColumn(name = "container_id"))
    private Set<Relationship> relationships = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id")
    private Page page;





}
