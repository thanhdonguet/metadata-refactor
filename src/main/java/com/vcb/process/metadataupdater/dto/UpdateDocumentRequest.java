package com.vcb.process.metadataupdater.dto;

import lombok.Data;

import java.util.List;

@Data
public class UpdateDocumentRequest {
    private String documentId;
    private String objectStore;
    private List<PropertyDefDTO> propertyDefDTOList;
}