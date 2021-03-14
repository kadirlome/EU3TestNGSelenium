package com.cybertek.tests.day_16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        /**create an object from ExcelUtil
         * it accepts two arguments
         * Argument 1 : location of the file(path)
         * Argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        // ow any rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());
        // how many colums
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        // gel all colums names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());


        // get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);
        }
        //get the name = Nona
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));
        //get the lastname = Harbor
        System.out.println("dataList.get(2) = " + dataList.get(2).get("lastname"));

        String [][] dataArray = qa3short.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

    }
}
