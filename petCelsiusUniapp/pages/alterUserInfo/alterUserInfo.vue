<template>
	<view class="userInfo">	
		<view class="topicAdd">
			<view class="topic_title">头像:</view>
			<uni-file-picker
				class="topic"
				:v-model="imageValue" 
				fileMediatype="image" 
				mode="list" 
				auto-upload="true"
				@select="select" 
				@success="success" 
				@fail="fail" 
			/>
		</view>
		<view class="name">
			<text class="username">用户名:</text><input type="text"  v-model="user.username" class="userInput"/>
		</view>
		<view>
			<button type="primary" class="submit" @click="commit">提交</button>
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				imageValue:[],
				imageUrl:"",
				user:''
			}
		},
		
		onShow() {
			this.imageValue = []
			
			this.user = uni.getStorageSync("user")
			this.user.topic = null
			// console.log(this.user)
			
			
		}
		,
		
		methods:{
			// 获取上传状态
			async select(res){
				 await this.uploadImg(res.tempFilePaths,1);
			},
			
			async uploadImg(tempFilePaths, token) {
			    // console.log(token)
			    if (!tempFilePaths.length) return;
			    const path = tempFilePaths.pop();
			    const response = await uni.uploadFile({
			        url: 'http://localhost:10001/userApi/topicUpload',
			        filePath: path,
			        name: 'topic',
			        header: {
			            Authorization: token,
			            "Content-Type": "multipart/form-data",
			        }
			    });
			    // console.log(response)
			   
				if (response[1].statusCode !== 200){
					uni.$showMsg("上传头像失败")
				}
				uni.$showMsg("上传头像成功")
				// console.log(response[1].data)
				this.imageUrl = response[1].data
				// console.log("imageUrl:", this.imageUrl)
				
			},
			
			async commit(){
				if (this.imageUrl !== ""){
					this.user.topic = this.imageUrl
				}
				let response = await uni.$http.post("userApi/alterUserInfo", this.user)
				
				// console.log(response)
				
				if (response.data.code !== 0){
					uni.$showMsg("修改失败")
				}
				
				uni.$showMsg("修改成功")
				uni.setStorageSync("user", response.data.user)			
				uni.navigateBack({
					delta:1
				})
				
			}
		}
	}
</script>

<style lang="scss">
	
	page{
		background-color: #F2F3F4
	}
	
	.userInfo{
		.topicAdd{
			display: flex;
			flex-wrap: nowrap;
			background-color: #FFFFFF;
			margin: 20rpx 0;
			width: 100%;
			height: auto;
			
			.topic_title{
				margin-top: 20rpx;
				width: 120rpx;
				height: auto;
				align-content: center;
			}
			.topic{
				margin-top: 20rpx;
			}
		}
		
		.name{
			display: flex;
			flex-wrap: nowrap;
			background-color: #FFFFFF;
			margin: 20rpx 0;
			width: 100%;
			height: 80rpx;
			
			.username{
				margin-top: 20rpx;
				width: 120rpx;
				height: auto;
				align-content: center;
			}
			.userInput{
				margin-top: 20rpx;
			}
		}
	}
	
	// height: 80rpx; width: 200rpx; text-align: center; top: 30rpx;
	.submit{
		height: 80rpx;
		width: 200rpx;
		text-align: center;
		top: 500rpx;
	}
</style>