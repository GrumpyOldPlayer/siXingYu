<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>用户信息</title>
   	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>添加新会员</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add_user"></i><em>添加新会员</em></span>
  </div>
    <s:form action="user_%{id == null ? 'add' : 'edit'}">
    	<s:hidden name="id"></s:hidden>
  <table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">所属部门：</td>
    <td><s:select name="departmentId"  cssClass="textBox length-middle"
                        		list="#departmentList" listKey="id" listValue="name"
                        		headerKey="" headerValue="==请选择部门=="
                        	/></td>
   </tr>
   <tr>
    <td style="text-align:right;">登录名：</td>
    <td><s:textfield name="loginName" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">姓名：</td>
    <td><s:textfield name="name" cssClass="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">性别：</td>
    <td><s:radio name="gender" list="{'男', '女'}"></s:radio></td>
   </tr>
      <tr>
    <td style="text-align:right;">手机号码：</td>
    <td><s:textfield name="phoneNumber" cssClass="textBox length-middle"/></td>
   </tr>
      <tr>
    <td style="text-align:right;">电子邮件：</td>
    <td><s:textfield name="email"  cssClass="textBox length-middle"/></td>
   </tr>
        <tr>
    <td style="text-align:right;">岗位：</td>
    <td><s:select name="roleIds" cssClass="textBox length-middle"
                        		multiple="true" size="10" 
                        		list="#roleList" listKey="id" listValue="name"
                        	/>
							按住Ctrl键可以多选或取消选择</td>
   </tr>
      <tr>
    <td style="text-align:right;">备注：</td>
    <td><s:textfield name="description" cssClass="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="添加新用户"/></td>
   </tr>
  </table>
  </s:form>
 </div>
</body>
</html>