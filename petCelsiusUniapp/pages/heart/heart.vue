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
			<view class="body-view" v-for="(item,index) in scrollViewList" :key="index" @click="changeSwiper(index)">
				<!-- 这里是一个小提醒点，动态绑定class的值，一个三元表达式 -->
				<view :class="[currentTab==index ? 'menu-one-act' : 'menu-one']">
					{{item}}
				</view>
			</view>
		</scroll-view>
		<!-- swiper这边设置禁用指示点，禁止自动轮播，动态设置swiper的current属性，以便和scroll-view进行对接，在设置一个轮播切换事件
		 当swiper改变时，触发函数
		 -->
		 
		<swiper :indicator-dots="false" :autoplay="false" class="swiper" :current="currentTab" ref="swiper" @change="changeScroll">
			<block v-for="(item,index) in scrollViewList" :key="index">
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
						<view class="swiper-item">{{item}}</view>
					</scroll-view>
				</swiper-item>
			</block>
		</swiper>
		<!-- 添加按钮，第三方插件，uniapp悬浮按钮 -->
		<view>
			<uni-fab
				horizontal="right"
				vertical="bottom"
				direction="horizontal"
				:popMenu="false"
				@fabClick="fabClick"
			/>
			</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				//定义swiper的初始值为0，也就是第一页
				currentTab: 0,
				//再定义一个数组，存放数据
				scrollViewList: ["宠物动态", "军犬风采"],
				content:["添加动态"]
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
		methods: {
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
			}
		}
	}
</script>

<style>
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
	}
</style>
