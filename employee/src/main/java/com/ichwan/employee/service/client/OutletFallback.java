package com.ichwan.employee.service.client;

import com.ichwan.employee.dto.client.OutletDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class OutletFallback implements OutletFeignClient{

    @Override
    public ResponseEntity<OutletDto> fetchOutletDetail(String correlationId, String phone) {
        return null;
    }
}
