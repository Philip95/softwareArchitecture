package com.mycompany.sa;

import com.mycompany.sa.model.Service;
import com.mycompany.sa.utility.ServiceDependencyHelper;
import com.mycompany.sa.utility.ServiceExcelMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        /*
        //ExcelReader excelReader = new ExcelReader(new File("E:\\FH\\1_Semester\\SA\\sa\\ServiceList.xlsx"));
        ServiceExcelMapper excelReader = new ServiceExcelMapper(new File("E:\\FH\\1_Semester\\SA\\sa\\CallerCallee.xlsx"));
        List<String> names = excelReader.readWorkbook();


        Service service = new Service();
        List<Service> serviceList = service.buildServiceList(names);

        System.out.println(serviceList);
        */

        ServiceDependencyHelper helper = new ServiceDependencyHelper(new File("E:\\FH\\1_Semester\\SA\\sa\\CallerCallee.xlsx"));
        helper.readWorkbook();



    }
}
