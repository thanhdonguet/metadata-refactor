package com.vcb.process.metadataupdater.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoggingDTO {
    private Long id;
    private String content;
    private LocalDateTime logTime;
    private String markError;
}