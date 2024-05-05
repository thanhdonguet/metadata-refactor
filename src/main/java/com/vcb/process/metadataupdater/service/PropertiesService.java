package com.vcb.process.metadataupdater.service;

import com.vcb.process.metadataupdater.dto.PropertiesDTO;
import com.vcb.process.metadataupdater.dto.PropertyDefDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.vcb.process.metadataupdater.domain.PropertyDef}.
 */
public interface PropertiesService {
    PropertiesDTO getPropResponse();
}
