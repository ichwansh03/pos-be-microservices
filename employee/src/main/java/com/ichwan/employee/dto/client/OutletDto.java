package com.ichwan.employee.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Accounts", description = "Accounts Dto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutletDto {

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

        @NotNull(message = "Total employee cannot be a null or empty")
        @Schema(description = "Total employee of outlet")
        private Integer totalEmployees;

        @NotEmpty(message = "Created by cannot be a null or empty")
        @Schema(description = "Created data of outlet")
        private String createdBy;

        @NotEmpty(message = "Updated by cannot be a null or empty")
        @Schema(description = "Updated data of outlet")
        private String updatedBy;
}