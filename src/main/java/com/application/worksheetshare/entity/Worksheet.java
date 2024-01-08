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
@Table(name = "worksheets")
public class Worksheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String title;

    @Column(name = "targetAgeRange")
    private int[] targetAgeRange;

    @Column(name = "durationMinutes")
    private int durationMinutes;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "worksheets_tag", joinColumns = {@JoinColumn(name = "worksheet_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "worksheets_sheetcontent", joinColumns = {@JoinColumn(name = "worksheet_id")}, inverseJoinColumns = {@JoinColumn(name = "sheetcontent_id")})
    private Set<SheetContent> sheetContent = new HashSet<>();
}
