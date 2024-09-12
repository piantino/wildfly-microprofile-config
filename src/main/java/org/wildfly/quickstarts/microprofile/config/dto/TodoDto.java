package org.wildfly.quickstarts.microprofile.config.dto;

import lombok.Data;

@Data
public class TodoDto {
    private Long id;
    private String title;
}
