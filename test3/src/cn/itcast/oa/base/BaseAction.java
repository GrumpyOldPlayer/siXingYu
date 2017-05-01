package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import cn.itcast.oa.domain.Category;
import cn.itcast.oa.service.CategoryService;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.service.ForumService;
import cn.itcast.oa.service.InfosService;
import cn.itcast.oa.service.MianfeiService;
import cn.itcast.oa.service.PrivilegeService;
import cn.itcast.oa.service.RoleService;
import cn.itcast.oa.service.ShoufeiService;
import cn.itcast.oa.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    // =============== ModelDriven的支持 ==================

    protected T model;

    public BaseAction() {
        try {
            // 通过反射获取model的真实类型
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
            // 通过反射创建model的实例
            model = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ============== 分页用的参数 =============

    protected int pageNum = 1; // 当前页
    protected int pageSize = 10; // 每页显示多少条记录

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getModel() {
        return model;
    }

    // =============== Service实例的声明 ==================
    @Resource
    protected RoleService roleService;
    @Resource
    protected DepartmentService departmentService;
    @Resource
    protected UserService userService;
    @Resource
    protected PrivilegeService privilegeService;

    @Resource
    protected ForumService forumService;
    @Resource
    protected CategoryService categoryService;
    @Resource
    protected InfosService infosService;

    @Resource
    protected ShoufeiService shoufeiService;
    @Resource
    protected MianfeiService mianfeiService;

}
