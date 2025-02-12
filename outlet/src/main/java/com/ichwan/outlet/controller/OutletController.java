package com.ichwan.outlet.controller;

import com.ichwan.outlet.service.OutletService;
import lombok.AllArgsConstructor;
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
public class OutletController {

    private OutletService outletService;

    /*@GetMapping
    public ResponseEntity<?> getPaginatedOutlet(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

    }*/
}
