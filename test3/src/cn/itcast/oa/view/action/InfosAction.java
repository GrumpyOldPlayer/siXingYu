package cn.itcast.oa.view.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Category;
import cn.itcast.oa.domain.Infos;
import cn.itcast.oa.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class InfosAction extends BaseAction<Infos> {

    /**
     * 列表
     */
    public String list() throws Exception {
//		List<Infos> Infoslis = infosService.findAll();
//		ActionContext.getContext().put("InfosList", InfosList);
        new QueryHelper(Infos.class, "u").preparePageBean(infosService, pageNum, pageSize);

        return "list";
    }

    /**
     * 删除
     */
    public String delete() throws Exception {
        infosService.delete(model.getId());
        return "toList";
    }

    /**
     * 删除
     */
    public String refuse() throws Exception {
        Infos role = infosService.getById(model.getId());
        role.setState("驳回");
        infosService.update(role);
        return "toList";
    }

    /**
     * 添加页面
     */
    public String uaddUI() throws Exception {
        List<Category> plist = categoryService.findAll();
        ActionContext.getContext().put("plist", plist);

        return "uaddUI";
    }

    /**
     * 添加页面
     */
    public String uadd() throws Exception {
        Category ct = categoryService.getById(model.getCid());
        model.setCategory(ct.getName());
        Date dt = new Date();
        SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = matter1.format(dt);
        model.setAddtime(date);
        model.setState("申请中");
        infosService.save(model);
        return "toindex";
    }

    /**
     * 删除
     */
    public String confirm() throws Exception {
        Infos role = infosService.getById(model.getId());
        role.setState("确认");
        infosService.update(role);
        return "toList";
    }

    /**
     * 添加页面
     */
    public String addUI() throws Exception {
        List<Category> plist = categoryService.findAll();
        ActionContext.getContext().put("plist", plist);

        return "saveUI";
    }

    /**
     * 添加
     */
    public String add() throws Exception {
        Category ct = categoryService.getById(model.getCid());
        model.setCategory(ct.getName());
        Date dt = new Date();
        SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = matter1.format(dt);
        model.setAddtime(date);
        model.setState("申请中");
        infosService.save(model);
        return "toList";
    }

    /**
     * 修改页面
     */
    public String editUI() throws Exception {
        // 准备回显的数据
        Infos role = infosService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(role);
        List<Category> plist = categoryService.findAll();
        ActionContext.getContext().put("plist", plist);
        return "editUI";
    }

    /**
     * 修改
     */
    public String edit() throws Exception {
        // 1，从数据库中获取原对象
        Infos role = infosService.getById(model.getId());
        Category ct = categoryService.getById(model.getCid());
        role.setCategory(ct.getName());
        role.setCid(model.getCid());
        role.setInfos(model.getInfos());
//		role.setState(state)
        role.setTel(model.getTel());
        role.setTitle(model.getTitle());
        role.setUser(model.getUser());
        // 3，更新到数据库
        infosService.update(role);
        return "toList";
    }


    public String getout() throws Exception {
        List<Infos> list = infosService.findAll();
        ActionContext.getContext().put("list", list);
        String root = ServletActionContext.getServletContext().getRealPath(
                "/picurl");
        String path = root + "\\infosheet.xls";
        File file = new File(path);
        WritableWorkbook wb = Workbook.createWorkbook(file);
        WritableSheet ws = wb.createSheet("sheet1", 0);
        Label t11 = new Label(0, 0, "信息类别");
        ws.addCell(t11);
        Label t21 = new Label(1, 0, "信息标题");
        ws.addCell(t21);
        Label t31 = new Label(2, 0, "添加时间");
        ws.addCell(t31);
        Label t41 = new Label(3, 0, "联系人");
        ws.addCell(t41);
        Label t51 = new Label(4, 0, "联系电话");
        ws.addCell(t51);
        Label t61 = new Label(5, 0, "状态");
        ws.addCell(t61);
        Label t71 = new Label(6, 0, "详情");
        ws.addCell(t71);
        for (int i = 1; i < list.size(); i++) {
            Label t1 = new Label(0, i, "" + list.get(i).getCategory());
            ws.addCell(t1);
            Label t2 = new Label(1, i, list.get(i).getTitle());
            ws.addCell(t2);
            Label t3 = new Label(2, i, "" + list.get(i).getAddtime());
            ws.addCell(t3);
            Label t4 = new Label(3, i, "" + list.get(i).getUser());
            ws.addCell(t4);
            Label t5 = new Label(4, i, "" + list.get(i).getTel());
            ws.addCell(t5);
            Label t6 = new Label(5, i, "" + list.get(i).getState());
            ws.addCell(t6);
            Label t7 = new Label(6, i, "" + list.get(i).getInfos());
            ws.addCell(t7);

        }
        wb.write();
        wb.close();

        fileName = file.getName();
        try {
            fileinputStream = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "downdone";
    }


    private List<File> file;// 对应jsp中file标签
    private List<String> fileFileName;//
    private List<String> fileContentType;//
    private String fileName;//获得jsp中pram参数
    private InputStream fileinputStream;

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }

    public List<String> getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(List<String> fileFileName) {
        this.fileFileName = fileFileName;
    }

    public List<String> getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(List<String> fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getFileinputStream() {
        return fileinputStream;
    }

    public void setFileinputStream(InputStream fileinputStream) {
        this.fileinputStream = fileinputStream;
    }

}
