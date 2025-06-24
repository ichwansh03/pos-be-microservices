package com.ichwan.outlet.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "outlet")
@Component
@Getter
@Setter
public class OutletInfoDto {

    private String message;
    private Map<String, String> contactDetails;
}
