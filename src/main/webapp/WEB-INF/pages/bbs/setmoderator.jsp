<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>设定版主</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/bbs/bbsadduser.css" />
	<%@include file="/common/context.jsp" %>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	.ui.basic.segment.vertical.main{
		min-height: 80%;
	}
	.ui.raised.very.padded.segment{
		margin-top: 10%;
	}
	</style>
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
					<strong>设定版主</strong>
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
						<a href="${basePath}/bbs/index">
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
		<div class="ui basic segment vertical main">
			<div class="ui raised very padded segment">
				<h1 class="ui header"><i class="ui red icon key"></i>版主信息填写</h1>
				
				
			
				<!--填写版主信息-->
			
				
				<form action="${basePath}/bbs/admin/setmoderatorDo" method="post" class="ui form">
					<div class="field">
						<label>用户名</label>
						<input name="UName" type="text" readonly="readonly" value="${unames}">
					</div>
					<div class="field">
						<label>版块名称</label>
						<input name="SName" type="text" placeholder="版块名称" value="">
					</div>
					<div class="field">
					<label>版块主题选择</label>
					<select name="SProfile" class="ui search dropdown">
						 <option value="VR业界资讯">VR业界资讯</option>
						 <option value="VR作品">VR作品</option>
						 <option value="生活纪实">生活纪实</option>
						 <option value="VR学苑">VR学苑</option>
						 <option value="资源下载">资源下载</option>
						 <option value="交流分享">交流分享</option>
					</select>
					</div>
					<div class="field">
						<label>版块留言</label>
						<input name="SStatement" type="text" placeholder="版块留言" value="">
					</div><br />
					  <button class="ui teal button" type="submit">提交</button><br /><br />
				</form>
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
			
		</script>
	</body>
</html>