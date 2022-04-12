<template>
	<view class="userInfo">	
		<view class="topicAdd">
			<text style="font-size: 30rpx;">头像:</text>
			<uni-file-picker
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
			<text style="font-size: 30rpx;">用户名:</text><input type="text"  v-model="user.username" style="background-color: #8F939C;"/>
		</view>
		<view>
			<button type="primary" style="height: 80rpx; width: 200rpx; text-align: center; top: 30rpx;" @click="commit">提交</button>
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
			console.log(this.user)
			
			
		}
		,
		
		methods:{
			// 获取上传状态
			async select(res){
				console.log('选择文件：',res.tempFilePaths)
				 await this.uploadImg(res.tempFilePaths,1);
			},
			
			async uploadImg(tempFilePaths, token) {
			    console.log(token)
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
			    console.log(response)
			   
				if (response[1].statusCode !== 200){
					uni.$showMsg("上传头像失败")
				}
				uni.$showMsg("上传头像成功")
				// console.log(response[1].data)
				this.imageUrl = response[1].data
				console.log("imageUrl:", this.imageUrl)
				
			},
			
			async commit(){
				if (this.imageUrl !== ""){
					this.user.topic = this.imageUrl
				}
				let response = await uni.$http.post("userApi/alterUserInfo", this.user)
				
				console.log(response)
				
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
	
	.name .topicAdd{
		display: flex;	
		// justify-content: center;
	}
	
	
	.userInfo{
		text-align: center;
		left: 0;
		right: 0;
		position: fixed;
		top: 500rpx;
		font-weight: 400;
	}
	
	.example-body {
		padding: 10px;
		padding-top: 0;
	}

	.custom-image-box {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
	}

	.text {
		font-size: 14px;
		color: #333;
	}
	// .topicAdd{
	// 	text-align: center;
	// 	left: 0;
	// 	right: 0;
	// 	position: fixed;
	// 	top: 500rpx;
	// 	font-weight: 400;
	// }
</style>