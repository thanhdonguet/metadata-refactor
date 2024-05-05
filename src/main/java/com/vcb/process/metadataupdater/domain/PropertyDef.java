package com.vcb.process.metadataupdater.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "property_def")
@Data
public class PropertyDef {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "meta_data")
    private String metaData;
}