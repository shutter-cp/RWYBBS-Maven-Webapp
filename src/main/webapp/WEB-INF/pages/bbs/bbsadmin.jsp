<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="${basePath}/css/semantic.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/bbs/bbsadmin.css" />
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
					<strong>管理员</strong>
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
			        <input type="text" placeholder="搜索帖子……">
			        <i class="red search link icon"></i>
			    </div>
			   	<br /><br />
			   <table class="ui celled table">
				  <thead>
				    <tr><th>帖子名</th>
				    <th>所在版块</th>
				    <th>发帖人</th>
				    <th>标题</th>
				    <th>发帖时间</th>
				    <th>审核状态</th>
				    <th>操作</th>
				  </tr></thead>
				  <tbody>
				    <tr>
				     <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td><button class="ui red button">删除</button><button class="ui teal button">审核</button></td>
				    </tr>
				    <tr>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cl</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td><button class="ui red button">删除</button><button class="ui teal button">审核</button></td>
				    </tr>
				    <tr>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td><button class="ui red button">删除</button><button class="ui teal button">审核</button></td>
				    </tr>
				  </tbody>
				  <tfoot>
				    <tr><th colspan="7">
				      <div class="ui right floated pagination menu">
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
				      </div>
				    </th>
				  </tr></tfoot>
				</table>
			</div>
			<div class="ui bottom attached segment" v-if="show==2">
				<div class="ui transparent icon input searchbotton">
			        <input type="text" placeholder="搜索用户……">
			        <i class="red search link icon"></i>
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
				  <tbody>
				    <tr>
				     <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td><button class="ui red button">删除</button><button class="ui teal button">审核</button></td>
				    </tr>
				    <tr>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td><button class="ui red button">删除</button><button class="ui teal button">审核</button></td>
				    </tr>
				    <tr>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td>Cell</td>
				      <td><button class="ui red button">删除</button><button class="ui teal button">审核</button></td>
				    </tr>
				  </tbody>
				  <tfoot>
				    <tr><th colspan="7">
				      <div class="ui right floated pagination menu">
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