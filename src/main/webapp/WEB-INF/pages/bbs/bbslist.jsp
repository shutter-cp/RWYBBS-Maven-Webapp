<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bbslist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/semantic.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/bbs/bbslist.css" />
	<script src="${basePath}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/semantic.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/vue1.js" type="text/javascript" charset="utf-8"></script>
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
						<img src="${basePath}/img/logo.png" />
					</a>
				</div>
				<div class="title-main-in">
					<strong>论坛</strong>
				</div>
				<div class="ui text menu title-main-right">
					<div class="right item">
						<a href="#">
							<div class="but">
								username
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
		<div class="ui grid container main">
			<!--左边-->
			<div class="four wide column">
				<div class="ui sticky">
					<div class="ui raised segment">
						<h3 class="listtitle"><i class="large red tasks icon"></i>板块导航</h3>
						<a herf>
							<p class="lists"><i class="circular inverted red feed icon"></i>全景业界资讯</p>
						</a>
						<a herf>
							<p class="lists"><i class="circular inverted red world icon"></i>全景作品</p>
						</a>
						<a herf>
							<p class="lists"><i class="circular inverted red map icon"></i>生活纪实</p>
						</a>
						<a herf>
							<p class="lists"><i class="circular inverted red university icon"></i>全景学苑</p>
						</a>
						<a herf>
							<p class="lists"><i class="circular inverted red folder open icon"></i>资源下载</p>
						</a>
						<a herf>
							<p class="lists"><i class="circular inverted red users icon"></i>交流分享</p>
						</a>
					</div>
				</div>
			</div>
			<!--右边-->
			<div class="twelve wide column" id="leftlist">
				<div class="ui raised segment ritghttitle">
					<h3><i class="circular inverted red feed icon"></i>全景业界资讯 Panoramic work</h3>
					<p class="nodenum">帖子数：</p>
				</div>
				<div class="ui sticky">
					<button class="ui red button addbutton">
							<i class="add to calendar icon"></i>发布新帖子
					</button>
				</div>
				<div class="ui raised segment contents">
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
					<div class="ui vertical segment">
						1<br /><br /><br /><br />
					</div>
				</div>
				<div class="ui pagination menu pagebutton">
					<a class="active item">
						1
					</a>
					<div class="disabled item">
						...
					</div>
					<a class="item">
						10
					</a>
					<a class="item">
						11
					</a>
					<a class="item">
						12
					</a>
				</div>
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
					<img src="${basePath}/img/logofooter2.png" />
				</div>
				<div class="rights">
					© Copyright 2018 rwy.com 湖南农业大学“任我遨游”团队制作<br />
				</div>
			</div>
		</div>

		<script type="text/javascript">
			$('.ui.sticky')
				.sticky({
					context: '#leftlist',
					pushing: true,
					offset: 50
				});
		</script>
	</body>
