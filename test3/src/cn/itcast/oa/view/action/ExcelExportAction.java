package cn.itcast.oa.view.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Mianfei;
import cn.itcast.oa.domain.Shoufei;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IExcelService;
import cn.itcast.oa.service.impl.ExcelServiceImpl;

@Controller
@Scope("prototype")
public class ExcelExportAction extends BaseAction<User> {

    /**
     * 导出Excel测试
     */
    public String sfexportExcel() {
        try {
            //第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            //第二步，在webbook中添加一个sheet，对应Excel文件中的 sheet
            HSSFSheet sheet = wb.createSheet("收费信息");
            //第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制
            HSSFRow row = sheet.createRow(0);
            //第四步，创建单元格样式：居中
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            //第五步，创建表头单元格，并设置样式
            HSSFCell cell;

            cell = row.createCell(0);
            cell.setCellValue("信息标题");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("添加时间");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("联系人");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("联系电话");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("价格");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("内容");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("状态");
            cell.setCellStyle(style);

            //第六步，写入实体数据，实际应用中这些数据从数据库得到
            List<Shoufei> Shoufeilis = shoufeiService.findAll();
            for (Shoufei shoufei : Shoufeilis) {
                User user = userService.getById(Long.valueOf(shoufei.getUserid()));
                shoufei.setUser(user);
            }

            for (int i = 1; i - 1 < Shoufeilis.size(); i++) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(Shoufeilis.get(i - 1).getTitle());
                row.createCell(1).setCellValue(Shoufeilis.get(i - 1).getAddtime());
                row.createCell(2).setCellValue(Shoufeilis.get(i - 1).getUser().getName());
                row.createCell(3).setCellValue(Shoufeilis.get(i - 1).getTel());
                row.createCell(4).setCellValue(Shoufeilis.get(i - 1).getPrice());
                row.createCell(5).setCellValue(Shoufeilis.get(i - 1).getText());
                row.createCell(6).setCellValue(Shoufeilis.get(i - 1).getState());

            }

            //第七步，将文件存到流中
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            wb.write(os);
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);

            excelStream = is;             //文件流

            excelFileName = "收费信息.xls"; //设置下载的文件名
            excelFileName = new String(excelFileName.getBytes("gb2312"), "iso8859-1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }


    /**
     * 导出Excel测试
     */
    public String mfexportExcel() {
        try {
            //第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            //第二步，在webbook中添加一个sheet，对应Excel文件中的 sheet
            HSSFSheet sheet = wb.createSheet("免费信息");
            //第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制
            HSSFRow row = sheet.createRow(0);
            //第四步，创建单元格样式：居中
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            //第五步，创建表头单元格，并设置样式
            HSSFCell cell;

            cell = row.createCell(0);
            cell.setCellValue("信息标题");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("添加时间");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("联系人");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("联系电话");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("内容");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("状态");
            cell.setCellStyle(style);

            //第六步，写入实体数据，实际应用中这些数据从数据库得到
            List<Mianfei> Mianfeilis = mianfeiService.findAll();
            for (Mianfei Mianfei : Mianfeilis) {
                if (Mianfei.getUserid() != null) {
                    User user = userService.getById(Long.valueOf(Mianfei.getUserid()));
                    Mianfei.setUser(user);
                } else {
                    User user = new User();
                    user.setName("游客");
                    Mianfei.setUser(user);
                }

            }

            for (int i = 1; i - 1 < Mianfeilis.size(); i++) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(Mianfeilis.get(i - 1).getTitle());
                row.createCell(1).setCellValue(Mianfeilis.get(i - 1).getAddtime());
                row.createCell(2).setCellValue(Mianfeilis.get(i - 1).getUser().getName());
                row.createCell(3).setCellValue(Mianfeilis.get(i - 1).getTel());
                row.createCell(4).setCellValue(Mianfeilis.get(i - 1).getText());
                row.createCell(5).setCellValue(Mianfeilis.get(i - 1).getState());
            }

            //第七步，将文件存到流中
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            wb.write(os);
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);

            excelStream = is;             //文件流

            excelFileName = "免费信息.xls"; //设置下载的文件名
            excelFileName = new String(excelFileName.getBytes("gb2312"), "iso8859-1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }


    //-------------------------------------------------------------
    private InputStream excelStream;  //输出流变量
    private String excelFileName; //下载文件名

    public InputStream getExcelStream() {
        return excelStream;
    }

    public void setExcelStream(InputStream excelStream) {
        this.excelStream = excelStream;
    }

    public String getExcelFileName() {
        return excelFileName;
    }

    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }
}