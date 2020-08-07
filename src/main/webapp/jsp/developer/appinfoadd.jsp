<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增APP基础信息 <i class="fa fa-user"></i><small>${devUserSession.devName}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
	  <!-- <div class="item form-group">
               <label class="control-label col-md-3 col-sm-3 col-xs-12" ></label>
               <div class="col-md-6 col-sm-6 col-xs-12">
                 <form action="uploadlogo" class="dropzone" style="height:100px;">
                 </form>
            <div class="clearfix"></div>
         </div>
       </div> -->
           <div class="clearfix">${info}</div>
        <form class="form-horizontal form-label-left" action="/appinfoaddsave" method="post" enctype="multipart/form-data">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareName">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" class="form-control col-md-7 col-xs-12" 
               data-validate-length-range="20" data-validate-words="1" name="softwarename"  required="required"
               placeholder="请输入软件名称" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apkname">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="APKName" class="form-control col-md-7 col-xs-12" 
              	data-validate-length-range="20" data-validate-words="1" name="apkname"   required="required"
              	placeholder="请输入APK名称" type="text">
            </div>
          </div>
          

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="interfacelanguage">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12" 
              data-validate-length-range="20" data-validate-words="1" name="interfacelanguage"   required="required"
              placeholder="请输入软件支持的界面语言" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwaresize">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="softwareSize" name="softwaresize"   required="required" onkeyup="value=value.replace(/[^\d]/g,'')"
              data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloads">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="downloads" name="downloads"   required="required"
              data-validate-minmax="10,500"  placeholder="请输入下载次数" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="flatformId">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="flatformid" id="flatformid" class="form-control"   required="required"><option value="">请选择</option></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"<%-- for="categoryLevel1"--%>>一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel1" id="categoryLevel1" class="form-control"   required="required"> <option value="">请选择</option></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  <%--for="categoryLevel2"--%>>二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categoryLevel2" id="categoryLevel2" class="form-control"  required="required"><option value="">请选择</option></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" <%--for="categoryLevel3"--%>>三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categoryLevel3" id="categoryLevel3" class="form-control"  required="required"><option value="">请选择</option></select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input type="hidden" name="status" id="status" value="1">待审核
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appInfo">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appInfo"     required="required"
              placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" <%--for="logopicpath"--%>>LOGO图片
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            <input type="file" class="form-control col-md-7 col-xs-12" name="a_logoPicPath"  />
            ${fileUploadError }
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>

<script>

  $(function () {
      //2.发送异步请求获app的平台信息
      $.post("${pageContext.request.contextPath }/getAppFlatformData",null,function(data){
          //console.log(data);
          for(var i=0;i<data.length;i++){
              //创建一个option
              var node=$("<option value='"+data[i].valueid+"'>"+data[i].valuename+"</option>");
              //将节点添加到下拉列表
              $("#flatformid").append(node);
          }
      },"json");

      //3.加载一级分类
      $.post("${pageContext.request.contextPath }/getAppSuperclassData",null,function(data){
          //console.log(data);
          for(var i=0;i<data.length;i++){
              //创建一个option
              var node=$("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
              //将节点添加到下拉列表
              $("#categoryLevel1").append(node);
          }
      },"json");

      //4.给一级下拉列表添加onchnage事件加载对应的二级分类
      $("#categoryLevel1").change(function(){
          //获取一级分类的值
          var tid=$(this).val();
          //通过一级分类查询二级分类的结果
          $("#categoryLevel2>option:gt(0)").remove(); //清除原有的类别
          if(tid!="")
          {
              $.post("${pageContext.request.contextPath }/getAppSecondclassData",{"parentId":tid},function(data){
                  //console.log(data);
                  for(var i=0;i<data.length;i++){
                      //创建一个option
                      var node=$("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
                      //将节点添加到下拉列表
                      $("#categoryLevel2").append(node);
                  }
              },"json");
          }
      });

      //5.给二级下拉列表添加onchnage事件加载对应的三级分类
      $("#categoryLevel2").change(function(){
          //获取一级分类的值
          var tid=$(this).val();
          //通过一级分类查询二级分类的结果
          $("#categoryLevel3>option:gt(0)").remove(); //清除原有的类别
          if(tid!="")
          {
              $.post("${pageContext.request.contextPath }/getAppThirdclassData",{"parentId":tid},function(data){
                  //console.log(data);
                  for(var i=0;i<data.length;i++){
                      //创建一个option
                      var node=$("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
                      //将节点添加到下拉列表
                      $("#categoryLevel3").append(node);
                  }
              },"json");
          }
      });
  })



</script>