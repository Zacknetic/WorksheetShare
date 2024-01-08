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
@Table(name = "tagCategories")
public class TagCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String title;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "tagcategory_tags", joinColumns = {@JoinColumn(name = "tagcategory_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tag = new HashSet<>();
}
