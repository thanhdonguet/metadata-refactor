package com.vcb.process.metadataupdater.controller;

import com.vcb.process.metadataupdater.dto.LoggingDTO;
import com.vcb.process.metadataupdater.dto.PropertyDefDTO;
import com.vcb.process.metadataupdater.service.LoggingService;
import com.vcb.process.metadataupdater.service.PropertyDefService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class MasterDataController {
    private final LoggingService loggingService;
    private final PropertyDefService propertyDefService;

    public MasterDataController(LoggingService loggingService, PropertyDefService propertyDefService) {
        this.loggingService = loggingService;
        this.propertyDefService = propertyDefService;
    }

    @GetMapping("/error-log")
    public List<LoggingDTO> findByMarkError() {
        log.debug("REST request to get all mark error Logging");
        return loggingService.findByMarkError("Y");
    }

    @GetMapping("/all-log")
    public List<LoggingDTO> findAll() {
        log.debug("REST request to get all Logging");
        return loggingService.findAll();
    }

    @GetMapping("/find/{id}")
    public PropertyDefDTO findById(@PathVariable Integer id) {
        log.debug("REST request to propertyDef name by id");
        return propertyDefService.findById(id);
    }

    @GetMapping("/all-propertydef")
    public List<PropertyDefDTO> findAllPropertyDef() {
        log.debug("REST request to get all propertyDef");
        return propertyDefService.findAll();
    }
}
