package com.ichwan.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Schema(name = "Response", description = "Response Dto")
@Data @AllArgsConstructor
public class ResponseDto {

    @Schema(description = "Status HTTP code")
    private HttpStatus statusCode;
    @Schema(description = "Status message from response")
    private String message;
}
