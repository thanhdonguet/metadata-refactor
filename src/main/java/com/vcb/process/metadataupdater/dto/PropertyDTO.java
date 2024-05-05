package com.vcb.process.metadataupdater.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyDTO {
    @JsonProperty("TypedValue")
    private TypedValueDTO typedValue;

    @JsonProperty("PropertyDef")
    private Integer propertyDef;

    @JsonProperty("ContentType")
    private Integer contentType;
}
