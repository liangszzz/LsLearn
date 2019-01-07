package excelTools.handle;

import excelTools.Handle;
import org.apache.poi.ss.usermodel.Cell;

import java.util.HashMap;

public class BizOrderCodeHandle extends AbstructHandle {

    @Override
    public void execute(Cell cell, String val, HashMap<String, String> sqlMap) {
        if (checkExecute(val)) {
            sqlMap.put(getVal(), cell.getStringCellValue());
        }
        executeNext(cell, val, sqlMap);
    }

    @Override
    public String getVal() {
        return "biz_order_no";
    }


}
