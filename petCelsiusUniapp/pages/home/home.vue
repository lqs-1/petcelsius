<template>
	<view>
		<!-- 轮播图区域  usw - uswiper快速生成轮播图 -->
		<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" circular="true">
			<swiper-item v-for="(item, i) in swiperBannerList" :key="item.id">
				<navigator class="swiper-item">
					<image :src="item.image"></image>
				</navigator>
			</swiper-item>
		</swiper>
		
		<!-- 导航栏 -->
		<view class="nav-list">
			<!--
			navigateBar
			 预约
			 预约记录    ------    进度查询
			 宠物专车
			 仪容整理		 
			 告别仪式
			 纪念品
			 -->
			<view class="nav-item" v-for="(item, i) in navibarList" :key="item.id" @click="navClickHandler(item)">
				<image :src="item.icon" class="nav-img"></image>
				<view class="nav-title">{{item.title}}</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				swiperBannerList: [],
				navibarList: [],
			};
		},
		onShow() {
			this.getSwiperBannerList()
			this.getNavigateList()
		},
		methods:{
			async getSwiperBannerList(){
				let response = await uni.$http.get("indexApi/indexBanner")
				// console.log(response.data.indexBannerList)
				this.swiperBannerList = response.data.indexBannerList
			},
			
			async getNavigateList(){
				let response = await uni.$http.get("indexApi/indexNavigate")
				console.log(response.data.indexNavigateList)
				this.navibarList = response.data.indexNavigateList
			}
		}
		
	}
</script>

<style lang="scss">
	// 轮播
	swiper{
		height: 340rpx;
		.swiper-item,
		image{
			width: 100%;
			height: 100%;
		}
	}
	
	// 导航栏
	.nav-list{
		// 显示到一行
		display: flex;
		flex-wrap: wrap;
		justify-content: space-around;
		margin: 60rpx 20rpx;
		.nav-item{
			margin: 30rpx;
			.nav-img{
				justify-content: center;
				width: 100rpx;
				height: 100rpx;
			}
			.nav-title{
				text-align: left;
			}
		}
	}

</style>
