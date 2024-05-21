package com.vcb.process.metadataupdater.controller;

import com.vcb.process.metadataupdater.service.LogFileReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class FileController {
    private final LogFileReaderService logFileReaderService;

    public FileController(LogFileReaderService logFileReaderService) {
        this.logFileReaderService = logFileReaderService;
    }

    @PutMapping("/read-docid")
    public ResponseEntity<?> getDocIds() {
        logFileReaderService.extractAllDocIds();
        return ResponseEntity.ok().build();
    }
}
