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
		
		
		<!-- 楼层 -->
		<view class="floor-list">
			<!-- 每一个楼层的item -->
			<view class="floor-item" v-for="(item, i) in flootList" :key="item.id">
				<!-- 每一个楼层的标题 -->
				<image :src="item.title_img" class="floor-title"></image>
				<!-- 每一个楼层的图片 -->
				<view class="floor-img-box">
					<!-- 楼层大图 -->
					<view class="left-img-box">
						<image :src="item.floor_index_img" class="floor_index_img" mode="widthFix"></image>
					</view>
					<!-- 楼层小图 -->
					<view class="right-img-box">
						<view class="right-img-item" v-for="(item2, i2) in item.indexFloorImgList" :key="item2.id">
							<image  :src="item2.floor_img" class="floor_img" mode="widthFix"></image>
						</view>
						
					</view>
				</view>
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
				flootList: [],
			};
		},
		onShow() {
			this.getSwiperBannerList()
			this.getNavigateList()
			this.getFloorList()
		},
		
		onPullDownRefresh() {
			this.getSwiperBannerList()
			this.getNavigateList()
			this.getFloorList()
		},
		methods:{
			// 获取首页banner列表
			async getSwiperBannerList(){
				let response = await uni.$http.get("indexApi/indexBanner")
				// console.log(response.data.indexBannerList)
				this.swiperBannerList = response.data.indexBannerList
			},
			// 获取首页navigate列表
			async getNavigateList(){
				let response = await uni.$http.get("indexApi/indexNavigate")
				// console.log(response.data.indexNavigateList)
				this.navibarList = response.data.indexNavigateList
			},
			// 获取首页floor列表
			async getFloorList(){
				let response = await uni.$http.get("indexApi/indexFloor")
				// console.log(response.data.indexFloorList)
				this.flootList = response.data.indexFloorList
			},
			
			
			
			
			// 封装页面跳转函数
			navigateTo(url){
				uni.navigateTo({
					url:url
				})
			},
			// navigate点击跳转
			navClickHandler(item){
				// 给其他页面传递对象，并且编码传递
				if (item.title == "现在预约"){
					this.navigateTo("../../subpkg/book/booking/booking?navigate=" + encodeURIComponent(JSON.stringify(item)))
				}else if (item.title == "预约记录"){
					this.navigateTo("../../subpkg/book/bookingRecord/bookingRecord?navigate=" + encodeURIComponent(JSON.stringify(item)))
				}else if(item.title == "宠物专车"){
					this.navigateTo("../../subpkg/petNavigate/petCar/petCar?navigate=" + encodeURIComponent(JSON.stringify(item)))
				}else if(item.title == "仪容整理"){
					this.navigateTo("../../subpkg/petNavigate/grooming/grooming?navigate=" + encodeURIComponent(JSON.stringify(item)))
				}else if(item.title == "告别仪式"){
					this.navigateTo("../../subpkg/petNavigate/farewell/farewell?navigate=" + encodeURIComponent(JSON.stringify(item)))
				}else{
					this.navigateTo("../../subpkg/petNavigate/souvenir/souvenir?navigate=" + encodeURIComponent(JSON.stringify(item)))
				}
				
			}
		}
		
	}
</script>

<style lang="scss">
	// 背景颜色
	page{
		// background-color: #ccffff
		background-color: #F2F3F4;
	}
	
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
		margin: 30rpx 20rpx;
		// background-color: #ffffcc;
		.nav-item{
			margin: 30rpx;
			text-align: center;
			.nav-img{
				justify-content: center;
				width: 100rpx;
				height: 100rpx;
			}
			.nav-title{
				text-align: center;
				color: #333;
				font-size: 30rpx;
			}
		}
	}
	
	// 楼层
	// 楼层
	.floor-title{
		margin: 15rpx 0;
		width: 100%;
		height: 60rpx;
	}
	
	.floor_index_img{
		width: 232rpx;
	}
	
	.right-img-box{
		display: flex;
		flex-wrap: wrap;
		justify-content: space-around;
		.floor_img{
			width: 233rpx;
		}
	}
	.floor-img-box{
		display: flex;
		
	}

</style>
