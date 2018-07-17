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
    
    <title>论坛</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${basePath}/css/bbs/bbsindex.css" />
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
					<strong>论坛</strong>
				</div>
				<div class="ui text menu title-main-right">
					<div class="right item">
						<a href="${basePath}/bbs/bbsuserindex">
							<div class="but">
								${username}
							</div>
						</a>
					</div>
					<div class="right item but">
						<a href="http://47.95.220.233/RWY/index.jsp">
							<div class="but">
								任我游主页
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--  ==========  -->
		<!--  =   主体      =  -->
		<!--  ==========  -->
		<div class="ui segment vertical basic main">
			<!--第一部分-->
			<div class="ui grid ">
				<div class="eight wide column animated zoomInLeft">
					<div class="ui raised segment t1">
						<div class="ui image">
							<img src="${basePath}/img/bbs/index/bbsindex.jpg"/>
						</div>
					</div>
				</div>
				<div class="four wide column animated zoomInRight">
					<div class="ui raised segment t1">
						<h3 class="ui header">
						   <i class="announcement icon"></i>
						   <div class="content">最新回复</div>
						</h3>
						<div class="ui divider"></div>
						<c:forEach items="${rplayList}" var="rplay">
							<p>
								<a href="${basePath}/bbs/note/${rplay.getRtid()}">
									${rplay.getRcontent()}
									<samp style="float: right;">
										${rplay.getDate()}
									</samp>
								</a>
							</p>
						</c:forEach>
					</div>
				</div>
				<div class="four wide column animated zoomInRight">
					<div class="ui raised segment t1">
						<h3 class="ui header">
						   <i class="signal icon"></i>
						   <div class="content">热帖</div>
						</h3>
						<div class="ui divider"></div>
						<c:forEach items="${topicList}" var="topic">
							<p>
								<a href="${basePath}/bbs/note/${topic.getTid()}">
									${topic.getTtopic()}
									<samp style="float: right;">
										${topic.getDate()}
									</samp>
								</a>
							</p>
						</c:forEach>
					</div>
				</div>
			</div>
			<!--全景业界资讯-->
			
			<div class="ui raised segment animated zoomInUp">
				<h2 class="ui header">
				   	<i class="feed icon"></i>
				   	<div class="content">
				 		VR业界资讯
				   		<div class="sub header">
				   			Panoramic industry information
				   		</div>
				  	</div>
				</h2>
				<div class="ui divider"></div>
				<div class="ui grid">
					<c:forEach items="${fourmList1}" var="fourm">
						<div class="four wide column">
							<a href="${basePath}/bbs/Forumlist/VR业界资讯/${fourm.getSid()}/1">
								<div class="ui image lf">
									<img src="${basePath}/img/bbs/index/s1.png"/>
								</div>
								<div class="ri">
									<h4>${fourm.getSname()}</h4>
									<p>发帖数:${fourm.getStopiccount()}</p>
									<p>${fourm.getSstatement()}</p>
								</div>
							</a>
						</div>
					</c:forEach>	
				</div>
			</div>
			<!--全景作品-->
			<div class="ui raised segment animated zoomInUp">
				<h2 class="ui header">
				   	<i class="world icon"></i>
				   	<div class="content">
				 		VR作品
				   		<div class="sub header">
				   			Panoramic work
				   		</div>
				  	</div>
				</h2>
				<div class="ui divider"></div>
				<div class="ui grid">
					<c:forEach items="${fourmList2}" var="fourm">
						<div class="four wide column">
							<a href="${basePath}/bbs/Forumlist/VR作品/${fourm.getSid()}/1">
								<div class="ui image lf">
									<img src="${basePath}/img/bbs/index/s2.png"/>
								</div>
								<div class="ri">
									<h4>${fourm.getSname()}</h4>
									<p>发帖数:${fourm.getStopiccount()}</p>
									<p>${fourm.getSstatement()}</p>
								</div>
							</a>
						</div>
					</c:forEach>	
					
				</div>
			</div>
			<!--生活纪实-->
			<div class="ui raised segment animated zoomInUp">
				<h2 class="ui header">
				   	<i class="map icon"></i>
				   	<div class="content">
				 		生活纪实 
				   		<div class="sub header">
				   			Life documentary
				   		</div>
				  	</div>
				</h2>
				<div class="ui divider"></div>
				<div class="ui grid">
					<c:forEach items="${fourmList3}" var="fourm">
						<div class="four wide column">
							<a href="${basePath}/bbs/Forumlist/生活纪实/${fourm.getSid()}/1">
								<div class="ui image lf">
									<img src="${basePath}/img/bbs/index/s3.png"/>
								</div>
								<div class="ri">
									<h4>${fourm.getSname()}</h4>
									<p>发帖数:${fourm.getStopiccount()}</p>
									<p>${fourm.getSstatement()}</p>
								</div>
							</a>
						</div>
					</c:forEach>	
					
				</div>
			</div>
			<!--全景学苑-->
			<div class="ui raised segment animated zoomInUp">
				<h2 class="ui header">
				   	<i class="university icon"></i>
				   	<div class="content">
				 		VR学苑 
				   		<div class="sub header">
				   			Panorama Academy
				   		</div>
				  	</div>
				</h2>
				<div class="ui divider"></div>
				<div class="ui grid">
					<c:forEach items="${fourmList4}" var="fourm">
						<div class="four wide column">
							<a href="${basePath}/bbs/Forumlist/VR学苑/${fourm.getSid()}/1">
								<div class="ui image lf">
									<img src="${basePath}/img/bbs/index/s1.png"/>
								</div>
								<div class="ri">
									<h4>${fourm.getSname()}</h4>
									<p>发帖数:${fourm.getStopiccount()}</p>
									<p>${fourm.getSstatement()}</p>
								</div>
							</a>
						</div>
					</c:forEach>	
					
				</div>
			</div>
			<!--资源下载-->
			<div class="ui raised segment animated zoomInUp">
				<h2 class="ui header">
				   	<i class="folder open icon"></i>
				   	<div class="content">
				 		资源下载 
				   		<div class="sub header">
				   			Download
				   		</div>
				  	</div>
				</h2>
				<div class="ui divider"></div>
				<div class="ui grid">
					<c:forEach items="${fourmList5}" var="fourm">
						<div class="four wide column">
							<a href="${basePath}/bbs/Forumlist/资源下载/${fourm.getSid()}/1">
								<div class="ui image lf">
									<img src="${basePath}/img/bbs/index/s2.png"/>
								</div>
								<div class="ri">
									<h4>${fourm.getSname()}</h4>
									<p>发帖数:${fourm.getStopiccount()}</p>
									<p>${fourm.getSstatement()}</p>
								</div>
							</a>
						</div>
					</c:forEach>	
					
				</div>
			</div>
			<!--交流分享-->
			<div class="ui raised segment animated fadeInUp">
				<h2 class="ui header">
				   	<i class="users icon"></i>
				   	<div class="content">
				 		交流分享 
				   		<div class="sub header">
				   			Exchange sharing
				   		</div>
				  	</div>
				</h2>
				<div class="ui divider"></div>
				<div class="ui grid">
					<c:forEach items="${fourmList6}" var="fourm">
						<div class="four wide column">
							<a href="${basePath}/bbs/Forumlist/交流分享/${fourm.getSid()}/1">
								<div class="ui image lf">
									<img src="${basePath}/img/bbs/index/s3.png"/>
								</div>
								<div class="ri">
									<h4>${fourm.getSname()}</h4>
									<p>发帖数:${fourm.getStopiccount()}</p>
									<p>${fourm.getSstatement()}</p>
								</div>
							</a>
						</div>
					</c:forEach>	
					
				</div>
				
				
				
			</div>
		</div>
		
		
		
		<!--  ==========  -->
		<!--  =   底部      =  -->
		<!--  ==========  -->
		<div class="ui segment basic vertical foot">
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