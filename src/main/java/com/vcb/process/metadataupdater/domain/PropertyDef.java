package com.vcb.process.metadataupdater.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "property_def")
@Data
public class PropertyDef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}