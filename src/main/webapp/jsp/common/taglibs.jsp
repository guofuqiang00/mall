<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${basePath}"/>
<%
   //静态资源版本号，防止资源更新后，页面还是显示旧样式
    request.setAttribute("webVersion", "100001");

%>
<script type="text/javascript">
    <%--window.ctx='${ctx}';--%>
    <%--var pathName=window.document.location.pathname;--%>
    <%--var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);--%>

</script>