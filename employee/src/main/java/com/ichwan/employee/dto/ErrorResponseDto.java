package com.ichwan.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(name = "ErrorResponse", description = "Error Response Dto")
public class ErrorResponseDto {

    @Schema(description = "API path invoked by client")
    private String apiPath;
    @Schema(description = "Status code representing the HTTP error")
    private HttpStatus statusCode;
    @Schema(description = "Message of error")
    private String message;
    @Schema(description = "Time error happened")
    private LocalDateTime errorTime;
}
