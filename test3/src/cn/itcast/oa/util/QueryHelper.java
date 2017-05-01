package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.PageBean;

import com.opensymphony.xwork2.ActionContext;

/**
 * 鐢ㄤ簬杈呭姪鎷兼帴HQL璇彞
 *
 * @author tyg
 */
public class QueryHelper {

    private String fromClause; // FROM瀛愬彞
    private String whereClause = ""; // Where瀛愬彞
    private String orderByClause = ""; // OrderBy瀛愬彞

    private List<Object> parameters = new ArrayList<Object>(); // 鍙傛暟鍒楄〃

    /**
     * 鐢熸垚From瀛愬彞
     *
     * @param clazz
     * @param alias 鍒悕
     */
    public QueryHelper(Class clazz, String alias) {
        fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
    }

    /**
     * 鎷兼帴Where瀛愬彞
     *
     * @param condition
     * @param params
     */
    public QueryHelper addCondition(String condition, Object... params) {
        // 鎷兼帴
        if (whereClause.length() == 0) {
            whereClause = " WHERE " + condition;
        } else {
            whereClause += " AND " + condition;
        }

        // 鍙傛暟
        if (params != null) {
            for (Object p : params) {
                parameters.add(p);
            }
        }

        return this;
    }

    /**
     * 濡傛灉绗竴涓弬鏁颁负true锛屽垯鎷兼帴Where瀛愬彞
     *
     * @param append
     * @param condition
     * @param params
     */
    public QueryHelper addCondition(boolean append, String condition, Object... params) {
        if (append) {
            addCondition(condition, params);
        }
        return this;
    }

    /**
     * 鎷兼帴OrderBy瀛愬彞
     *
     * @param propertyName 鍙備笌鎺掑簭鐨勫睘鎬у悕
     * @param asc          true琛ㄧず鍗囧簭锛宖alse琛ㄧず闄嶅簭
     */
    public QueryHelper addOrderProperty(String propertyName, boolean asc) {
        if (orderByClause.length() == 0) {
            orderByClause = " ORDER BY " + propertyName + (asc ? " ASC" : " DESC");
        } else {
            orderByClause += ", " + propertyName + (asc ? " ASC" : " DESC");
        }
        return this;
    }

    /**
     * 濡傛灉绗竴涓弬鏁颁负true锛屽垯鎷兼帴OrderBy瀛愬彞
     *
     * @param append
     * @param propertyName
     * @param asc
     */
    public QueryHelper addOrderProperty(boolean append, String propertyName, boolean asc) {
        if (append) {
            addOrderProperty(propertyName, asc);
        }
        return this;
    }

    /**
     * 鑾峰彇鐢熸垚鐨勭敤浜庢煡璇㈡暟鎹垪琛ㄧ殑HQL璇彞
     *
     * @return
     */
    public String getListQueryHql() {
        return fromClause + whereClause + orderByClause;
    }

    /**
     * 鑾峰彇鐢熸垚鐨勭敤浜庢煡璇㈡�璁板綍鏁扮殑HQL璇彞
     *
     * @return
     */
    public String getCountQueryHql() {
        return "SELECT COUNT(*) " + fromClause + whereClause;
    }

    /**
     * 鑾峰彇HQL涓殑鍙傛暟鍊煎垪琛�
     *
     * @return
     */
    public List<Object> getParameters() {
        return parameters;
    }

    /**
     * 鏌ヨ鍒嗛〉淇℃伅锛屽苟鏀惧埌鍊兼爤鏍堥《
     *
     * @param service
     * @param pageNum
     * @param pageSize
     */
    public void preparePageBean(DaoSupport<?> service, int pageNum, int pageSize) {
        PageBean pageBean = service.getPageBean(pageNum, pageSize, this);
        ActionContext.getContext().getValueStack().push(pageBean);
    }

}
