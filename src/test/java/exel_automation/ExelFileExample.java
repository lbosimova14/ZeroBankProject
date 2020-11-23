package exel_automation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;


public class ExelFileExample {


    @Test
    public void readExelFile() throws Exception {
        //path to Excel document
        String path="/Users/laylo/OneDrive/Documents/countries.xlsx";
        //Open file and confert to stream of data
        FileInputStream inputStream= new FileInputStream(path);
       // hiroriky: workbook> worksheet > row> cell
        //Open the WorkBook
        Workbook workbook = WorkbookFactory.create(inputStream);
        //Goto the Worksheet
        Sheet worksheet= workbook.getSheetAt(0);
        //go to first row
        Row row = worksheet.getRow(0);

    }
}
