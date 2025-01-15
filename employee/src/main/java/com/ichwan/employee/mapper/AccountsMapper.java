package com.ichwan.employee.mapper;

import com.ichwan.employee.dto.AccountsDto;
import com.ichwan.employee.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setEmail(accounts.getEmail());
        accountsDto.setType(accounts.getType());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setEmail(accountsDto.getEmail());
        accounts.setType(accountsDto.getType());
        return accounts;
    }
}
