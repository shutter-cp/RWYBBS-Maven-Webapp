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
	<link rel="stylesheet" type="text/css" href="${basePath}/css/bbs/bbsnote.css" />
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
						<a href="${basePath}/bbs/index">
							<div class="but">
								首页
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--  ==========  -->
		<!--  =   主体      =  -->
		<!--  ==========  -->
		<div class="ui segment basic vertical main">
			<div class="ui grid">
				<!--左边-->
				<div  id="text"  class="twelve wide column animated zoomInLeft">
					<!--这里是标题-->
					<div class="ui raised very padded segment ">
						<div class="ui two column grid">
							<div class="column">
								<h1>${note.getTtopic()}</h1>
								<p>${note.getDate()}</p>
							</div>
							<div class="column">
								<p class="views">浏览量：${note.getTclickcoount()}</p>
							</div>
						</div>
					</div>
					<!--文章内容-->
					<div class="ui raised segment very padded contents">
						${note.getTcontents()}
					</div>
					<!--回帖-->
					<div class="ui raised segment very padded animated zoomInLeft">
						<div class="ui comments reply">
							<h3 class="ui dividing header">评论</h3>
							
							<c:forEach items="${noteRplayList}" var="noteRplay">
								<div class="comment">
									<a class="myimages">
										<img src="${basePath}/img/${noteRplay.getUhead()}">
									</a>
									<div class="content">
										<a class="author">${noteRplay.getUname()}</a>
										<div class="metadata">
											<span class="date">${noteRplay.getRtime()}</span>
										</div>
										<div class="text">${noteRplay.getRcontent()}</div>
									</div>
								</div>
							</c:forEach>
							
							<form class="ui reply form">
								<div class="field">
									<textarea v-model="texts" id="texts"></textarea>
								</div>
								<div onclick="wr()" class="ui blue labeled teal submit icon button">
									<i class="icon edit"></i> 
									提交
								</div>
								<div class="wordNumber">
									您还可以输入：{{200-texts.length}}个字
								</div>
							</form>
						</div>
					</div>
				</div>
				<!--右边-->
				<div class="four wide column animated zoomInRight">
					<div class="ui raised segment ">
						<h3><i class="ui icon large flag red outline"></i>个人资料</h3>
						<div class="ui segment vertical basic center aligned ">
							<div class="ui image userLogo">
								<img src="${basePath}/img/${note.getGuhead()}"/>
							</div>
							<div class="ui header">
								用户：${note.getGuname()}
							</div>
							<p>U币：${note.getGupoint()}</p>
						</div>
					</div>
					<div class="ui raised segment ">
						<h3><i class="ui icon large red book"></i>最新帖子</h3>
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
					<div class="ui sticky">
						<div class="ui raised segment ">
							<h3>
								<i class="ui icon large red volume control phone"></i>
								联系我们
							</h3>
							<div class="ui segment vertical basic center aligned">
								<div class="ui image">
									<img src="${basePath}/img/pay/pay100_2.png"/>
								</div>
							</div>
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
			$('.ui.sticky')
			  .sticky({
			  	offset:50,
			    context: '#text',
			    pushing: true

			  });
			  
			 /* 评论 */
			function wr(){
				var text = $("#texts").val();
				$.ajax({
					type:"post",
					url:"${basePath}/bbs/note/write",
					data:{"text":text,"no":${note.getTid()}},
					success:function(data){
						if(data=="success"){
							location.reload();
						}else if(data=="isNull"){
							alert("评论出错");
							$("#texts").val("");
						}
					}
				});
			};
			
			var vm = new Vue({
				el:"#box",
				data:{
					texts:""
				},
				methods:{
					
				},
				watch:{
					texts: function(){
						if(200-this.texts.length<0){
							alert('超出字数限制');
							$('#texts').val($('#texts').val().substr(0,200));
						}
						
					}
				}
			});
			
			
		</script>
	</body>
</html>