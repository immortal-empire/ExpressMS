<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>库房信息展示</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">配送中心</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          INK
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
        <li class="layui-nav-item"><a class="" href="index.html">首页</a></li>
        <li class="layui-nav-item">
          <a class="" href="javascript:;">商品管理</a>
          <dl class="layui-nav-child">
            <dd><a href="manualDispatch.html">手动调度</a></dd>
            <dd><a href="autoDispatch.html">自动调度</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
        	<a class="" href="javascript:;">库房管理</a>
        	<dl class="layui-nav-child">
            <dd><a href="warehouseInfo.html">库房信息展示</a></dd>
            <dd><a href="Cwarehouse.html">库房储备设置</a></dd>
            <dd><a href="">库存量查询</a></dd>
            <dd><a href="IOrderInfo.html">出入单查询</a></dd>
          </dl>
        </li>
        
        <li class="layui-nav-item">
        	<a class="" href="supplierInfo.html">供应商管理</a>
        </li>
        
        <li class="layui-nav-item">
        	<a class="" href="DistributePurchase.html">进货管理</a>
        </li>
        
        <li class="layui-nav-item">
        	<a class="" href="DistributeReturn.html">退货管理</a>
        </li>

      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
        <fieldset class="layui-elem-field">
          <legend>库房信息</legend>
          
          <div class="layui-field-box">
          		<div class="layui-inline" style="width:100px">
                		<button class="layui-btn dw-dailog" 
                		dw-url="addWarehouse.jsp" dw-title="新增库房" dw-width="60%" dw-height="80%">
                		<i class="layui-icon">&#xe608;</i> 新增库房
                	</button>
              </div>
          	  <form class="layui-form" action="">
                <div class="layui-form-item" style="padding: 15px;">                	
                	
                	<div class="layui-inline" style="width: 160px">
                  	
                  </div>
                  
                  <div class="layui-inline">
                  	<label class="layui-form-label" style="width:85px">库房名称</label>
                    <div class="layui-input-inline">
                      <input autocomplete="off" class="layui-input" placeholder="库房名称" type="text" name="warename">
                    </div>
                  </div>

                  <div class="layui-inline">
                  	<label class="layui-form-label">库管员</label>
                    <div class="layui-input-inline">
                      <input autocomplete="off" class="layui-input" placeholder="库管员" type="text" name="manager">
                    </div>
                  </div>
                  
                  <div class="layui-inline">
                  	<button class="layui-btn"><i class="layui-icon">&#xe615;</i>查询</button>
                  </div>
              </div>
              
              
              </form>
              <hr>
              <button class="layui-btn layui-btn-xs dw-refresh" style="visibility: hidden;">
                <i class="layui-icon">&#x1002;</i>刷新
              </button>
              
              <div id="pTable">  
    	  		<table class="layui-table" id="layui_table_id" lay-filter="demo"></table>  
    			
    			<div id="laypage"></div>  
		  	  </div>
		  	  
          </div>
      </fieldset>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../icheck/icheck.js"></script>
<script type="text/javascript" src="../layui/layui.all.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/dw.js"></script>
<script type="text/javascript" src="js/queryWarehouse.js" charset="utf-8"></script>
<script type="text/html" id="barDemo">

  <button class="layui-btn layui-btn-xs dw-dailog" 
                          	dw-url="editWarehouse.html" dw-title="修改库房信息" 
                          	dw-width="60%" dw-height="80%"
                          	style="width: 60px;" >
                            <i class="layui-icon">&#xe642;</i>编辑
                        </button>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
<script>
	eventListener();
</script>

</body>
</html>