package com.vcb.process.metadataupdater.service;

import com.vcb.process.metadataupdater.dto.PropertyDefDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.vcb.process.metadataupdater.domain.PropertyDef}.
 */
public interface PropertyDefService {
    /**
     * Save a propertyDef.
     *
     * @param propertyDefDTO the entity to save.
     * @return the persisted entity.
     */
    PropertyDefDTO save(PropertyDefDTO propertyDefDTO);

    /**
     * Partially updates a propertyDef.
     *
     * @param propertyDefDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PropertyDefDTO> partialUpdate(PropertyDefDTO propertyDefDTO);

    /**
     * Get all the propertyDef.
     *
     * @return the list of entities.
     */
    List<PropertyDefDTO> findAll();


    /**
     * Delete the "id" propertyDef.
     *
     * @param id the id of the entity.
     */
    void delete(Integer id);

    PropertyDefDTO findById(Integer id);

    List<PropertyDefDTO> findByIdIn (List<Integer> ids);
}
