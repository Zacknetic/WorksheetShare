//package com.application.worksheetshare.entity;
//import java.util.*;
//import java.util.HashSet;
//import jakarta.persistence.*;
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@RequiredArgsConstructor
//@Entity
//@Table(name = "tags")
//public class Tag {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NonNull
//    @Column(name = "name", length = 100, nullable = false, unique = true)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "tag-category_id", insertable = false, updatable = false)
//    private TagCategory tagCategory;
//
//    @ManyToMany(mappedBy = "tags", cascade = CascadeType.MERGE)
//    private Set<Worksheet> worksheets = new HashSet<>();
//
//    @ManyToMany(mappedBy = "tags", cascade = CascadeType.MERGE)
//    private Set<Page> pages = new HashSet<>();
//
//    @ManyToMany(mappedBy = "tags", cascade = CascadeType.MERGE)
//    private Set<Container> containers = new HashSet<>();
//
//    @ManyToMany(mappedBy = "tags", cascade = CascadeType.MERGE)
//    private Set<Element> elements = new HashSet<>();
//}
