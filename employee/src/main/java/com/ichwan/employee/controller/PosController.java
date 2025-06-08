package com.ichwan.employee.controller;

import com.ichwan.employee.dto.client.PosDetailDto;
import com.ichwan.employee.service.PosService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@Validated
public class PosController {

    public static final Logger logger = LoggerFactory.getLogger(PosController.class);
    private final PosService posService;

    //define endpoint fetchPosDetail from PosService
     @GetMapping("/fetch")
     public ResponseEntity<PosDetailDto> fetchPosDetail(@RequestHeader("pos-correlation-id") String correlationId, @RequestParam String phone) {
         logger.debug("fetchPosDetail method started");
         PosDetailDto posDetailDto = posService.fetchPosDetail(phone, correlationId);
         logger.debug("fetchPosDetail method ended");
         return ResponseEntity.status(HttpStatus.OK).body(posDetailDto);
     }
}
