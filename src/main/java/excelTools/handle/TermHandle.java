package excelTools.handle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.util.HashMap;

public class TermHandle extends AbstructHandle {

    @Override
    public void execute(Cell cell, String val, HashMap<String, String> sqlMap) {
        if (checkExecute(val)) {
            cell.setCellType(CellType.STRING);
            String current_term = cell.getStringCellValue();
            sqlMap.put(getVal(), current_term);
        }
        executeNext(cell, val, sqlMap);
    }

    @Override
    public String getVal() {
        return "current_repayment_term";
    }
}
