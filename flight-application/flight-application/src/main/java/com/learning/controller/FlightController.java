package com.learning.controller;

import com.learning.service.FlightExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/v1/flights")
@RestController
@RequiredArgsConstructor
public class FlightController {

    private final FlightExcelService flightExcelService;

    @PostMapping("/generate-excel")
    public ResponseEntity<byte[]> generateExcel(@RequestBody Map<String, Object> filter) throws Exception {
            byte[] fileContent = flightExcelService.generateExcelFile(filter);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + flightExcelService.getExcelFileName() + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM).body(fileContent);
    }
}
