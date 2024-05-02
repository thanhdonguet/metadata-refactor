package com.vcb.process.metadataupdater.controller;

import com.vcb.process.metadataupdater.service.LogFileReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class FileController {
    private final LogFileReaderService logFileReaderService;

    public FileController(LogFileReaderService logFileReaderService) {
        this.logFileReaderService = logFileReaderService;
    }

    @PostMapping("/process-files")
    public ResponseEntity<List<String>> processFiles(@RequestParam("files") List<MultipartFile> files) throws IOException {
        try {
            List<String> resultsSet = new ArrayList<>();
            for (MultipartFile file : files) {
                String fileData = new String(file.getBytes());
                // Process the file data using logFileReader
                var result = logFileReaderService.readLogFile(fileData);
                resultsSet.add(result);
            }
            return ResponseEntity.ok(resultsSet);
        } catch (IOException e) {
            log.error("Error while read log file: ", e);
            throw e;
        }
    }
}
