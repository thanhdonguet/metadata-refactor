package com.vcb.process.metadataupdater.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypedValueDTO {
     @JsonProperty("Value")
     private String value;

     @JsonProperty("HasValue")
     private Boolean hasValue;

     @JsonProperty("DisplayValue")
     private String displayValue;

     @JsonProperty("SerializedValue")
     private String serializedValue;

     @JsonProperty("DataType")
     private Long dataType;

     @JsonProperty("SortingKey")
     private String sortingKey;

     @JsonProperty("HasAutomaticPermission")
     private Boolean hasAutomaticPermission;
}
