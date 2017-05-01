<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>信息管理</title>
   	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add_user"></i><em>信息管理</em></span>
  </div>
    <s:form action="sf_add">
    	<s:hidden name="userid" value="%{#session.user.id}"></s:hidden>
  <table class="list-style">
   <tr>
    <td style="text-align:right;">标题：</td>
    	<td><s:textfield name="title" cssClass="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">分类：</td>
    	<td>  
    
      <select name="cid" >

      <s:iterator value="CategoryList">
        <option value="${id}">${name}</option>
        </s:iterator>
      </select>
 </td>
   </tr>
     <tr>
    <td style="text-align:right;">联系人：</td>
    	<td><s:textfield name="name" value="%{#session.user.name}" cssClass="textBox length-middle layui-btn layui-btn-disabled"/></td>
   </tr>
     <tr>
    <td style="text-align:right;">联系电话：</td>
    	<td><s:textfield name="tel" cssClass="textBox length-middle"/></td>
   </tr>
        <tr>
    <td style="text-align:right;">价格：</td>
    	<td><s:textfield name="price" cssClass="textBox length-middle"/></td>
   </tr>
       <tr>
    <td style="text-align:right;">内容：</td>
    	<td><div style="margin-bottom: 20px; width: 500px;">
  		<s:textarea name="text" class="layui-textarea" id="LAY_demo2" style="display: none"></s:textarea>
</div> </td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="添加"/></td>
   </tr>
  </table>
  </s:form>
 </div>
</body>


<script>
layui.use('layedit', function(){
  var layedit = layui.layedit
  ,$ = layui.jquery;
  
  //自定义工具栏
  layedit.build('LAY_demo2', {
    tool: ['face', 'unlink', '|', 'left', 'center', 'right']
    ,height: 100
  })
});
</script>
</html>