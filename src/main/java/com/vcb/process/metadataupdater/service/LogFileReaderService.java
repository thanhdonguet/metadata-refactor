package com.vcb.process.metadataupdater.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class LogFileReaderService {
    @Value("${vcb.batch.input.location}")
    private String inputLocation;

    @Async
    public void extractAllDocIds() {
        File directory = new File(inputLocation);
        File[] files = directory.listFiles();
        log.info("Processing files in directory: {} with number of files: {}", directory.getAbsolutePath(), files.length);
        Arrays.stream(files)
                .sorted(Comparator.comparing(File::getName))
                .forEach(this::processOneFile);
    }

    /**
     *  new Job
     var failedLog = docIdRepo.findAllSuccessFalse();

         for (log : logExtracted) {
         try {
             var response = callThirdParty(log);
             updateLogSuccessTrue(log);
             saveThirdPartyResponse(response);
         }
         catch(RuntimeException e) {
             log.error();
         }
     */

    private void processOneFile(File file) {
        var docIds = extractDocIdFromOneFile(file);
        /**TODO: save docId into logExtractedDb
         var logExtracted = docIdRepo.saveAll(docIds);
         file.delete();x
         for (log : logExtracted) {
           try {
                var response = callThirdParty(log);
                updateLogSuccessTrue(log);
                logic id -> 3rdPartyResponse -> metaData -> saveDB
                call api ECM -> save metadata
            }
            catch(RuntimeException e) {
                updateLogSuccessFalse(log);
            }
         */
    }

    private void saveDocId(Set<String> docIds) {
        //TODO: save docIds into db
    }
    private static final String LOG_PATTERN = "^update\\.{5}(\\d+)\\.{5}[^.]+$";
    public Set<String> extractDocIdFromOneFile(File file) {
        log.info("Processing file: {}", file.getName());
        Set<String> docIds = new HashSet<>();
        byte[] fileDataByteArray = null;
        try {
            fileDataByteArray = FileUtils.readFileToByteArray(file);
            String logContent =  new String(fileDataByteArray, StandardCharsets.UTF_8);

            // Define the pattern to match the DocID
            Pattern pattern = Pattern.compile("update\\.{5}(\\d+)(\\.\\.\\.\\.\\.+\\w+)?");
            // Extract the DocIDs using regex matching
            Matcher matcher = pattern.matcher(logContent);
            while (matcher.find()) {
                String docId = matcher.group(0);
                Matcher matcher2 = Pattern.compile(LOG_PATTERN).matcher(docId);
                if (matcher2.matches()) {
                    docId = matcher2.group(1);
                    docIds.add(docId);
                }
            }
            return docIds;

        } catch (IOException e) {
            log.error("Error processing file {}", file.getName(), e);
            return new HashSet<>();
        }
    }
}