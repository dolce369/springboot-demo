package com.igiya.springbootdemo.api.xlsx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
// import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.igiya.springbootdemo.model.Person;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Full Name", "SSN", "Sex" };
    static String SHEET = "Tutorials";

    // 
    public static ByteArrayInputStream toExcel(List<Person> students){

        try(XSSFWorkbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();) {

            Sheet sheet = workbook.createSheet(SHEET);
            Row header = sheet.createRow(0);      
            for(int i=0; i<HEADERs.length; i++){
                header.createCell(i).setCellValue(HEADERs[i]);
            }
            int index = 1;
            for(Person s : students){
                Row r = sheet.createRow(index);
                index++;
                r.createCell(0).setCellValue(s.getId());
                r.createCell(1).setCellValue(s.getFullName());
                r.createCell(2).setCellValue(s.getSsn());
                r.createCell(3).setCellValue(s.getSex());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());     
        }catch(IOException exception){
           throw new RuntimeException(exception.getMessage());
        }
       
    }
   
}
