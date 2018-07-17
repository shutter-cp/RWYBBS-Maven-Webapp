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
    
    <title>管理员</title>
    
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
					<strong>管理员</strong>
				</div>
				<div class="ui text menu title-main-right">
					<div class="right item">
						<a href="#">
							<div class="but">
								${admin}
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
			  <a class="item {{show1}}" v-on:click="showAction1">帖子管理与审核</a>
			  <a class="item {{show2}}" v-on:click="showAction2">用户管理与审核</a>
			  <div class="right menu">
			    <div class="item">
			    </div>
			  </div>
			</div>
			<div class="ui bottom attached segment" v-if="show==1">
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
				  </tr>
				  </thead>
				  <tbody id="mainContent">
				  <c:forEach  items="${twa}" var="twa">
					    <tr>
					      <td>${twa.getTID()}</td>
					      <td>${twa.getTTopic()}</td>
					      <td>${twa.getSName()}</td>
					      <td>${twa.getUName()}</td>
					      <td>${twa.getTTime()}</td>
					      <td>${twa.getTFlag()}</td>
					      <td><button onclick="dt('${twa.getTTopic()}','${twa.getTID()}','${twa.getUName()}')"  class="ui red button">删除</button>
					      <button onclick="ut('${twa.getTTopic()}','${twa.getTID()}','${twa.getUName()}')" class="ui teal button">审核</button></td>
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
			<div class="ui bottom attached segment" v-if="show==2">
				<div class="ui transparent icon input searchbotton">
			        <input id="foundUserText" type="text" placeholder="搜索用户……">
			        <i onclick="foundUser()" class="red search link icon"></i>
			    </div>
			   	<br /><br />
			   <table class="ui celled table">
				  <thead>
				    <tr><th>用户名</th>
				    <th>电子邮件</th>
				    <th>注册日期</th>
				    <th>用户状态</th>
				    <th>用户U币</th>
				    <th>是否版主</th>
				  	<th>操作</th>
				  </tr></thead>
				  <tbody id="mainContents">
				  <c:forEach  items="${uwa}" var="uwa">
					    <tr>
					      <td>${uwa.getUName()}</td>
					      <td>${uwa.getUEmail()}</td>
					      <td>${uwa.getURegDate()}</td>
					      <td>${uwa.getUState()}</td>
					      <td>${uwa.getUPoint()}</td>
					      <td>${uwa.getUIsSectioner()}</td>
					      <td>
						      <button onclick="du('${uwa.getUName()}')" class="ui red button">删除</button>
						      <button  class="ui teal button" onclick="sm('${uwa.getUName()}')">设定版主</button>
					      </td>
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
				          <i class="right chevron icon"></i> -->
				        </a>
				      </div>
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
		 /* 设定版主 */
			function sm(uname){
				$.ajax({
					type:"post",
					url:"${basePath}/bbs/admin/set",
					data:{"uname":uname},
					success:function(data){
						if(data=="success"){
						window.location.href = "${basePath}/bbs/admin/setmoderator";
						}else if(data=="isNull"){
							alert("评论出错");
							$("#texts").val("");
						}
					}
				});
			};
			/* 删除用户 */
		function du(uname){
		var a = confirm('是否删除该用户？');
				if(a){
					$.ajax({
						type:"post",
						url:"${basePath}/bbs/admin/deleteuser",
						data:{"uname":uname},
						success:function(data){
							if(data=="success"){
							window.location.href = "${basePath}/bbs/admin";
							}else if(data=="isNull"){
								alert("用户已经删除");
								$("#texts").val("");
							}
						}
					});
				}
		};
			/* 删除帖子 */
		function dt(TTopic,TID,UName){
		var a = confirm('是否删除该帖子？');
				if(a){
					$.ajax({
						type:"post",
						url:"${basePath}/bbs/admin/deletetopic",
						data:{"TTopic":TTopic,
						"TID":TID,
						"UName":UName},
						success:function(data){
							if(data=="success"){
							window.location.href = "${basePath}/bbs/admin";
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
						url:"${basePath}/bbs/admin/updatetopic",
						data:{"TTopic":TTopic,
						"TID":TID,
						"UName":UName},
						success:function(data){
							if(data=="success"){
							window.location.href = "${basePath}/bbs/admin";
							}else if(data=="isNull"){
								alert("帖子已经审核");
								$("#texts").val("");
							}
						}
					});
				}
			};
			/* 搜索用户 */
			function foundUser(){
				var text = $('#foundUserText').val();
				var url = "${basePath}/bbs/admin/founduser";
				$.ajax({
					type : "post",
					async : false,  //同步请求
					url : url,
					data :{
						"UName":text
					},
					timeout:1000,
					success:function(dates){
						/* alert(dates); */
						$("#mainContents *").remove();//清空之前的div
						$("#mainContents").html(dates);//要刷新的div
					},
					error: function() {
		               // alert("失败，请稍后再试！");
		            }
				});
			};
			
			/* 搜索帖子 */
			function foundTopic(){
				var text = $('#foundTopicText').val();
				var url = "${basePath}/bbs/admin/foundtopic";
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
			/* 分栏显示 */
		var vm = new Vue({
			el:"#box",
			data:{
				show:1,
				show1:'active',
				show2:''
			},
			methods:{
				showAction1:function(){
					this.show = 1;
					this.show1='active';
					this.show2='';
				},
				showAction2:function(){
					this.show = 2;
					this.show1='';
					this.show2='active';
				}
			},
		});
		
		
		</script>
	</body>
</html>