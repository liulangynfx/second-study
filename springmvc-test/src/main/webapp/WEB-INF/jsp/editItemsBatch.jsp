<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
    <form name="itemsForm" action="${pageContext.request.contextPath }/items/listItems.action" method="post">
        查询条件：
        <table width="100%" border=1>
            <tr>
                <td>商品名称：<input type='text' name="itemsCustome.name"></td>
            </tr>
            <tr>
                <td><input type="button" value="查询" onclick="queryItem();" />
                <input type="button" value="批量更新" onclick="deleteByIDBatch();" /></td>
            </tr>
        </table>
        商品列表：
        <table width="100%" border=1>
            <tr>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
            </tr>
            <c:forEach items="${itemsList }" var="item" varStatus="st">
                <tr>
                    <td><input type="text" name="itemsList[${st.index}].name" value="${item.name }" /></td>
                    <td><input type="text" name="itemsList[${st.index}].price" value="${item.price }" /></td>
                    <td><input type="text" name="itemsList[${st.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss" />" /></td>
                    <td><input type="text" name="itemsList[${st.index}].detail" value="${item.detail }" /></td>

                </tr>
            </c:forEach>

        </table>
    </form>
</body>

<script type="text/javascript">

	//批量更新商品
	function deleteByIDBatch() {
		document.itemsForm.action="${pageContext.request.contextPath }/items/updateItemsBatch.action";
		document.itemsForm.submit();
	}
	
	//查询商品列表信息
	function queryItem() {
		document.itemsForm.action="${pageContext.request.contextPath }/items/listEditItems.action";
		document.itemsForm.submit();
	}
</script>

</html>