var defaultSize=5;

/*var data = [{"id":"1","warename":"shenyang","address":"fdsfs","manager":"hjhjhj","type":"C"},
			{"id":"1","warename":"shenyang","address":"fdsfs","manager":"hjhjhj","type":"C"},
			{"id":"1","warename":"shenyang","address":"fdsfs","manager":"hjhjhj","type":"C"},
			{"id":"1","warename":"shenyang","address":"fdsfs","manager":"hjhjhj","type":"C"},
			{"id":"1","warename":"shenyang","address":"fdsfs","manager":"hjhjhj","type":"C"},
			{"id":"1","warename":"shenyang","address":"fdsfs","manager":"hjhjhj","type":"C"}];
*/
$(document).ready(function(){
    //ajax请求后台数据
	//getCount();
	//getRecord(1,defaultSize);
	table_refresh(data);
});

//利用数据渲染表格
function table_refresh(data) {  
    layui.use(['table','laypage'], function(){  
        var table = layui.table,   
            laypage = layui.laypage; 
        
        table.render({  
            elem: '#layui_table_id'  
            , data:data
            ,cols: [[
                     {type: 'checkbox'}
                     ,{field:'id', title:'库房编号', width:100, unresize: true}
                     ,{field:'warename', title:'库房名称'}
                     ,{field:'address', title:'库房地址'}
                     ,{field:'manager', title: '库管员', width:100}
                     ,{field:'type', title: '库房类型', width:100}
                     ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}
                   ]] 
            , page: false  
        })    
    });  
}

//渲染分页
function toPage(count){
    layui.use('laypage', function(){
          var laypage = layui.laypage;
           laypage.render({
                    elem: 'laypage' //注意，这里的 page 是 ID，不用加 # 号
                    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
                    ,count:count
                    ,limit:defaultSize
                    ,limits:[5,10,15]
           			,jump: function(obj, first){
                        //obj包含了当前分页的所有参数，比如：
           				getRecord(obj.curr,obj.limit);
           			}
        });
    })
}

//用ajax向servlet发送请求获得记录总数
function getCount(){
    $.ajax({
        type:"post",
        url:"../queryWarehouseServlet",//对应controller的URL
        async:false,
        dataType: 'text',
        data:{
        	"action":'count',
            },
        success:function(data) {
        	var count = data;  
        	toPage(count);
        }  
    });
}

//用ajax向servlet发送请求，按页查询数据
function getRecord(pageNum,pageSize){
    $.ajax({
        type:"post",
        url:"../PageServlet",//对应controller的URL
        async:false,
        dataType: 'json',
        data:{
        	"action":'record',
        	"pageNum":pageNum,
        	"pageSize":pageSize
            },
        success:function(data) {
        	table_refresh(data);
        }  
    });
}

function sendRows(data){
	//alert(data);
    $.ajax({
        type:"post",
        url:"../queryWarehouseServlet",//对应controller的URL
        async:false,
        dataType: 'json',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data:{
        	"action":'rows',
        	"data":data
            },
        success:function(data) {
        	
        }  
    });	
}

//按钮、组件事件监听
//如果表格里只是显示数据不需要按钮，就可以删除对应的按钮和监听
function eventListener(){
	layui.use('table', function(){
	  var table = layui.table;
	  //监听表格复选框选择
	  table.on('checkbox(demo)', function(obj){
	    console.log(obj)
	  });
	  //监听工具条
	  table.on('tool(demo)', function(obj){
	    var data = obj.data;
	    if(obj.event === 'detail'){
	    	detail(obj);
	    } else if(obj.event === 'edit'){
	      layer.alert('编辑行：<br>'+ JSON.stringify(data))
	    }
	  });
	  
	  var $ = layui.$, active = {
	    getCheckData: function(){ //获取选中数据
	      var checkStatus = table.checkStatus('layui_table_id')
	      ,data = checkStatus.data;
	      //layer.alert(JSON.stringify(data));
	      sendRows(JSON.stringify(data));
	    }
	    ,getCheckLength: function(){ //获取选中数目
	      var checkStatus = table.checkStatus('layui_table_id')
	      ,data = checkStatus.data;
	      layer.msg('选中了：'+ data.length + ' 个');
	    }
	    ,isAll: function(){ //验证是否全选
	      var checkStatus = table.checkStatus('layui_table_id');
	      layer.msg(checkStatus.isAll ? '全选': '未全选')
	    }
	  };
	  
	  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	});
}

//点击查看详情以后执行的操作
function detail(obj){
    layer.open({
  	  id: 'insert-form',
  	  type: 2, 
  	  content: '/TestPage/dispatch/select.jsp', //这里content是一个普通的String
  	  area: ['893px', '300px'],
        success: function (layero, index) {
            //向iframe页的id=house的元素传值  // 参考 https://yq.aliyun.com/ziliao/133150
              var body = layer.getChildFrame('body', index);
              body.contents().find("#title").val(data.username);
          },
          end:function(){
              var substation = $("#substation").val(); 
              //从父界面的元素里取出传值，判断非空则执行更改操作
              if(substation != null&&substation != undefined&&substation !=""){
                  //可以在这里发送修改数据的Ajax请求
                  
                  //将表格里面显示的值更新
                  obj.update({
                    city: substation
                  });
                  //用完了值以后，重新置为空
                  $("#substation").val('');
              }
          }
  	});	
}
