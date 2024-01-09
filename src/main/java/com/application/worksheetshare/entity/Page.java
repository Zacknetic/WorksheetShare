//package com.application.worksheetshare.entity;
//
//import com.application.worksheetshare.entity.Embeddable.MetaData;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@RequiredArgsConstructor
//@Entity
//@Table(name = "pages")
//public class Page {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "worksheet_id")
//    private Worksheet worksheet;
//
//    @OneToMany(mappedBy = "pages", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Container> containers = new HashSet<>();
//
//    @Embedded
//    private MetaData metaData;
//}
