package com.ichwan.employee.controller;

import com.ichwan.employee.dto.client.PosDetailDto;
import com.ichwan.employee.service.PosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class PosController {

    //define PosService
    private PosService posService;

    //define endpoint fetchPosDetail from PosService
     @GetMapping("/fetch")
     public ResponseEntity<PosDetailDto> fetchPosDetail(@RequestParam String phone) {
         PosDetailDto posDetailDto = posService.fetchPosDetail(phone);
         return ResponseEntity.status(HttpStatus.OK).body(posDetailDto);
     }
}
