package com.learning.process;

import com.learning.config.ExcelProperties;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ExcelGeneratorProcessor implements Processor {

    private final ExcelProperties excelProperties;


    @Override
    public void process(Exchange exchange) throws Exception {

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = exchange.getIn().getBody(List.class);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("flights");

        Row header = sheet.createRow(0);
        if (!data.isEmpty()) {
            Map<String, Object> firstRow = data.get(0);
            int col = 0;
            for (String key : firstRow.keySet()) {
                header.createCell(col++).setCellValue(key);
            }
        }

        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i + 1);
            Map<String, Object> rowData = data.get(i);
            int col = 0;
            for (Object value : rowData.values()) {
                row.createCell(col++).setCellValue(value != null ? value.toString() : "");
            }
        }

        File file = new File(excelProperties.getOutputPath());
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }
        workbook.close();

        exchange.getIn().setBody(file);
    }
}
