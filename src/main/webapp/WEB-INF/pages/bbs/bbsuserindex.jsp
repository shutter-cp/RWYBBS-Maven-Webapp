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
    
    <title>My JSP 'bbsuserindex.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${basePath}/css/semantic.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/bbs/bbsuserindex.css" />
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
						<img src="${basePath}/img/logo.png"/>
					</a>
				</div>
				<div class="title-main-in">
					<strong>个人中心</strong>
				</div>
				<div class="ui text menu title-main-right">
					<div class="right item">
						<a href="#">
							<div class="but">
								${username}
							</div>
						</a>
					</div>
					<div class="right item but">
						<a href="${basePath}/bbs/index">
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
		
		<!--个人中心-->
		<div class="ui basic segment vertical main">
			<div class="ui raised very padded segment">
				<div class="ui grid">
					<div class="three wide conten">
						<div class="ui image">
							<img src="${basePath}/img/upload/userimg.png"/>	
						</div>
					</div>
					<div class="thirteen wide conten">
						<div class="ui header">
							${username}
						</div>
						<div class="ui text menu">
							<a class="item">生日:${person.getUbirthady()}</a>
							<div class="item">|</div>
							<a class="item">性別: 
								<c:if test="${person.getUsex()=='1'}">男</c:if>
								<c:if test="${person.getUsex()=='0'}">女</c:if>
							</a>
							<div class="item">|</div>
							<a class="item">电子邮件:${person.getUemail()}</a>
						</div>	
						<div class="ui divider"></div>
							<p>U币:${person.getUpoint()}</p>
					</div>
				</div>
			</div>
				<div class="ui grid">
					<div class="twelve wide column">
						<div class="ui raised very padded segment">
							<a class="ui red ribbon label"><h3>我的帖子</h3></a><br /><br />
								<p></p>
							<table class="ui fixed table">
								<thead>
									<tr>
										<th>标题</th>
										<th>正文</th>
										<th>发帖时间</th>
										<th>管理</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${articleList}" var="article">
										<tr>
											<td>${article.getTtopic()}</td>
											<td>${article.getTcontents()}</td>
											<td>${article.getTtime()}</td>
											<td>
												<button  class="ui button teal" >修改</button>
												<button onclick="deletes('${article.getTid()}')" class="ui button red" >删除</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="four wide column">
						<div class="ui raised very padded segment">
							<h3 class="ui header"><i class="red announcement icon"></i>我的消息</h3>
							<div class="ui very padded">
								<c:forEach items="${messageList}" var="message">
									<p>
										<i class="ui icon book"></i>${message.getRcontent()}
										<span style="float: right;">${message.getRtime()}</span>
									</p>
								</c:forEach>	
							</div>
						</div>
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
					<img src="${basePath}/img/logofooter2.png"/>
				</div>
				<div class="rights">
					© Copyright 2018 rwy.com 湖南农业大学“任我遨游”团队制作<br />
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			function deletes(no){
				$.ajax({
					type:"post",
					url:"${basePath}/bbs/bbsuserindex/deletes",
					data:{"no":no},
					success:function(data){
						if(data=="success"){
							alert('确认删除?')
							location.reload();
						}else if(data=="isNull"){
							alert("评论出错");
							$("#texts").val("");
						}
					}
				});
			};
		
		</script>
	</body>
</html>
