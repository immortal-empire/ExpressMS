<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>购货入库</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <link rel="stylesheet" href="../css/global.css">
  <link rel="stylesheet" href="../icheck/minimal/red.css">
  <script type="text/javascript" src="PGInbound.js"></script>
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../icheck/icheck.js"></script>
	<script type="text/javascript" src="../js/dw.js"></script>
	<script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">中心库房管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="admin.html">用户列表</a></li>
      <li class="layui-nav-item"><a href="member.html">会员列表</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">修改密码</a></dd>
          <dd><a href="">退出登录</a></dd>
        </dl>
      </li>
    </ul>
  </div>
  
 <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item"><a class="layui-this" href="index.html">首页</a></li>
        <li class="layui-nav-item">
            <a href="sysConfig.html">购货入库</a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">调拨出库</a>
          <dl class="layui-nav-child">
            <dd><a href="admin.html">调拨出库</a></dd>
            <dd><a href="admin.html">打印出库单</a></dd>
            <dd><a href="admin.html">打印分发单</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">退货</a>
            <dl class="layui-nav-child">
                <dd><a href="rule.html">退货出库</a></dd>
                <dd><a href="role.html">退货入库</a></dd>
            </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 25px;">
        <fieldset class="layui-elem-field">  
            <legend>购货入库</legend>
            <div class="layui-field-box">
              <form class="layui-form" action="">
                <div class="layui-form-item">
                  <div class="layui-inline">
                    <div class="layui-input-inline" style="margin:10px 100px 10px 150px">
                      <input autocomplete="off" class="layui-input" style="width:300px"  placeholder="请输入购货单号" type="text" id="pgorder" onblur="vaildatePGOrder()">
                    </div>
                  </div>
                  <div class="layui-inline">
                  	<div class="layui-input-inline" style="margin: 10px 80px 10px 20px;">
                  		<th>*前两位为字母且后六位为数字</th>
                  		<i class="layui-icon" id="vailda_true" style="font-size: 20px; font-weight: 400;  color: green;"></i>
                  		<i class="layui-icon" id="vailda_false" style="font-size: 23px; font-weight: 400; color:red;"></i>
                  	</div>
                  </div>
                  <div class="layui-inline" style="text-align:left;">
                    <div class="layui-input-inline">
                      <button class="layui-btn"><i class="layui-icon">&#xe615;</i>查询</button>
                    </div>
                  </div>  
                </div>
             
              
              <hr>
              <div class="layui-btn-group">
              	<div class="layui-input-inline">
                  <button class="layui-btn"><i class="layui-icon">&#xe681;</i>修改入库量</button>
               </div>
               <div class="layui-input-inline" style="margin: 5px 90px 5px 70px;">
                  <button class="layui-btn"><i class="layui-icon">&#xe681;</i>入库</button>
               </div>
              </div>
              <hr>
              <!--
              	作者：1305195890@qq.com
              	时间：2018-06-21
              	描述：
              	<table class="layui-table" id="test"></table>
              -->
              <div id="pTable">
              	<table class="layui-table" id="layui_table_id" lay-filter="test"></table>
              	<div id="laypage"></div>
              </div>
              </form>
            </div>
        </fieldset>
    </div>
  </div>
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<!--
	作者：1305195890@qq.com
	时间：2018-06-21
	描述：
<script>
layui.use('table', function(){
  var table = layui.table
  ,form = layui.form
  var data = [{"productid":1222,"productname":"aaaaa","quantityordered":100,"realquantity":100,"date":"xxxxx","remarks":"wwwww"}]
  table.render({
    elem: '#test'
    ,cellMinWidth: 80
    ,cols: [[
    	{type:'numbers'}
      ,{type:'checkbox'}
      ,{field:'productid', width:150, title: '商品ID'}
      ,{field:'productname', width:150, title: '商品名称'}
      ,{field:'quantityordered', width:150, title: '订购数量'}
      ,{field:'realquantity', width:150, title: '实际到货数量'}
      ,{field:'date', title: '入库日期', minWidth: 100}
      ,{field:'remarks', width:400, title: '备注'}
    ]]
    ,data:data
    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
      layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'] //自定义分页布局
      //,curr: 5 //设定初始在第 5 页
			,limit:5
			,limits:[5,10,15]
      
    }
  });
});
</script>
-->
</body>
</html>