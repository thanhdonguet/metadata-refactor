package com.vcb.process.metadataupdater.mapper;

import com.vcb.process.metadataupdater.domain.Logging;
import com.vcb.process.metadataupdater.dto.LoggingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper for the entity {@link Logging} and its DTO {@link com.vcb.process.metadataupdater.dto.LoggingDTO}.
 */
@Mapper(componentModel = "spring")
public interface LoggingMapper extends EntityMapper<LoggingDTO, Logging> {

    LoggingDTO toDto(Logging entity);
    Logging toEntity(LoggingDTO dto);
}