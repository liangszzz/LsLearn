package excelTools;

import excelTools.handle.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelRead {

    public static void main(String[] args) throws IOException {

        Workbook workBook = getWorkBook(new File("C:\\Users\\admin\\Desktop\\纳米还款（人人聚财）.xlsx"));

        Iterator<Sheet> sheetIterator = workBook.sheetIterator();
        while (sheetIterator.hasNext()) {
            Sheet next = sheetIterator.next();
            System.out.println("#" + next.getSheetName() + "#");
            getSheetInfo(next);
        }
    }

    public static Workbook getWorkBook(File file) throws IOException {
        //获得文件名
        String fileName = file.getName();
        //创建Workbook工作薄对象，表示整个excel
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
        if (fileName.endsWith("xls")) {
            //2003
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileName.endsWith("xlsx")) {
            //2007
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }


    static int sqlCount = 0;
    static int noSqlCount = 0;

    public static void getSheetInfo(Sheet sheet) {
        System.out.println("###正在处理###" + sheet.getSheetName());
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "biz_order_no");
        map.put(5, "loan_date");
        map.put(7, "current_repayment_term");
        map.put(10, "actual_pay_date");
        map.put(12, "actual_pay_money");
        map.put(15, "pay_status");

        Handle biz = new BizOrderCodeHandle();
        Handle loan = new LoanDateHandle();
        Handle termHandle = new TermHandle();
        Handle actPayDate = new ActPayDateHandle();
        Handle actPay = new ActPayHandle();
        Handle payStatus = new PayStatusHandle();

        biz.setNext(loan).setNext(termHandle).setNext(actPayDate).setNext(actPay).setNext(payStatus);


        for (int i = firstRowNum + 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                HashMap<String, String> sqlMap = new HashMap<>();
                short firstCellNum = row.getFirstCellNum();
                short lastCellNum = row.getLastCellNum();
                for (int j = firstCellNum; j < lastCellNum; j++) {
                    Cell cell = row.getCell(j);
                    biz.execute(cell, map.get(j), sqlMap);
                }
                createSQL(sqlMap);
            }
        }
        System.out.println("###本次创建SQL###" + sqlCount);
        System.out.println("###本次未创建SQL###" + noSqlCount);
    }

    /**
     * 创建账单更新语句
     * @param map
     */
    public static void createSQL(HashMap<String, String> map) {
        StringBuffer sqlBuffer = new StringBuffer();
        if ("3".equals(map.get("pay_status"))) {
            sqlBuffer.append("update cl_bill_copy set ")
                    .append("pi_repay_date=").append("'").append(map.get("actual_pay_date")).append("'").append(",")
                    .append("actual_pay_date=").append("'").append(map.get("actual_pay_date")).append("'").append(",")
                    .append("already_repay_principal=should_repay_principal").append(",")
                    .append("already_repay_interest=should_repay_interest").append(",")
                    .append("already_repay_penalty=actual_pay_penalty_interest").append(",")
                    .append("actual_pay_principal_interest=should_pay_principal_interest").append(",")
                    .append("already_repay_service_charge=should_repay_service_charge").append(",")
                    .append("already_repay_m_service_charge=should_repay_m_service_charge").append(",")
                    .append("already_repay_ex_service_charge=should_repay_ex_service_charge").append(",")
                    .append("already_repay_intermediary_service_charge=should_repay_intermediary_service_charge").append(",")
                    .append("already_repay_service_charge_total=should_repay_service_charge_total").append(",")
                    .append("remaining_principal_interest_all=should_pay_principal_interest_all").append(",")
                    .append("bill_status=3")
                    .append(" where biz_order_no=").append("'").append(map.get("biz_order_no")).append("'").append(" and")
                    .append(" current_repayment_term=").append("'").append(map.get("current_repayment_term")).append("'").append(" and")
                    .append(" bill_type=1").append(";");
            System.out.println(sqlBuffer.toString());
            sqlCount += 1;
        } else if ("2".equals(map.get("pay_status"))) {
            System.out.println("#不处理");
            noSqlCount += 1;
        }
    }

    /**
     * 如果账单的应还期数和总期数一致
     * 创建更新订单状态语句
     * @param map
     */
    public void createSQL2(HashMap<String, String> map) {
        //没有
    }

}
