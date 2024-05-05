package com.vcb.process.metadataupdater.service.impl;


import com.vcb.process.metadataupdater.dto.PropertiesDTO;
import com.vcb.process.metadataupdater.dto.PropertyDTO;
import com.vcb.process.metadataupdater.dto.TypedValueDTO;
import com.vcb.process.metadataupdater.service.PropertiesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@Service
@RequiredArgsConstructor
@Slf4j
public class PropertiesServiceImpl implements PropertiesService {

    @Override
    public PropertiesDTO getPropResponse(){
        // Mock Service to get data
        TypedValueDTO typedValueDTO1 = TypedValueDTO.builder()
                .value("210531")
                .build();
        TypedValueDTO typedValueDTO2 = TypedValueDTO.builder()
                .value("VCB")
                .build();
        TypedValueDTO typedValueDTO3 = TypedValueDTO.builder()
                .value("ODC-Outward Documentary Collection")
                .build();
        TypedValueDTO typedValueDTO4 = TypedValueDTO.builder()
                .value("9AAAU30058")
                .build();
        PropertyDTO propertyDTO1 = PropertyDTO.builder()
                .typedValue(typedValueDTO1)
                .propertyDef(1019)
                .contentType(0)
                .build();
        PropertyDTO propertyDTO2 = PropertyDTO.builder()
                .typedValue(typedValueDTO2)
                .propertyDef(1035)
                .contentType(0)
                .build();
        PropertyDTO propertyDTO3 = PropertyDTO.builder()
                .typedValue(typedValueDTO3)
                .propertyDef(1020)
                .contentType(0)
                .build();
        PropertyDTO propertyDTO4 = PropertyDTO.builder()
                .typedValue(typedValueDTO4)
                .propertyDef(1029)
                .contentType(0)
                .build();
        return PropertiesDTO.builder()
                .properties(Arrays.asList(propertyDTO1, propertyDTO2, propertyDTO3, propertyDTO4))
                .build();
    }
}
