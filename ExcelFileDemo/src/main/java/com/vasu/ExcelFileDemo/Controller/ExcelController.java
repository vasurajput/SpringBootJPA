/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.ExcelFileDemo.Controller;

import com.vasu.ExcelFileDemo.Model.ExcelModel;
import com.vasu.ExcelFileDemo.Model.ExcelModelMapper;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.Column;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rv
 */
@RestController
public class ExcelController {

    private static final Logger logger = LoggerFactory.getLogger("ExcelController.class");

    @Autowired
    private JdbcTemplate template;

    @GetMapping("/")
    public String excelTest() {
        try {
            List<ExcelModel> query = template.query("select * from user", new ExcelModelMapper());
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("lawix10");
            HSSFRow rowhead = sheet.createRow((short) 0);

            rowhead.createCell((short) 0).setCellValue("CellHeadName1");
            rowhead.createCell((short) 1).setCellValue("CellHeadName2");

            int i = 1;
            for (ExcelModel model : query) {
                HSSFRow row = sheet.createRow((short) i);
                row.createCell((short) 0).setCellValue(model.getEmailid());
                row.createCell((short) 1).setCellValue(model.getPassword());

                System.out.println("email= " + model.getEmailid());
                System.out.println("password= " + model.getPassword());
                i++;
            }
            String location = "C:\\Users\\rv\\Desktop\\test.xls";
            FileOutputStream fileOut = new FileOutputStream(location);
            workbook.write(fileOut);
            fileOut.close();
            return "success in DB";
        } catch (Exception e) {
            logger.error("Error", e);
            return "error in DB";
        }

    }
}
