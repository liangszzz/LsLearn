package excelTools;

import org.apache.poi.ss.usermodel.Cell;

import java.util.HashMap;

public interface Handle {

    void execute(Cell cell, String val, HashMap<String, String> sqlMap);

    Handle setNext(Handle handle);

    String getVal();
}
