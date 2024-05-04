package com.vcb.process.metadataupdater.mapper;

import com.vcb.process.metadataupdater.domain.PropertyDef;
import com.vcb.process.metadataupdater.dto.PropertyDefDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link PropertyDef} and its DTO {@link PropertyDefDTO}.
 */
@Mapper(componentModel = "spring")
public interface PropertyDefMapper extends EntityMapper<PropertyDefDTO, PropertyDef> {

//    PropertyDefDTO toDto(PropertyDef entity);
//    PropertyDef toEntity(PropertyDefDTO dto);
}