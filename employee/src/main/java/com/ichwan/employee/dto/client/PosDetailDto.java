package com.ichwan.employee.dto.client;

import com.ichwan.employee.dto.AccountsDto;
import lombok.Data;

@Data
public class PosDetailDto {

    private AccountsDto accountsDto;
    private OutletDto outletDto;
}
