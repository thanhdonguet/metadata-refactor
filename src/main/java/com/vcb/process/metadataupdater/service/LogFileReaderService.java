package com.vcb.process.metadataupdater.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Service
public class LogFileReaderService {
    public String readLogFile(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        byte[] fileData = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return new String(fileData, StandardCharsets.UTF_8);
    }
    public Set<String> extractDocIds(MultipartFile logFile) throws IOException {
        Set<String> docIds = new HashSet<>();

        // Read the log file content
        String logContent = new String(logFile.getBytes());

        // Define the pattern to match the DocID
        Pattern pattern = Pattern.compile("attach\\.\\.\\.\\. (\\d+)");

        // Extract the DocIDs using regex matching
        Matcher matcher = pattern.matcher(logContent);
        while (matcher.find()) {
            String docId = matcher.group(1);
            docIds.add(docId);
        }

        return docIds;
    }
}