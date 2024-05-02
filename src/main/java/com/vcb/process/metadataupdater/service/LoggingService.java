package com.vcb.process.metadataupdater.service;

import com.vcb.process.metadataupdater.dto.LoggingDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.vcb.process.metadataupdater.domain.Logging}.
 */
public interface LoggingService {
    /**
     * Save a logging.
     *
     * @param loggingDTO the entity to save.
     * @return the persisted entity.
     */
    LoggingDTO save(LoggingDTO loggingDTO);

    /**
     * Partially updates a logging.
     *
     * @param loggingDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<LoggingDTO> partialUpdate(LoggingDTO loggingDTO);

    /**
     * Get all the logging.
     *
     * @return the list of entities.
     */
    List<LoggingDTO> findAll();


    /**
     * Delete the "id" logging.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<LoggingDTO> findByMarkError(String markError);
}
