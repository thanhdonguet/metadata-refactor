package com.vcb.process.metadataupdater.service.impl;

import com.vcb.process.metadataupdater.domain.PropertyDef;
import com.vcb.process.metadataupdater.dto.PropertyDefDTO;
import com.vcb.process.metadataupdater.mapper.PropertyDefMapper;
import com.vcb.process.metadataupdater.repository.PropertyDefRepository;
import com.vcb.process.metadataupdater.service.PropertyDefService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PropertyDefServiceImpl implements PropertyDefService {

    private final PropertyDefMapper propertyDefMapper;
    private final PropertyDefRepository propertyDefRepository;

    @Override
    public PropertyDefDTO save(PropertyDefDTO propertyDefDTO) {
        log.debug("Request to save PropertyDef : {}", propertyDefDTO);
        PropertyDef propertyDef = propertyDefMapper.toEntity(propertyDefDTO);
        propertyDef = propertyDefRepository.save(propertyDef);
        return propertyDefMapper.toDto(propertyDef);
    }

    @Override
    public Optional<PropertyDefDTO> partialUpdate(PropertyDefDTO propertyDefDTO) {
        log.debug("Request to partially update PropertyDef : {}", propertyDefDTO);

        return propertyDefRepository
                .findById(propertyDefDTO.getId())
                .map(existingPropertyDef -> {
                    propertyDefMapper.partialUpdate(existingPropertyDef, propertyDefDTO);
                    return existingPropertyDef;
                })
                .map(propertyDefRepository::save)
                .map(propertyDefMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PropertyDefDTO> findAll() {
        log.debug("Request to get all PropertyDef");
        return propertyDefRepository.findAll().stream()
                .map(propertyDefMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete PropertyDef : {}", id);
        propertyDefRepository.deleteById(id);
    }

    @Override
    public PropertyDefDTO findById(Integer id){
        return propertyDefRepository.findById(id)
                .map(propertyDefMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<PropertyDefDTO> findByIdIn(List<Integer> ids){
        return propertyDefRepository.findByIdIn(ids).stream().map(propertyDefMapper::toDto).collect(Collectors.toList());
    }
}
