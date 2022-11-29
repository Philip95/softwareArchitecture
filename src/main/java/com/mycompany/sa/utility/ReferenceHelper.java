package com.mycompany.sa.utility;

import com.mycompany.sa.model.Service;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReferenceHelper {

    public ReferenceHelper(){}

    public List<Service> buildDependenciesPerService(List<Service> serviceList) throws IOException {
        //load Excel
        ServiceExcelMapper excelReader = new ServiceExcelMapper(new File("E:\\FH\\1_Semester\\SA\\sa\\CallerCallee.xlsx"));
        excelReader.readWorkbook();

        System.out.println(excelReader.readWorkbook());

        for (Service service : serviceList) {


        }

        return serviceList;
    }



}
