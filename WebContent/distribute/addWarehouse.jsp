<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<div class="layui-container">  
    <div class="layui-row">
        <div class="layui-col-lg12">
            <fieldset class="layui-elem-field">
                <legend>库房管理 - 新增库房</legend>
                <div class="layui-field-box">
                    <form class="layui-form" action="addWarehouseServlet" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">输入框</label>
                            <div class="layui-input-block">
                            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        
                        <div class="layui-form-item">
                            <label class="layui-form-label">库房名称</label>
                            <div class="layui-input-block">
                            <input type="text" name="warename" required  lay-verify="required" placeholder="请输入库房名称" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        
                        <div class="layui-form-item">
                            <label class="layui-form-label">库管员</label>
                            <div class="layui-input-block">
                            <input type="text" name="manager" required  lay-verify="required" placeholder="请输入库管员姓名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        
                        
                        
                        
                        
                        <div class="layui-form-item">
                            <label class="layui-form-label">库房类型</label>
                            <div class="layui-input-block">
                            <input type="radio" id="cware" name="waretype" value="C" title="中心">
                            <input type="radio" name="waretype" value="S" title="分站" checked>
                            <span id="typeres" style="color:red">haha</span>
                            </div>
                        </div>
                                
                        
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                            <button type="submit" id="addbtn" class="layui-btn">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </fieldset>
        </div>
    </div>
</div>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../js/dw_form_submit.js"></script>
<script type="text/javascript" src="../icheck/icheck.js"></script>
<script type="text/javascript" src="../js/addWarehouse.js"></script>
</body>
</html>