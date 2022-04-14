<template>
	<view class="content">
		
		<view v-if="user == ''">
			<button type="primary" style="top: 500rpx; width: 200rpx;" @click="tologin">去登陆</button>
		</view>
		
		<view v-else  class="userInfo" style="">
			<view class="tou">
				<image :src="user.topic" class="xiang"></image>
			</view>
			
			<view class="name">
				<text style="font-size: 40rpx;">用户:{{user.username}}</text>
			</view>
			
			<view class="mobile">
				<text style="font-size: 40rpx;">账号:{{user.mobile}}</text>		
			</view>
			<view>
				<button type="primary" style="height: 80rpx; width: 200rpx; text-align: center; top: 30rpx;" @click="toalter">修改</button>
			</view>
			<view>
				<button type="primary" style="height: 80rpx; width: 200rpx; text-align: center; top: 30rpx;" @click="logout">退出登录</button>
			</view>
			
		</view>
		
		
	<!-- 	<view class="tou">
			<image src="../../static/my/touxiang.png" class="xiang"></image>
		</view> -->
		<!-- <view class="name">
			<text style="font-size: 40rpx;">用户：杨洋</text>
		</view>
		<view class="sex">
			<text style="font-size: 40rpx;">性别：男</text>
		</view>
		<view class="like">
			<text style="font-size: 40rpx;">爱好：爱好旅游，象棋，游泳，特长是乒乓球</text>
		</view> -->
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:""
			};
		},
		onShow() {
			this.checkUser()
			// console.log(this.user)
			// console.log(this.user)
			// console.log("user===>",this.user)
			
		},
		methods:{
			// 检测是否登录
			checkUser(){
				this.user = uni.getStorageSync("user")
				
			},
			
			// 跳转登录页面
			tologin(){
					uni.navigateTo({
						url:"../login/login"
					})	
				},
				
			// 跳转用户修改页面
			toalter(){
				uni.navigateTo({
					url:"../alterUserInfo/alterUserInfo"
				})
			},
			
			// 退出登录
			logout(){
				uni.removeStorageSync("user")
				uni.$showMsg("退出成功")
				uni.navigateTo({
					url:"../login/login"
				})
			}					
			}
		
	}
</script>

<style lang="scss">
	page{
		background-color: #ffffcc
	}
	
	.userInfo{
		text-align: center;
		left: 0;
		right: 0;
		position: fixed;
		top: 500rpx;
		font-weight: 400;
	}

	
	.tou{
		position: fixed;
		top: 200rpx;
		left: 270rpx;
	}
	.xiang{
		width: 200rpx;
		height: 200rpx;
		border-radius: 50%;
	}
	.name .mobile{
		position: fixed;
		top: 450rpx;
		left: 270rpx;
	}
	

</style>
