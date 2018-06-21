<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>购货入库</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <link rel="stylesheet" href="../css/global.css">
  <link rel="stylesheet" href="../icheck/minimal/red.css">
  <script type="text/javascript" src="js/PGInbound.js"></script>
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
                      <input autocomplete="off" class="layui-input" style="width:300px"  placeholder="请输入购货单号" type="text" name="pgorder" onblur="vaildatePGOrder()">
                    </div>
                  </div>
                  <div class="layui-inline">
                  	<div class="layui-input-inline" style="margin: 10px 80px 10px 20px;">
                  		<tr>*前两位为字母且后六位为数字</tr>
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
              <table class="layui-table">
                  <colgroup>
                      <col width="50">
                      <col width="120">
                      <col width="80">
                      <col width="80">
                      <col width="150">
                      <col width="150">
                  </colgroup>
                  <thead>
                      <tr>
                      <th class="selectAll" style="text-align:center;"><input type="checkbox"></th>
                      <th style="text-align:center;">商品名称</th>
                      <th style="text-align:center;">订购数量</th>
                      <th style="text-align:center;">实际到货数量</th>
                      <th style="text-align:center;">入库日期</th>
                      <th style="text-align:center;">备注</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr class="text-center">
                      <td><input type="checkbox" name="id" value="1"></td>
                      <td>贤心</td>
                      <td>65</td>
                      <td>65</td>
                      <td class="text-center">2016-11-29</td>
                      <td></td>
                      </tr>
                      <tr class="text-center">
                      <td><input type="checkbox" name="id" value="2"></td>
                      <td>许闲心</td>
                      <td>100</td>
                      <td>100</td>
                      <td class="text-center">2016-11-29</td>
                      <td></td>
                      </tr>
                      <tr class="text-center">
                      <td><input type="checkbox" name="id" value="3 "></td>
                      <td>sentsin</td>
                      <td>90</td>
                      <td>90</td>
                      <td>2016-11-29</td>
                      <td></td>
                      </tr>
                  </tbody>
              </table>
              </form>
            </div>
        </fieldset>
        <div id="test1"></div>
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
<script type="text/javascript" src="../js/dw.js"></script>

<script>
layui.use('laypage', function(){
  var laypage = layui.laypage;
  //执行一个laypage实例
  laypage.render({
    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
    ,layout:['count','prev', 'page', 'next','limit','refresh','skip']//自定义排版
    ,count: 500 //数据总数，从服务端得到
    ,limits:[10,20,30,40,50]
    ,groups:5
  });
});
</script>
</body>
</html>