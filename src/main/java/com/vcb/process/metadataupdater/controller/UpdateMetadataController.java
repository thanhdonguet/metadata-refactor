package com.vcb.process.metadataupdater.controller;

import com.vcb.process.metadataupdater.dto.PropertyDefDTO;
import com.vcb.process.metadataupdater.service.MetaDataRefactoringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UpdateMetadataController {
    private final MetaDataRefactoringService metaDataRefactoringService;

    public UpdateMetadataController(MetaDataRefactoringService metaDataRefactoringService) {
        this.metaDataRefactoringService = metaDataRefactoringService;
    }

    @GetMapping("/mapping-propdef")
    public List<PropertyDefDTO> findAllPropertyDef() {
        log.debug("check mapping value and id propertyRef - metadata");
        return metaDataRefactoringService.mappingMetadata();
    }
}
