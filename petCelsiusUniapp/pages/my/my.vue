<template>
	<view class="content">
		
		<!-- 未登录 -->
		<view v-if="user == ''" class="not_login" @click="tologin">
			<!-- <button type="primary" style="top: 500rpx; width: 200rpx;" @click="tologin">去登陆</button> -->
			<view>未登录</view>
			<image src="../../static/icon/push.png" mode="widthFix" ></image>
		</view>
		
		<!-- 已经登录 -->
		<view v-else  class="userInfo">
			<view class="logined">
				<block v-if="user.topic==null">
					<image src="../../static/1.png" mode="widthFix"></image>
				</block>
				<block v-else>
					<image :src="user.topic" mode="widthFix"></image>
				</block>
				<view class="content">
						<view>
							昵称:&nbsp;&nbsp;{{user.username}}
						</view>
						<view >
							账号:&nbsp;&nbsp;{{user.mobile}}
						</view>
				</view>
			</view>
			<view class="logined">
				<view class="alter-content" @click="toalter">
					<view>修改用户</view>
					<image src="../../static/icon/push.png" mode="widthFix" ></image>
				</view>
			</view>
			<view class="logined">
				<view class="logout-content" @click="logout">
					<view>退出登录</view>
					<image src="../../static/icon/push.png" mode="widthFix" ></image>
				</view>
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
				// console.log(this.user)
			},
			
			// 跳转登录页面，默认的短信验证码登录
			tologin(){
					uni.navigateTo({
						url:"../../subpkg/user/loginByMobile/loginByMobile"
					})	
				},
				
				
			// 跳转登录页面，邮箱验证码方式
			// tologin(){
			// 		uni.navigateTo({
			// 			url:"../../subpkg/user/loginByEmail/loginByEmail"
			// 		})	
			// 	},
				
				
			// 跳转用户修改页面
			toalter(){
				uni.navigateTo({
					url:"../../subpkg/user/alterUser/alterUser"
				})
			},
			
			// 退出登录,使用邮箱的
			// logout(){
			// 	uni.removeStorageSync("user")
			// 	uni.$showMsg("退出成功")
			// 	uni.navigateTo({
			// 		url:"../../subpkg/user/loginByEmail/loginByEmail"
			// 	})
			// }	
							
			// 退出登录,使用手机号的
			logout(){
				uni.removeStorageSync("user")
				uni.$showMsg("退出成功")
				uni.navigateTo({
					url:"../../subpkg/user/loginByMobile/loginByMobile"
				})
			}			
							
							
			}
		
	}
</script>

<style lang="scss">
	page{
		background-color: #F3F3F4
	}
	
	.userInfo{
		
	}

	.not_login{
		display: flex;
		flex-wrap: nowrap;
		background-color: #FFFFFF;
		margin: 20rpx 0;
		view{
			margin: 20rpx 20rpx;
			text-align: left;
			width: 650rpx;
			height: auto;
		}
		image{
			margin-top: 15rpx;
			width: 50rpx;
		}
	}
	
	.logined{
		display: flex;
		flex-wrap: nowrap;
		background-color: #FFFFFF;
		margin: 20rpx 0;
		image{
			border-radius: 50%;
			margin: 20rpx 20rpx;
			width: 100rpx;
		}
		.alter-content{
			display: flex;
			flex-wrap: nowrap;
			background-color: #FFFFFF;
			view{
				margin: 20rpx 20rpx;
				text-align: left;
				width: 630rpx;
				height: auto;
			}
			image{
				width: 50rpx;
			}
		}
		
		.logout-content{
			display: flex;
			flex-wrap: nowrap;
			background-color: #FFFFFF;
			view{
				margin: 20rpx 20rpx;
				text-align: left;
				width: 630rpx;
				height: auto;
			}
			image{
				width: 50rpx;
			}
		}
		
		.content{
			margin: 20rpx 20rpx;
			text-align: left;
			width: 500rpx;
			height: auto;
		}
	}
	

</style>
