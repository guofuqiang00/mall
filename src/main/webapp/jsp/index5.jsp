<%--
  Created by IntelliJ IDEA.
  User: gfq
  Date: 2020/7/27
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/js/searchableSelect.css" rel="stylesheet" type="text/css">
<script src="/js/jq.js"></script>
<script src="/js/searchableSelect.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select>
    <option value="jQuery插件库">jQuery插件库</option>
    <option value="BlackBerry">BlackBerry</option>
    <option value="device">device</option>
    <option value="with">with</option>
    <option value="entertainment">entertainment</option>
    <option value="and">and</option>
    <option value="social">social</option>
    <option value="networking">networking</option>
    <option value="apps">apps</option>
    <option value="or">or</option>
    <option value="apps">apps</option>
    <option value="that">that</option>
    <option value="will">will</option>
    <option value="boost">boost</option>
    <option value="your">your</option>
    <option value="productivity">productivity</option>
    <option value="Download">Download</option>
    <option value="or">or</option>
    <option value="buy">buy</option>
    <option value="apps">apps</option>
    <option value="from">from</option>
    <option value="Afbb">Afbb</option>
    <option value="Akademie">Akademie</option>
    <option value="Berlin">Berlin</option>
    <option value="reviews">reviews</option>
    <option value="by">by</option>
    <option value="real">real</option>
</select>
<script>
    $(function(){
        $('select').searchableSelect();
    });
</script>
</body>
</html>
