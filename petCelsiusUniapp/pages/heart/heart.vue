<template>
	<!-- 这里的注意点，使用 scroll-view时，如果想让元素横向也就是X轴排列的话
	要注意以下几点：
	1、scroll-view不支持flex，默认block；
	2、scroll-view设置scroll-x="true"; width: 100%; white-space: nowrap;（这个属性很重要，能不能滑动都看这个属性）
	3、子元素设置display: inline-block；
	4、子元素内容宽度要超出scroll-view的宽。
	-->
	<view>
		<!-- 设置scroll-view的scroll-x="true"，为X轴滑动 -->
		<scroll-view scroll-x="true" class="scroll-view">
			<!-- 子元素选择用v-for进行循环遍历，因为后面要用到index -->
			<view class="body-view" v-for="(item,index) in heartLogoList" :key="index" @click="changeSwiper(index)">
				<!-- 这里是一个小提醒点，动态绑定class的值，一个三元表达式 -->
				<view :class="[currentTab==index ? 'menu-one-act' : 'menu-one']">
					<!-- <image :src="item.logo" style="width: 100rpx;" mode="widthFix"></image> -->
					{{item.title}}
				</view>
			</view>
		</scroll-view>
		<!-- swiper这边设置禁用指示点，禁止自动轮播，动态设置swiper的current属性，以便和scroll-view进行对接，在设置一个轮播切换事件
		 当swiper改变时，触发函数
		 -->
		 
		<swiper :indicator-dots="false" :autoplay="false" class="swiper" :current="currentTab" ref="swiper" @change="changeScroll">
			<block v-for="(item,index) in heartLogoList" :key="index">
				<!-- 
					pei:{
						pei:{
							[],
							[],
							[],
							[]
						},
						jun:{
							[],
							[],
							[],
							[]
						}
					}
				 -->
				 
				 
				 <!-- 
				  
				 tipic auther time
				  title
				  图片
				  -->
				<swiper-item>
					<scroll-view scroll-y="true" class="swiper-scroll">
						<!-- <view class="swiper-item">{{item}}</view> -->
						<block v-for="(item1,index1) in heartList" :key="index1">
							<view v-if="item.title == item1.title"  class="swiper-view" @click="pushDetail(item1)">
								<image :src="item1.petTopic" class="swiper-img" mode="widthFix"></image>
								<!-- <view class="swiper-text"> -->
									<view>宠物: {{item1.petname}}</view>
									<view>用户: {{item1.username}}</view>
								<!-- </view> -->
								<!-- <image src="../../static/icon/push.png" class="swiper-icon" mode="widthFix"></image> -->
							</view>
							<view v-if="item.title == '个人的' && user.id == item1.userId"  class="swiper-view" @click="pushDetail(item1)">
								<image :src="item1.petTopic" class="swiper-img" mode="widthFix"></image>
								<!-- <view class="swiper-text"> -->
									<view>宠物: {{item1.petname}}</view>
									<view>用户: {{item1.username}}</view>
								<!-- </view> -->
								<!-- <image src="../../static/icon/push.png" class="swiper-icon" mode="widthFix"></image> -->
							</view>
						</block>
					</scroll-view>
				</swiper-item>
			</block>
		</swiper>
		<!-- 添加按钮，第三方插件，uniapp悬浮按钮 -->
		<!-- <view>
			<uni-fab
				horizontal="right"
				vertical="bottom"
				iconPath="../../static/tab_icons/my.png"
				direction="horizontal"  
				:popMenu="false"
				@fabClick="fabClick"
			/>
			</view> -->
	</view>
</template>

<script>
	export default {
		data() {
			return {
				//定义swiper的初始值为0，也就是第一页
				currentTab: 0,
				//存放scrollview项
				heartLogoList: [],
				heartList:[],
				user:""
			}
		},
		onLoad() {
			uni.getSystemInfo({	//获取系统信息
				success: (res) => {
					this.swiperHeight = res.windowHeight + 'px'
				},
				fail: (res) => {
					console.log('error')
				}
			})
					
			
		},
		
		onShow() {
			this.getUser()
			// console.log(this.user)
			this.getHeartLogoList()
			this.getHeartList()
		},
		
		
		onPullDownRefresh() {
			this.getUser()
			// console.log(this.user)
			this.getHeartLogoList()
			this.getHeartList()
		},
		
		methods: {
			// 获取用户信息
			// 检测是否登录
			getUser(){
				this.user = uni.getStorageSync("user")
				// console.log(this.user)
			},
			
			
			
			// 切换swiper时，改变scroll的函数
			changeScroll: function(e) {
				// 令data中定义的currentTab等于当前swiper的current的值，来改变scroll
				this.currentTab = e.target.current;
			},
			changeSwiper: function(index) {
				// 点击scroll，将返回的参数赋值给currentTab
				if (this.currentTab == index) {
					return false;
				} else {
					this.currentTab = index;
				}
			},
			
			
			// 获取缅怀标题对应的logo用于scroll显示
			async getHeartLogoList(){
				let response = await uni.$http.get("heartApi/heartLogoList")
				// console.log(response.data.heartLogoList)
				this.heartLogoList = response.data.heartLogoList
			},
			
			
			// 获取缅怀信息列表
			async getHeartList(){
				let response = await uni.$http.get("heartApi/heartList")
				
				// console.log(response.data.heartList)
				this.heartList = response.data.heartList
			},
			
			// 点击每一项的函数
			pushDetail(item1){
				uni.navigateTo({
					// 传递对象到其他页面，并且编码
					url:"../../subpkg/heart/heartDetial/heartDetial?item=" +  encodeURIComponent(JSON.stringify(item1))
				})
				
			}
		}
	}
</script>

<style lang="scss">
	page {
		width: 100%;
		height: 90%;
	}

	.body-view {
		display: inline-block;
		width: 150rpx;
		height: 60rpx;
	}

	.scroll-view {
		/* position: fixed; */
		box-shadow: 0 2px 3px -1px rgba($color: red, $alpha: 0.3); //底部阴影
		margin: 20rpx 0;
		width: 100%;
		text-align: center;
		white-space: nowrap;
	}

	.menu-one {
		color: #999;
		height: 100%;
	}

	.menu-one-act {
		color: #000;
		height: 100%;
	}

	.swiper {
		height: 2000px;
		text-align: center;
	}

	.swiper-scroll {
		height: 100%;
		background-color: #F2F3F4;
	}
	.swiper-view{
		// 添加阴影
		// box-shadow: 8rpx 10rpx 8rpx rgba($color: #EDBB99, $alpha: 0.3);
		box-shadow: rgba($color: #000000, $alpha: 0.3) 8rpx 8rpx 8rpx;
		display: inline;
		float: left;
		// display: flex;
		// flex-wrap: nowrap;
		// position: absolute;
		border-radius: 5%;
		width: 47%;
		background-color: #FFFFFF;
		margin: 20rpx 10rpx;
		
		.swiper-img{
			border-radius: 5%;
			// margin: 20rpx 20rpx;
			width: 100%;
		}
		
		view{
			margin-left: 10rpx;
			text-align: left;
			font-size: 20rpx;
		}
		
		// .swiper-icon{
		// 	margin-top: 40rpx;
		// 	width: 50rpx;
		// }
	}
</style>
