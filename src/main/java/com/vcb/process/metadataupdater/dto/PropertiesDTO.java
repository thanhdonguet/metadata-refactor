package com.vcb.process.metadataupdater.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class PropertiesDTO {
    @JsonProperty("Properties")
    private List<PropertyDTO> properties;
}
