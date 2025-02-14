package com.ichwan.outlet.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Accounts", description = "Accounts Dto")
public record OutletDto(
        Long outletId,
        @NotEmpty(message = "Name cannot be a null or empty")
        @Schema(description = "Name of outlet") String name,
        @NotEmpty(message = "Address cannot be a null or empty")
        @Schema(description = "Address of outlet") String address,
        @NotEmpty(message = "Phone cannot be a null or empty")
        @Schema(description = "Phone of outlet") String phone,
        @NotNull(message = "Total employee cannot be a null or empty")
        @Schema(description = "Total employee of outlet") Integer totalEmployees,
        @NotEmpty(message = "Created by cannot be a null or empty")
        @Schema(description = "Created data of outlet") String createdBy
) {
}
