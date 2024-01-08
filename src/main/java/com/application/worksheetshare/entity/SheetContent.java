package com.application.worksheetshare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tags")
public class SheetContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
