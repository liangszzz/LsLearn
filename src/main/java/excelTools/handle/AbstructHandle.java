package excelTools.handle;

import excelTools.Handle;
import org.apache.poi.ss.usermodel.Cell;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public abstract class AbstructHandle implements Handle {

    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    protected Handle next;

    @Override
    public Handle setNext(Handle handle) {
        next = handle;
        return next;
    }

    public void executeNext(Cell cell, String val, HashMap<String, String> sqlMap) {
        if (next != null)
            next.execute(cell, val, sqlMap);
    }

    public boolean checkExecute(String val) {
        if (getVal().equals(val)) {
            return true;
        }
        return false;
    }
}
