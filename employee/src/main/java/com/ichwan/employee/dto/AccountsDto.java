package com.ichwan.employee.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Setter;

@Data
@Schema(name = "Accounts", description = "Accounts Dto")
public class AccountsDto {

    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    @Schema(
            description = "Account Number of employee", example = "3454433243"
    )
    @Setter(onMethod_ = @JsonIgnore)
    private Long accountNumber;

    @NotEmpty(message = "Email can not be a null or empty")
    @Schema(
            description = "Email of employee", example = "myemail@gmail.com"
    )
    private String email;

    @NotEmpty(message = "Type can not be a null or empty")
    @Schema(
            description = "Type of employee", example = "Waitress"
    )
    private String type;
}
