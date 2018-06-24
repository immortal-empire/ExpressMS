<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>  
<div class="layui-btn-group demoTable" style="margin-top: 5px;">
  <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
  <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
  <button class="layui-btn" data-type="isAll">验证是否全选</button>
  <input id="substation" value="" hidden="hidden">
</div>

<div id="pTable" style="width: 1200px;">  
    <table class="layui-table" id="layui_table_id" lay-filter="demo"></table>  
    <div id="laypage"></div>
</div>  
             
<script type="text/javascript" src="../js/jquery.min.js"></script>                     
<script src="../layui/layui.all.js" charset="utf-8"></script>
<script src="../js/test.js" charset="utf-8"></script>
<script type="text/html" id="barDemo">

  <button class="layui-btn layui-btn-xs dw-dailog" dw-url="taskInfo.html" dw-title="任务详情" dw-width="50%" dw-height="70%"lay-event="detail">
  		<i class="layui-icon">&#xe63c;</i>详情
  </button>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
<script>
	eventListener();
</script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
</body>
</html>