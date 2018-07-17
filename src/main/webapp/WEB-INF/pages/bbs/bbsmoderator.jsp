<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bbsadmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/bbs/bbsadmin.css" />
	<%@include file="/common/context.jsp" %>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body id="box">
		<!--  ==========  -->
		<!--  =   标题      =  -->
		<!--  ==========  -->
		<div class="ui segment fixed basic menu">
			<div class="title-main">
				<div class="ui image title-main-left">
					<a href="http://47.95.220.233/RWY/index.jsp">
						<img src="${basePath}/img/logo.png"/>
					</a>
				</div>
				<div class="title-main-in">
					<strong>版主</strong>
				</div>
				<div class="ui text menu title-main-right">
					<div class="right item">
						<a href="http://47.95.220.233/RWY/index.jsp">
							<div class="but">
								${moderator}
							</div>
						</a>
					</div>
					<div class="right item but">
						<a href="http://47.95.220.233/RWY/index.jsp">
							<div class="but">
								RWY首页
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--  ==========  -->
		<!--  =   主体      =  -->
		<!--  ==========  -->
		<div class="main">
			<div class="ui top attached tabular menu contents">
			  <a class="item active" >帖子管理与审核</a>
			  <div class="right menu">
			    <div class="item">
			    </div>
			  </div>
			</div>
			<div class="ui bottom attached segment">
				<div class="ui transparent icon input searchbotton">
			        <input id="foundTopicText" type="text" placeholder="搜索帖子……">
			        <i onclick="foundTopic()" class="red search link icon"></i>
			    </div>
			   	<br /><br />
			   <table class="ui celled table">
				  <thead>
				    <tr>
				    <th>ID</th>
				    <th>帖子名</th>
				    <th>所在版块</th>
				    <th>发帖人</th>
				    <th>发帖时间</th>
				    <th>审核状态</th>
				    <th>操作</th>
				  </tr></thead>
				  <tbody id="mainContent">
				  <c:forEach  items="${twm}" var="twm">
				    <tr>
				      <td>${twm.getTID()}</td>
				      <td>${twm.getTTopic()}</td>
				      <td>${twm.getSName()}</td>
				      <td>${twm.getUName()}</td>
				      <td>${twm.getTTime()}</td>
				      <td>${twm.getTFlag()}</td>
				      <td><button onclick="dt('${twm.getTTopic()}','${twm.getTID()}','${twm.getUName()}')"  class="ui red button">删除</button>
				      <button onclick="ut('${twm.getTTopic()}','${twm.getTID()}','${twm.getUName()}')" class="ui teal button">审核</button></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				  <tfoot>
				    <tr><th colspan="7">
				      <!-- <div class="ui right floated pagination menu">
				        <a class="icon item">
				          <i class="left chevron icon"></i>
				        </a>
				        <a class="item">1</a>
				        <a class="item">2</a>
				        <a class="item">3</a>
				        <a class="item">4</a>
				        <a class="icon item">
				          <i class="right chevron icon"></i>
				        </a>
				      </div> -->
				    </th>
				  </tr></tfoot>
				</table>
			</div>
		
		</div>
		<!--  ==========  -->
		<!--  =   底部      =  -->
		<!--  ==========  -->
		<div class="ui segment basic vertical">
			<div class="ui divider"></div>
			<div class="foot menu">
				<div class="ui text left menu">
					<a class="item" href="">相关连接</a>
					<a class="item" href="http://47.95.220.233/upload/Pano2VR.zip">
						软件下载
					</a>
					<a class="item" href="http://47.95.220.233/RWY/Pano2Vr.htm">
						|使用手册|
					</a>
					
				</div>
				<div class="ui image foots">
					<img src="${basePath}/img/logofooter2.png"/>
				</div>
				<div class="rights">
					© Copyright 2018 rwy.com 湖南农业大学“任我遨游”团队制作<br />
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			$('.ui.dropdown').dropdown();
		/* 删除帖子 */
		function dt(TTopic,TID,UName){
			var a = confirm('是否删除该帖子？');
				if(a){
					$.ajax({
						type:"post",
						url:"${basePath}/bbs/moderator/deletetopic",
						data:{"TTopic":TTopic,
						"TID":TID,
						"UName":UName},
						success:function(data){
							if(data=="success"){
							window.location.href = "${basePath}/bbs/moderator";
							}else if(data=="isNull"){
								alert("帖子已经删除");
								$("#texts").val("");
							}
						}
					});
				}
		};
			/* 审核帖子 */
		function ut(TTopic,TID,UName){
			var a = confirm('是否审核该帖子？');
			if(a){
				$.ajax({
					type:"post",
					url:"${basePath}/bbs/moderator/updatetopic",
					data:{"TTopic":TTopic,
					"TID":TID,
					"UName":UName},
					success:function(data){
						if(data=="success"){
						window.location.href = "${basePath}/bbs/moderator";
						}else if(data=="isNull"){
							alert("帖子已经审核");
							$("#texts").val("");
						}
					}
				});
			}
		};
			/* 搜索帖子 */
			function foundTopic(){
				var text = $('#foundTopicText').val();
				var url = "${basePath}/bbs/moderator/foundtopicm";
				$.ajax({
					type : "post",
					async : false,  //同步请求
					url : url,
					data :{
						"TTopic":text
					},
					timeout:1000,
					success:function(dates){
						/* alert(dates); */
						$("#mainContent *").remove();//清空之前的div
						$("#mainContent").html(dates);//要刷新的div
					},
					error: function() {
		               // alert("失败，请稍后再试！");
		            }
				});
			};
		var vm = new Vue({
			el:"#box",
			data:{
			},
			methods:{
			},
		});
		
		
		</script>
	</body>
</html>