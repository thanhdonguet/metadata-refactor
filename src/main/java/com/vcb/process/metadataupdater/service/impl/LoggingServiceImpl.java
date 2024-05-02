package com.vcb.process.metadataupdater.service.impl;

import com.vcb.process.metadataupdater.domain.Logging;
import com.vcb.process.metadataupdater.dto.LoggingDTO;
import com.vcb.process.metadataupdater.mapper.LoggingMapper;
import com.vcb.process.metadataupdater.repository.LoggingRepository;
import com.vcb.process.metadataupdater.service.LoggingService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LoggingServiceImpl implements LoggingService {

    private final LoggingMapper loggingMapper;
    private final LoggingRepository loggingRepository;

    @Override
    public LoggingDTO save(LoggingDTO loggingDTO) {
        log.debug("Request to save Logging : {}", loggingDTO);
        Logging logging = loggingMapper.toEntity(loggingDTO);
        logging = loggingRepository.save(logging);
        return loggingMapper.toDto(logging);
    }

    @Override
    public Optional<LoggingDTO> partialUpdate(LoggingDTO loggingDTO) {
        log.debug("Request to partially update Logging : {}", loggingDTO);

        return loggingRepository
                .findById(loggingDTO.getId())
                .map(existingLogging -> {
                    loggingMapper.partialUpdate(existingLogging, loggingDTO);
                    return existingLogging;
                })
                .map(loggingRepository::save)
                .map(loggingMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoggingDTO> findAll() {
        log.debug("Request to get all Logging");
        return loggingRepository.findAll().stream().map(loggingMapper::toDto).collect(Collectors.toCollection(LinkedList::new));

    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Logging : {}", id);
        loggingRepository.deleteById(id);
    }

    @Override
    public List<LoggingDTO> findByMarkError(String markError){
        log.debug("Request to find all Error Logging : ");
        return loggingRepository.findByMarkError(markError)
                .stream()
                .map(loggingMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));

    }
}
