<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
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

  </head>
  
 <body id="box">
		<!--  ==========  -->
		<!--  =   标题      =  -->
		<!--  ==========  -->
		<div class="ui segment fixed basic menu animated fadeInDown">
			<div class="title-main">
				<div class="ui image title-main-left">
					<a href="http://47.95.220.233/RWY/index.jsp">
						<img src="${basePath}/img/logo.png"/>
					</a>
				</div>
				<div class="title-main-in">
					<strong>个人中心</strong>
				</div>
				<div class="ui text menu title-main-right">
					<div class="right item">
						<a href="${basePath}/bbs/bbsuserindex">
							<div class="but">
								${user.getUname()}
							</div>
						</a>
					</div>
					<div class="right item but">
						<a href="#">
							<div class="but">
								论坛
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--  ==========  -->
		<!--  =   主体      =  -->
		<!--  ==========  -->
		<form action="${basePath}/addUserDo" method="post" class="ui form">
			<div class="ui basic segment vertical main  animated rubberband">
				<div class="ui raised very padded segment">
					<h1 class="ui header"><i class="ui red icon write square"></i>请完善你的个人信息</h1>
					<!--不可编辑的信息-->
					
					<div class="ui form">
						<div class="two fields">
							<div class="disabled field">
								<label>用户ID</label>
								<input name="uid"  type="text"  value="${user.getUid()}">
							</div>
							<div class="disabled field">
								<label>用户昵称</label>
								<input name="uname" type="text" value="${user.getUname()}">
							</div>
						</div>
					</div><br />
					
					<div class="ui form">
						<div class="two fields">
							<div class="disabled field">
								<label>密码</label>
								<input name="password" type="password" value="${user.getUpassword()}">
							</div>
							<div class="disabled field">
								<label>邮箱</label>
								<input name="umailbox" type="text"  value="${user.getUmailbox()}">
							</div>
						</div>
					</div><br />
					
					<div class="ui form">
						<div class="two fields">
							<div class="disabled field">
								<label>手机号码</label>
								<input name="phone_number" type="text" value="${user.getPhone_number()}">
							</div>
							<div class="disabled field">
								<label>U币</label>
								<input name="upoint" type="text"  value="${user.getTakegold()}">
							</div>
						</div>
					</div><br />
					
					<div class="ui form">
						<div class="two fields">
							<div class="disabled field">
								<label>注册日期</label>
								<input name="uregdate" type="text" value="${user.getCreatedate()}">
							</div>
							<div class="disabled field">
								<label>用户头像</label>
								<input name="uhead" type="text" value="${user.getUpicture()}">
							</div>
						</div>
					</div><br />
					<!--完善的信息-->
					<div class="ui form">
						<div class="field">
							<label>性别</label>
							<div class="ui selection dropdown">
								<input name="sex" type="hidden" value="">
								<i class="dropdown icon"></i>
								<div class="default text">性别</div>
								<div class="menu">
									<div class="item" data-value="1">男</div>
									<div class="item" data-value="0">女</div>
								</div>
							</div>
						</div>
					</div><br />
					<div class="field">
						<label>生日</label>
						<input name="birth" type="text" placeholder="年/月/日  (2018/07/12)" value="">
					</div>
					<div class="field">
						<label>个人简介</label>
						<input name="satement" name="uid" type="text" placeholder="一句话描述自己。" value="">
					</div><br />
					  <button class="ui teal button" type="submit">提交</button><br /><br />
				</div>
			</div>
		</form>
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
			$('.ui.selection.dropdown')
			  .dropdown()
			;
	
		</script>
	</body>
</html>