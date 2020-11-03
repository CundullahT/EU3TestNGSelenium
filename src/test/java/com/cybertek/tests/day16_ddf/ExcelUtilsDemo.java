package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //  Create an object from ExcelUtil
        //  It accepts two arguments
        //  Argument 1: Location of the file (path)
        //  Argument 2: Sheet that we want to open (sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //  How many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //  How many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        System.out.println("\n********************************************************************************************\n");

        //  Get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());   //  This returns List<String>

        System.out.println("\n********************************************************************************************\n");

        //  Get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();    //  This returns List<Map<String, String>>
        for (Map<String, String> oneRow : dataList) {

            System.out.println(oneRow);

        }

        System.out.println("\n********************************************************************************************\n");

        //  Get Nona as a value
        System.out.println("dataList.get(2) = " + dataList.get(2));     //  This will return 3rd row as a Map
        System.out.println("dataList.get(2).get(\"firstname\") = " + dataList.get(2).get("firstname"));

        System.out.println("\n********************************************************************************************\n");

        //  Get Harber
        System.out.println("dataList.get(8).get(\"lastname\") = " + dataList.get(8).get("lastname"));

        System.out.println("\n********************************************************************************************\n");

        //  Get all data in 2D array
        String[][] dataArray = qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));

    }

}
