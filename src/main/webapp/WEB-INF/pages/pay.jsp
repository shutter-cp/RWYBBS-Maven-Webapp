<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	
		<title>充值</title>
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="${basePath}/css/semantic.css" />
		<link rel="stylesheet" type="text/css"
			href="${basePath}/css/pay/pay.css" />
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
					<a href="http://47.95.220.233/RWY/index.jsp">
						<img src="img/logo.png"/>
					</a>
				</div>
				<div class="title-main-in">
					<strong>充值中心</strong>
				</div>
				<div class="ui text menu title-main-right">
					<div class="right item">
						<a href="#">
							<div class="but">
								${username.getUname()}
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
		<div class="ui segment basic vertical">
			<div class="ui grid">
				<div class="three wide column">
					<div class="ui segment center aligned raised very padded">
						<div class="ui image">
							<img src="img/pay/90.png"/>
						</div>
						<h2>U币</h2>
						<h5><a href="http://renwoyou.xin/">renwoyou.xin</a></h5>
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
							<samp class="uid">充值账号：${username.getUname()}</samp>
							<samp class="uid">U币：${username.getTakegold()}</samp>
							<h4 class="ui horizontal divider header">
								<i class="bitcoin icon"></i>
								 数额 
							</h4>
							
							<div class="ui grid">
								<div class="four wide column"
									v-on:click="is(100)">
									<div class="ui {{money.money100}} segment aligned raised  padded">
										<div class="ui image">
											<img class="miniIoc" src="img/pay/90.png"/>
										</div>
										<strong>100</strong>
										<div class="ui divider"></div>
										10元
									</div>
								</div>
								<div class="four wide column"
									v-on:click="is(200)">
									<div class="ui {{money.money200}} segment aligned raised  padded">
										<div class="ui image">
											<img class="miniIoc" src="img/pay/90.png"/>
										</div>
										<strong>200</strong>
										<div class="ui divider"></div>
										20元
									</div>
								</div>
								<div class="four wide column"
									v-on:click="is(500)">
									<div class="ui {{money.money500}} segment aligned raised  padded">
										<div class="ui image">
											<img class="miniIoc" src="img/pay/90.png"/>
										</div>
										<strong>500</strong>
										<div class="ui divider"></div>
										50元
									</div>
								</div>
								<div class="four wide column"
									v-on:click="is(1000)">
									<div class="ui {{money.money1000}} segment aligned raised  padded">
										<div class="ui image">
											<img class="miniIoc" src="img/pay/90.png"/>
										</div>
										<strong>1000</strong>
										<div class="ui divider"></div>
										100元
									</div>
								</div>
							</div>
							
							
							
							<h4 class="ui horizontal divider header">
								<i class="tag icon"></i>
								 支付方式 
							</h4>
							<!--支付方式-->
							<div class="ui grid">
								<div class="four wide column"
									v-on:click="isZ(1)">
									<div class="ui {{zPay.pay1}} segment aligned raised">
										微信支付
									</div>
								</div>
								<div class="four wide column"
									v-on:click="isZ(2)">
									<div class="ui {{zPay.pay2}} segment aligned raised">
										支付宝支付
									</div>
								</div>
								<div class="four wide column"
									v-on:click="isZ(3)">
									<div class="ui {{zPay.pay3}} segment aligned raised">
										QQ钱包支付
									</div>
								</div>
								<div class="four wide column"
									v-on:click="isZ(4)">
									<div class="ui {{zPay.pay4}} segment aligned raised">
										京东钱包支付
									</div>
								</div>
							</div>
							
							<!--二维码-->
							<h4 class="ui horizontal divider header">
								<i class="qrcode icon"></i>
								 支付 
							</h4>
							<div class="ui image">
								<div class="ui  segment aligned raised">
									<img src="img/pay/pay{{moneyIs}}_{{payIs}}.png"/>
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
					<img src="img/logofooter2.png"/>
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
					money:{
						money100:'blue',
						money200:'',
						money500:'',
						money1000:''
					},
					zPay:{
						pay1:'blue',
						pay2:'',
						pay3:'',
						pay4:''
					},
					moneyIs:10,
					payIs:1
				},
				methods:{
					is:function (moneys){
						if(moneys==100){
							this.money.money100='blue';
							this.money.money200='';
							this.money.money500='';
							this.money.money1000='';
							this.moneyIs=10;
						}else if(moneys==200){
							this.money.money100='';
							this.money.money200='blue';
							this.money.money500='';
							this.money.money1000='';
							this.moneyIs=20;
						}
						else if(moneys==500){
							this.money.money100='';
							this.money.money200='';
							this.money.money500='blue';
							this.money.money1000='';
							this.moneyIs=50;
						}else{
							this.money.money100='';
							this.money.money200='';
							this.money.money500='';
							this.money.money1000='blue';
							this.moneyIs=100;
						}
					},
					isZ:function (No){
						if(No==1){
							this.zPay.pay1='blue';
							this.zPay.pay2='';
							this.zPay.pay3='';
							this.zPay.pay4='';
							this.payIs=1;
						}else if(No==2){
							this.zPay.pay1='';
							this.zPay.pay2='blue';
							this.zPay.pay3='';
							this.zPay.pay4='';
							this.payIs=2;
						}
						else if(No==3){
							this.zPay.pay1='';
							this.zPay.pay2='';
							this.zPay.pay3='blue';
							this.zPay.pay4='';
							this.payIs=3;
						}else{
							this.zPay.pay1='';
							this.zPay.pay2='';
							this.zPay.pay3='';
							this.zPay.pay4='blue';
							this.payIs=4;
						}
					}
				}
			});
		</script>
	</body>
</html>
