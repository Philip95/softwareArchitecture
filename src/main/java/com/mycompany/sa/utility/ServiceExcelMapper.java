package com.mycompany.sa.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ServiceExcelMapper {

    private File filename;

    public ServiceExcelMapper() {}
    public ServiceExcelMapper(File filename) {
        this.filename = filename;
    }

    private XSSFWorkbook loadWorkbook() throws IOException {
        return new XSSFWorkbook(Files.newInputStream(this.filename.toPath())).getSheetAt(0).getWorkbook();
    }

    public List<String> readWorkbook() throws IOException {
        List<String> res = new ArrayList<>();
        XSSFWorkbook workbook = loadWorkbook();
        for (Sheet sheet : workbook) {
            res = loadRows(sheet);
        }
        return res;
    }

    private List<String> loadRows(Sheet sheet) {
        List<String> res = new ArrayList<>();
        for (Row row : sheet){
            if(row.getRowNum() != 0) {
                res.add(loadCells(row));
            }
        }
        return ListHelper.removeEmptyElements(res);
    }

    /**
     * Returns a list of cells
     * @param row Rows of the Excel sheet
     * @return list of Strings
     */
    private String loadCells(Row row) {
        String res = "";
        for (Cell cell : row) {
            if(!cell.toString().equals("") || cell.toString() != null) {
                res = cell.toString();
            }
        }
        return res;
    }
}