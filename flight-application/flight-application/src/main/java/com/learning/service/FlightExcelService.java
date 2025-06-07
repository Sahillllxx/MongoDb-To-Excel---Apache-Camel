package com.learning.service;

import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FlightExcelService {

    private final ProducerTemplate producerTemplate;

    public byte[] generateExcelFile(Map<String, Object> filter) throws IOException {
        File excelFile = producerTemplate.requestBody("direct:generateExcel", filter, File.class);

        if (excelFile == null || !excelFile.exists()) {
            throw new RuntimeException("Excel file generation failed.");
        }

        return Files.readAllBytes(excelFile.toPath());
    }

    public String getExcelFileName() {
        return "flights.xlsx";
    }
}
