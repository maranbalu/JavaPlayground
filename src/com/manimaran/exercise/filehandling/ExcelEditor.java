package com.manimaran.exercise.filehandling;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ExcelEditor {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Excel Editor! Please enter the path to the Excel file you wish to edit.");

        String currentDirectory = System.getProperty("user.dir");
        String excelPath = currentDirectory + "\\" + "InputExcel.xls";  // Update this path as per your file location
        System.out.println("Excel path to enter: " + excelPath);

        String filePath = scanner.nextLine();

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        System.out.println("File loaded successfully! Here are its contents:");
        printSheetContents(sheet);

        System.out.println("Would you like to add data to this file? Enter 'Yes' to proceed or 'No' to exit.");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("Yes")) {
            System.out.println("Great! Please enter the row number, column number and the data you would like to add, separated by spaces.");
            String[] inputs = scanner.nextLine().split(" ");
            int rowNumber = Integer.parseInt(inputs[0]) - 1;
            int columnNumber = Integer.parseInt(inputs[1]) - 1;
            String data = inputs[2];

            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                row = sheet.createRow(rowNumber);
            }
            Cell cell = row.getCell(columnNumber, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellValue(data);

            System.out.println("Data added successfully! The file now looks like this:");
            printSheetContents(sheet);

            System.out.println("Would you like to save these changes? Enter 'Yes' to save or 'No' to discard changes.");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("Yes")) {
                FileOutputStream fos = new FileOutputStream(filePath);
                workbook.write(fos);
                fos.close();
                System.out.println("Changes saved successfully! Thank you for using the Excel Editor.");
            }
        }
        workbook.close();
        fis.close();
    }

    private static void printSheetContents(Sheet sheet) {
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = new DataFormatter().formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
    }
}
