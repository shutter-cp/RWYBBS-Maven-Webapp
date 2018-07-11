<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		
		<title>提现</title>
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="${basePath}/css/semantic.css" />
		<link rel="stylesheet" type="text/css"
			href="${basePath}/css/pay/withdraw.css" />
		<script src="${basePath}/js/jquery.min.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="${basePath}/js/semantic.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="${basePath}/js/vue1.js" type="text/javascript"
			charset="utf-8"></script>
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
				<a href="http://47.95.220.233/RWY/index.jsp"> <img
					src="img/logo.png" />
				</a>
			</div>
			<div class="title-main-in">
				<strong>提现中心</strong>
			</div>
			<div class="ui text menu title-main-right">
				<div class="right item">
					<a href="#">
						<div class="but">username</div>
					</a>
				</div>
				<div class="right item but">
					<a href="#">
						<div class="but">论坛</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!--  ==========  -->
	<!--  =   主体      =  -->
	<!--  ==========  -->
	<div class="ui segment basic vertical">
		<div class="ui grid container">
			<div class="three wide column">
				<div class="ui segment center aligned raised very padded">
					<div class="ui image">
						<img src="img/pay/90.png" />
					</div>
					<h2>U币</h2>
					<h5>
						<a href="http://renwoyou.xin/">renwoyou.xin</a>
					</h5>
					<br />
					<h5>10U币/元</h5>
					<h5>·U币可以用来欣赏付费VR实景图</h5>
					<h5>·U币仅能用于兑换任我游直接运营的产品和服务，可以兑换现金，不能进行转账交易</h5>
					<br />
				</div>
			</div>
			<div class="thirteen wide column">
				<div class="ui segment center aligned raised raised">
					<div class="main-in">
						<samp class="uid">充值账号：username</samp>
						<samp class="uid">余额：username</samp>
						<h4 class="ui horizontal divider header">
							<i class="bitcoin icon"></i> 提现
						</h4>

						目前只仅支持支付宝提现
						<div class="ui grid container mian">
							<div class="six wide column">
								<div class="ui segment aligned raised  ">
									<div class="ui image">
										<img src="img/zfblogo.png" />
									</div>
								</div>
							</div>
							<div class="ten wide column">
								<div class="ui segment aligned raised  ">
									<div class="ui right labeled left icon input">
										<i class="credit card alternative icon"></i> <input
											type="text" placeholder="支付宝账号" value=""> <a
											class="ui tag label">支付宝账号 </a>
									</div>
									<div class="ui right labeled left icon input">
										<i class="yen icon"></i> <input type="text" id="moneyId"
											v-model="moneys" placeholder="提现金额" value=""> <a
											class="ui tag label">可提{{1000-moneys}}</a>
									</div>

								</div>
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
				<a class="item" href="">相关连接</a> <a class="item"
					href="http://47.95.220.233/upload/Pano2VR.zip"> 软件下载 </a> <a
					class="item" href="http://47.95.220.233/RWY/Pano2Vr.htm">
					|使用手册| </a>

			</div>
			<div class="ui image foots">
				<img src="img/logofooter2.png" />
			</div>
			<div class="rights">
				© Copyright 2018 rwy.com 湖南农业大学“任我遨游”团队制作<br />
			</div>
		</div>
	</div>

	<script type="text/javascript">
			
			var vm = new Vue({
				el:"#box",
				data:{
					
				},
				methods:{
					
				},
				watch:{
					moneys: function(){
						if(1000-this.moneys<0){
							alert('超出额度');
							$('#moneyId').val(0);
						}
						
					}
				}
			});
		</script>
</body>
</html>
