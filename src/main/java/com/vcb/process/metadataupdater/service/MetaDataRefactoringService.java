package com.vcb.process.metadataupdater.service;

import com.vcb.process.metadataupdater.dto.PropertiesDTO;
import com.vcb.process.metadataupdater.dto.PropertyDTO;
import com.vcb.process.metadataupdater.dto.PropertyDefDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MetaDataRefactoringService  {
    private final PropertiesService propertiesService;
    private final PropertyDefService propertyDefService;

    public List<PropertyDefDTO> mappingMetadata(){
        PropertiesDTO propertiesDTO = propertiesService.getPropResponse();
        List<Integer> listPropertyDef = propertiesDTO.getProperties().stream()
                .map(PropertyDTO::getPropertyDef)
                .toList();
        List<PropertyDefDTO> propertyDefDTOS = propertyDefService.findByIdIn(listPropertyDef);
        for (int i = 0; i < propertyDefDTOS.size(); i++){
            for (int j = 0; j < propertiesDTO.getProperties().size(); j++){
                if (propertyDefDTOS.get(i).getId().equals(propertiesDTO.getProperties().get(j).getPropertyDef())){
                    propertyDefDTOS.get(i).setMetaDataDetail(propertiesDTO.getProperties().get(j).getTypedValue().getValue());
                }
            }
        }
        return propertyDefDTOS;
    }
}
