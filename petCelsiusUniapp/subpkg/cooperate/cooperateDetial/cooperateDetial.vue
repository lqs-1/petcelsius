<template>
	<view>
		<!-- 轮播图区域  usw - uswiper  是展示机构详情图片的 -->
		<block v-if="cooperateDescImgList.length>0">
			<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" circular="true">
				<swiper-item v-for="(item, i) in cooperateDescImgList" :key="item.id">
					<navigator class="swiper-item">
						<image :src="item.desc_img"></image>
					</navigator>
				</swiper-item>
			</swiper>
		</block>
		
		
		<view class="desc">
			{{cooperateDesc}}
		</view>
	</view>
</template>

<script>
	export default {
		// props:["cooperateId", "cooperateDesc", "cooperateTitle"],
		data() {
			return {
				cooperateDescImgList:[],
				cooperateId:"",
				cooperateDesc:"",
				cooperateTitle:"",
			};
		},
		
		onLoad(data) {
			// 获取到其他页面传递过来的数据,解码对象
			let item = JSON.parse(decodeURIComponent(data.item))
			this.cooperateId = item.id
			this.cooperateDesc = item.desc
			this.cooperateTitle = item.title
			// 获取详情图片
			this.getCooperateDescImgList()
		},
		
		
		methods:{
			// 根据cooperateId获取性情图片
			async getCooperateDescImgList(){
				// console.log(this.cooperateId)
				let data = {"cooperateId": this.cooperateId}
				
				let response = await uni.$http.post("/cooperateApi/cooperateDescImgList", data)
				
				// console.log(response)
				this.cooperateDescImgList = response.data.cooperateDescImgList
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
	.desc{
		margin: 20rpx  20rpx;
		line-height: 100rpx;
	}

</style>
