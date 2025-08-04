package com.nerdtic.humanos.typeContrat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TypeContratCreateRequest {
    private String title;
    private String description;
}
