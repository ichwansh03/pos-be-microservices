package com.ichwan.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Employees",
        description = "Employees Dto"
)
public class EmployeesDto {

    @Schema(description = "Name of the employee")
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "Length of name should be between 5-30 characters")
    private String name;

    @Schema(description = "Address of the employee")
    @NotEmpty(message = "Address cannot be null or empty")
    private String address;

    @Schema(description = "Age of the employee")
    @NotEmpty(message = "Age cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Age should be a number")
    private String age;

    @Schema(description = "Phone of the employee", example = "085766689697")
    @NotEmpty(message = "Phone cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String phone;

    @Schema(description = "Placement outlet of employee")
    private String inBranch;

    @Schema(description = "Account detail of the employee")
    private AccountsDto accountsDto;
}
