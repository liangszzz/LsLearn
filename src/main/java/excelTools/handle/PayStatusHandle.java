package excelTools.handle;

import org.apache.poi.ss.usermodel.Cell;

import java.util.HashMap;

public class PayStatusHandle extends AbstructHandle {
    @Override
    public void execute(Cell cell, String val, HashMap<String, String> sqlMap) {
        if (checkExecute(val)) {
            String cellValue = cell.getStringCellValue();
            if ("正常还款".equals(cellValue)) {
                sqlMap.put(getVal(), "3");
            } else {
                sqlMap.put(getVal(), "2");
            }
        }
    }

    @Override
    public String getVal() {
        return "pay_status";
    }
}
