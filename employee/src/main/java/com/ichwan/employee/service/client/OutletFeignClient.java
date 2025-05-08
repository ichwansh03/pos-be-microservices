package com.ichwan.employee.service.client;

import com.ichwan.employee.dto.client.OutletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "outlet", fallback = OutletFallback.class)
public interface OutletFeignClient {

    //call controller method from client
    @GetMapping(value="/api/fetch", consumes="application/json")
    public ResponseEntity<OutletDto> fetchOutletDetail(@RequestHeader("pos-correlation-id") String correlationId, @RequestParam String phone);
}
