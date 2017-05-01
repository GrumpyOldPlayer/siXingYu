package cn.itcast.oa.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.service.IExcelService;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ExcelServiceImpl implements IExcelService {


    public InputStream getExcelInputStream() {
        //将OutputStream转化为InputStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        putDataOnOutputStream(out);
        return new ByteArrayInputStream(out.toByteArray());
    }

    private void putDataOnOutputStream(OutputStream os) {
        jxl.write.Label label;
        WritableWorkbook workbook;
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);

            label = new jxl.write.Label(0, 0, "struts2导出excel");
            sheet.addCell(label);

            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
