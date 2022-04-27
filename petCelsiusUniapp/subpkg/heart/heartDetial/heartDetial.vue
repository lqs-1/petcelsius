<template>
	<view>
		<!-- 轮播图区域  usw - uswiper  是展示机构详情图片的 -->
		<block v-if="heartDetailImageList.length>0">
			<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" circular="true">
				<swiper-item v-for="(item, i) in heartDetailImageList" :key="item.id">
					<navigator class="swiper-item">
						<image :src="item.img"></image>
					</navigator>
				</swiper-item>
			</swiper>
		</block>
		
		<view class="desc">
			{{heartInfo.desc}}
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				heartInfo:"",
				heartDetailImageList:[]
			};
		},
		
		onLoad(data) {
			// 获取其他页面传递过来的对象，并且解码
			const item = JSON.parse(decodeURIComponent(data.item));
			// console.log(item)
			this.heartInfo = item
			console.log(this.heartInfo)
			
			// 获取详情详图片
			this.getHeartDetailImage()
		},
		
		methods:{
			// 获取详情图片
			async getHeartDetailImage(){
				let param = {
					"petId": this.heartInfo.petId
				}
				let response = await uni.$http.post("heartApi/heartDetailImage", param)
				// console.log(response.data.heartDetailImageList)
				this.heartDetailImageList = response.data.heartDetailImageList
			}
		}
	}
</script>

<style lang="scss">
	
	// 轮播
	swiper{
		height: 400rpx;
		.swiper-item,
		image{
			width: 100%;
			height: 100%;
			// border-radius: 10%;
		}
	}
	.desc{
		margin: 20rpx  20rpx;
		line-height: 100rpx;
	}

</style>
