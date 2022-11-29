package com.mycompany.sa.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ServiceDependencyHelper {
    private File filename;

    public ServiceDependencyHelper() {}

    private static Logger logger = Logger.getLogger(ServiceDependencyHelper.class.getName());

    public ServiceDependencyHelper(File filename) {
        this.filename = filename;
    }

    private XSSFWorkbook loadWorkbook() throws IOException {
        return new XSSFWorkbook(Files.newInputStream(this.filename.toPath())).getSheetAt(0).getWorkbook();
    }

    public void readWorkbook() throws IOException {
        XSSFWorkbook workbook = loadWorkbook();
        for (Sheet sheet : workbook) {
            loadRows(sheet);
        }
    }

    private void loadRows(Sheet sheet) throws IOException {
        Map<String, Map<String, Double>> dependencies = new HashMap<>();
        FileHandler fileHandler = new FileHandler("app.log", true);
        logger.addHandler(fileHandler);
        for (Row row : sheet){
            if(row.getRowNum() != 0) {
                for (Cell cell : row) {
                    String serviceName = cell.getRow().getCell(0).toString();

                    if(!dependencies.containsKey(serviceName)) {
                        Map<String, Double> dep = new HashMap<>();
                        dep.put(cell.getRow().getCell(1).toString(),Double.valueOf(cell.getRow().getCell(2).toString()));
                        dependencies.put(cell.getRow().getCell(0).toString(), dep);
                    }

                    for(Map<String, Double> keyMap : dependencies.values()) {
                        keyMap.put(cell.getRow().getCell(1).toString(), Double.valueOf(cell.getRow().getCell(2).toString()));
                    }

                }
            }
        }

        logger.info(dependencies.toString());

        System.out.println(dependencies);
    }
}
