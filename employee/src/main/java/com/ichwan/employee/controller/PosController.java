package com.ichwan.employee.controller;

import com.ichwan.employee.dto.client.PosDetailDto;
import com.ichwan.employee.service.PosService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class PosController {

    public static final Logger logger = LoggerFactory.getLogger(PosController.class);
    private PosService posService;

    //define endpoint fetchPosDetail from PosService
     @GetMapping("/fetch")
     public ResponseEntity<PosDetailDto> fetchPosDetail(@RequestHeader("pos-correlation-id") String correlationId, @RequestParam String phone) {
            logger.info("fetchPosDetail called with correlationId: {} and phone: {}", correlationId, phone);
         PosDetailDto posDetailDto = posService.fetchPosDetail(phone, correlationId);
         return ResponseEntity.status(HttpStatus.OK).body(posDetailDto);
     }
}
