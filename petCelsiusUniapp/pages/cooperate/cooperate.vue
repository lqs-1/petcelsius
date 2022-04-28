<template>
	<view class="content">
		<view class="content-item" v-for="(item, index) in cooperateList" :key="item.id" @click="pushDetail(item)">
			<image :src="item.logo" mode="widthFix"></image>
			<view>
				<view>机构名称:&nbsp;&nbsp;{{item.title}}</view>
				<view>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;&nbsp;{{item.address}}</view>
				<view>联系电话:&nbsp;&nbsp;{{item.contact}}</view>
			</view>
		</view>
		<!-- <view class="content-item">
			<view></view>
		</view> -->
	</view>
</template>

<script>
	export default {
		data() {
			return {
				cooperateList:[]
			};
		},
		
		onShow() {
			this.getCooperateList()
		},
		
		methods:{
			// 获取合作机构列表
			async getCooperateList(){
				let response = await uni.$http.get("cooperateApi/cooperateList")
				// console.log(response.data.cooperateList)
				this.cooperateList = response.data.cooperateList
			},
			
			// 跳转合作机构详情页面
			pushDetail(item){
				console.log(item)
				uni.navigateTo({
					// 传递对象到其他页面。首先要编码
					url:"../../subpkg/cooperate/cooperateDetial/cooperateDetial?item=" + encodeURIComponent(JSON.stringify(item))
				})
			}
		}
	}
</script>

<style lang="scss">
	page{
		background-color: #F2F3F4
	}
	.content-item{
		// 添加阴影
		box-shadow: 8rpx 10rpx 8rpx rgba($color: #999999, $alpha: 0.3);
		display: flex;
		flex-wrap: nowrap;
		background-color: #FFFFFF;
		margin: 20rpx 0;
		font-size: 20rpx;
		image{
			margin: 20rpx 20rpx;
			width: 200rpx;
		}
	
		view{
			margin: 15rpx 15rpx;
			text-align: left;
			width: 500rpx;
			height: auto;
		}
	}

</style>
