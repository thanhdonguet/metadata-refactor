package com.vcb.process.metadataupdater.domain;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(name = "logging")
@Data
public class Logging{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "log_time")
    private LocalDateTime logTime;

    @Column(name = "mark_error")
    private String markError;

}