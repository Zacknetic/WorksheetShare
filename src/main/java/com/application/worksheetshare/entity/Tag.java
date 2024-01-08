package com.application.worksheetshare.entity;
import java.util.*;
import java.util.HashSet;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tagcategory_id", insertable = false, updatable = false)
    private TagCategory tagCategory;
}
