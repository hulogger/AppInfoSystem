<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>修改APP基础信息 <i class="fa fa-user"></i><small>${devuser.devName}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
        <form class="form-horizontal form-label-left" action="${pageContext.request.contextPath}/updateAppInfo" method="post" enctype="multipart/form-data">
          <input type="hidden" name="id" id="id" value="${appinfo.id}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" class="form-control col-md-7 col-xs-12" 
               data-validate-length-range="20" data-validate-words="1" 
               name="softwareName" value="${appinfo.softwarename}" required="required"
               placeholder="请输入软件名称" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="APKName" type="text" class="form-control col-md-7 col-xs-12" 
              name="APKName" value="${appinfo.apkname}" readonly="readonly">
            </div>
          </div>
          

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12" 
              data-validate-length-range="20" data-validate-words="1"  required="required"
              name="interfaceLanguage" value="${appinfo.interfacelanguage}"
              placeholder="请输入软件支持的界面语言" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="softwareSize" name="softwareSize" value="${appinfo.softwaresize}" required="required"
              data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="downloads" name="downloads" value="${appinfo.downloads}" required="required"
              data-validate-minmax="10,500"  placeholder="请输入下载次数" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">

              <select name="flatformId" id="flatformId" class="form-control" required="required"></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">

              <select name="categoryLevel1" id="categoryLevel1" class="form-control"  required="required"></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">

              <select name="categoryLevel2" id="categoryLevel2" class="form-control"  required="required"></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">

              <select name="categoryLevel3" id="categoryLevel3" class="form-control"  required="required"></select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input id="statusName" type="text" class="form-control col-md-7 col-xs-12" 
              	name="statusName" value="${appinfo.statusName}" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appInfo" required="required"
              placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12">
              ${appinfo.appinfo}</textarea>
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <c:if test="${appinfo.logopicpath==null}">
                暂时没有图片
              </c:if>
              <c:if test="${appinfo.logopicpath!=null}">
              <img src="${pageContext.request.contextPath}/${appinfo.logopicpath}" width="30%" height="40%">
              </c:if>
              <input type="text" name="oldFileName" value="${appinfo.logopicpath}">
				<input type="file" id="a_logoPicPath" name="a_logoPicPath" value="${appinfo.logopicpath}"/>

				<div id="uploadfile" style="display: none">
				<input id="attach"  type="file" class="form-control col-md-7 col-xs-12" name="attach">
				<p><span style="color:red;font-weight: bold;">*注：1、大小不得超过500k.2、图片格式：jpg、png、jpeg、pneg</span></p>
				</div>

            </div>
          </div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
            	<c:if test="${appinfo.status == 3}">
            	 	<button id="send" type="submit" name="status" value="1" class="btn btn-success">保存并再次提交审核</button>
            	</c:if>
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back" onclick="back()">返回</button>
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
          /*2、发送异步请求获取所属平台信息*/
          $.post("${pageContext.request.contextPath }/getAppFlatformData",null,function (data) {
              for (var i=0;i<data.length;i++){
                  var  node=$("<option value='"+data[i].valueid+"'>"+data[i].valuename+"</option>");
                  $("#flatformId").append(node);
              }
              $("#flatformId").val(${appinfo.flatformid})
          },"json");

          /*3、加载一级分类*/
          $.post("${pageContext.request.contextPath }/getAppSuperclassData",{"parentId":null},function (data) {
              for (var i=0;i<data.length;i++){
                  var  node=$("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
                  $("#categoryLevel1").append(node);
              }
              //回显
              $("#categoryLevel1").val(${appinfo.categorylevel1})
              loadSecondclass();//加载二级
          },"json");

          /*4、给一级下拉列表添加onchange事件加载对应的二级事件*/
          $("#categoryLevel1").change(loadSecondclass());
          /*通过一级分类加载二级分类*/
          function loadSecondclass(){
              var parentId=$("#categoryLevel1").val();//获取一级分类的id
              //清空当前下拉框内容
              $("#categoryLevel2>option").remove();
              if (parentId!=""){
                  $.post("${pageContext.request.contextPath }/getAppSuperclassData",{"parentId":parentId},function (data) {
                      for (var i=0;i<data.length;i++){
                          var  node=$("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
                          $("#categoryLevel2").append(node);
                      }
                      $("#categoryLevel2").val(${appinfo.categorylevel2})//回显
                      /*加载二级选中项对应的子类*/
                      loadThirdclass();
                  },"json");
              }
          }

          /*5、给二级下拉框添加onchange事件加载对应的三级分类*/
          $("#categoryLevel2").change(loadThirdclass);
          /*通过二级分类三级分类*/
          function loadThirdclass() {
              var parentId=$("#categoryLevel2").val();//获取上一级分类id
              $("#categoryLevel3>option").remove();//清空当前下拉框内容
              if (parentId!=""){
                  $.post("${pageContext.request.contextPath }/getAppSuperclassData",{"parentId":parentId},function (data) {
                      for (var i=0;i<data.length;i++){
                          var  node=$("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
                          $("#categoryLevel3").append(node);
                      }
                      //回显
                      $("#categoryLevel3").val(${appinfo.categorylevel3})
                  },"json");
              }
          }
      })

</script>
<script>
  function back() {
      document.location.href="${pageContext.request.contextPath}/searchByPageHelper";
  }
</script>