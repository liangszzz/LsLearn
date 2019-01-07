package excelTools.handle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.util.HashMap;

public class ActPayHandle extends AbstructHandle {

    @Override
    public void execute(Cell cell, String val, HashMap<String, String> sqlMap) {
        if (checkExecute(val)) {
            cell.setCellType(CellType.STRING);
            sqlMap.put(getVal(), cell.getStringCellValue());
        }
        executeNext(cell, val, sqlMap);
    }

    @Override
    public String getVal() {
        return "actual_pay_money";
    }
}
