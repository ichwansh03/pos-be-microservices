package com.ichwan.employee.service;

import com.ichwan.employee.dto.AccountsDto;
import com.ichwan.employee.dto.client.OutletDto;
import com.ichwan.employee.dto.client.PosDetailDto;
import com.ichwan.employee.entity.Accounts;
import com.ichwan.employee.entity.Employees;
import com.ichwan.employee.mapper.AccountsMapper;
import com.ichwan.employee.repository.AccountsRepository;
import com.ichwan.employee.repository.EmployeesRepository;
import com.ichwan.employee.service.client.OutletFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PosServiceImpl implements PosService {

    private EmployeesRepository employeesRepository;
    private AccountsRepository accountsRepository;
    private OutletFeignClient outletFeignClient;

    @Override
    @Retryable(
            retryFor = {RuntimeException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 2000, multiplier = 2, maxDelay = 10_000) // Retry with exponential backoff
    )
    public PosDetailDto fetchPosDetail(String phone, String correlationId) {
        Employees employees = employeesRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Accounts accounts = accountsRepository.findByEmpId(employees.getEmpId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        //set accountsDto to posDetailDto
        PosDetailDto posDetailDto = new PosDetailDto();
        posDetailDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<OutletDto> outletes = outletFeignClient.fetchOutletDetail(correlationId, phone);
        posDetailDto.setOutletDto(outletes.getBody());

        return null;
    }
}
