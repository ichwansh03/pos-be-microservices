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
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PosServiceImpl implements PosService {

    private EmployeesRepository employeesRepository;
    private AccountsRepository accountsRepository;
    private OutletFeignClient outletFeignClient;

    @Override
    public PosDetailDto fetchPosDetail(String phone) {
        Employees employees = employeesRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Accounts accounts = accountsRepository.findByEmpId(employees.getEmpId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        //set accountsDto to posDetailDto
        PosDetailDto posDetailDto = new PosDetailDto();
        posDetailDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<OutletDto> outletes = outletFeignClient.fetchOutletDetail(phone);
        posDetailDto.setOutletDto(outletes.getBody());

        return null;
    }
}
