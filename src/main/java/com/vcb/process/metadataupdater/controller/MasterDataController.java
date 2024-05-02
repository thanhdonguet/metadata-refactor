package com.vcb.process.metadataupdater.controller;

import com.vcb.process.metadataupdater.dto.LoggingDTO;
import com.vcb.process.metadataupdater.service.LoggingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class MasterDataController {
    private final LoggingService loggingService;

    public MasterDataController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    /**
     * {@code GET  /logging} : get all the logging.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of logging in body.
     */
    @GetMapping("/error-log")
    public List<LoggingDTO> findByMarkError() {
        log.debug("REST request to get all mark error Logging");
        return loggingService.findByMarkError("Y");
    }
}
