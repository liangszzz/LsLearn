package excelTools.handle;

import excelTools.Handle;
import org.apache.poi.ss.usermodel.Cell;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class LoanDateHandle extends AbstructHandle {



    public void execute(Cell cell, String val, HashMap<String, String> sqlMap) {
        if (checkExecute(val)) {
            Date dateCellValue = cell.getDateCellValue();
            String date = sdf.format(dateCellValue);
            sqlMap.put(getVal(), date);
        }
        executeNext(cell, val, sqlMap);
    }

    @Override
    public String getVal() {
        return "loan_date";
    }

}
