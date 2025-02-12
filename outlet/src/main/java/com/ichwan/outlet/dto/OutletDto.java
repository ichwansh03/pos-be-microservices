package com.ichwan.outlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Setter;

@Data
@Schema(name = "Accounts", description = "Accounts Dto")
public class OutletDto {

    @Setter(onMethod_ = @JsonIgnore)
    private Long outletId;

    @NotEmpty(message = "Name cannot be a null or empty")
    @Schema(description = "Name of outlet")
    private String name;

    @NotEmpty(message = "Address cannot be a null or empty")
    @Schema(description = "Address of outlet")
    private String address;

    @NotEmpty(message = "Phone cannot be a null or empty")
    @Schema(description = "Phone of outlet")
    private String phone;

    @NotEmpty(message = "total employee cannot be a null or empty")
    @Schema(description = "total employee of outlet")
    private Integer totalEmployee;
}
