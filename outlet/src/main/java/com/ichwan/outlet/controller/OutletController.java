package com.ichwan.outlet.controller;

import com.ichwan.outlet.dto.OutletDto;
import com.ichwan.outlet.dto.OutletInfoDto;
import com.ichwan.outlet.mapper.ComponentMapper;
import com.ichwan.outlet.service.OutletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@Validated
public class OutletController {

    private final OutletService outletService;
    private final OutletInfoDto outletInfoDto;

    @Value("${info.app.version}")
    private String version;

    @GetMapping
    public ResponseEntity<?> getPaginatedOutlet(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<OutletDto> outletDtos = ComponentMapper.mapEntitiesToModels(outletService.getOutlets(page, size).stream().toList(), OutletDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(outletDtos);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getOutletByName(@PathVariable String name) {
        OutletDto outletDto = ComponentMapper.mapEntityToModel(outletService.getOutletByName(name), OutletDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(outletDto);
    }

    @PostMapping
    public ResponseEntity<?> createOutlet(@Valid @RequestBody OutletDto outletDto) {
        OutletDto model = ComponentMapper.mapEntityToModel(outletService.createOutlet(outletDto), OutletDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOutlet(@RequestBody OutletDto outletDto, @PathVariable Long id) {
        OutletDto dto = ComponentMapper.mapEntityToModel(outletService.updateOutlet(outletDto, id), OutletDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOutlet(@PathVariable Long id) {
        outletService.deleteOutlet(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("successfully remove data with id "+id);
    }

    @GetMapping("/outlet-info")
    public ResponseEntity<OutletInfoDto> getEmployeeInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(outletInfoDto);
    }

    @GetMapping("/version-info")
    public ResponseEntity<String> getVersionInfo() {
        return ResponseEntity.status(HttpStatus.OK).body("Version " + version);
    }
}
