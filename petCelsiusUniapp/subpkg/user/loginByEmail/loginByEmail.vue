<template>
    <view class="login">
        <view class="top_item">
            <text style="color: #000000;font-size: 22px;font-weight: bold;">登录</text>
        </view>
        <view class="input-item" style="margin-top: 80rpx;">
            <view class="title-content">
                <text class="title">账号</text>
            </view>
            <input v-model="email" class="input" placeholder="邮箱地址" style="margin-left: 40rpx;" />
        </view>
        <view class="input-item">
            <view class="title-content"	>
                <text class="title">验证码</text>
            </view>
            <input v-model="emailCode" class="input" placeholder="请输入邮箱验证码" style="margin-left: 40rpx;" />
			<view class="get" @tap="getCheckNum()">
			 <text>{{!codeTime?'获取验证码':codeTime+'s'}}</text>
			 </view>

        </view>
        <view class="button" @click="login">登录</view>
    </view>
</template>

<script>
    export default {
        data() {
            return {
                title: 'Hello',
				codeTime :0,
				email: "",
				emailCode: "",
            }
        },
        onLoad() {

        },
        methods: {
			
			// 完成登录信息， 这个时候，不能用session和cookie所以用uniapp自带的存储功能
            async login() {		
				// 请求登录，返回登录后的用户信息
			   let response = await uni.$http.post('userApi/emailLogin', {"email": this.email, "emailCode": this.emailCode})
			   
			   console.log(response)
			   // 登录成功就存储登录信息
			   if (response.data.code == 0){
				   uni.setStorageSync("user", response.data.user)
				   uni.$showMsg("登录成功")
				   uni.navigateBack({
					delta:1
				   })
			   }
			   // 登录失败
			   if(response.data.code != 0){
				   uni.$showMsg("登录失败,请检测手机号和验证码")
			   }
			   
            },
			
			// 获取验证码
		   async getCheckNum(){
			   await uni.$http.get('userApi/getEmailCode/' + this.email)
			   uni.$showMsg("验证码发送成功")
				if(this.codeTime>0){
					 
					  uni.showToast({
					  title: '不能重复获取',
					  icon:"none"
				  });
					return;
				 }else{
					  this.codeTime = 60
					  let timer = setInterval(()=>{
						  this.codeTime--;
						  if(this.codeTime<1){
						  clearInterval(timer);
						  this.codeTime = 0
						  }
					  },1000)
					}
		   }
			 
    }
	}
</script>

<style>
   .top_item {
        display: flex;
        margin-top: 40rpx;
        margin-left: 32rpx;
        margin-right: 32rpx;
        justify-content: space-between;
    }

   .input-item {
        display: flex;
        margin-left: 32rpx;
        margin-right: 32rpx;
        height: 50px;
        align-items: center;
        border-bottom: 1px solid #efeff4;
        margin-bottom: 20rpx;
       
    }

    .button {
        height: 50px;
        line-height: 50px;
        margin-top: 60rpx;
        margin-left: 32rpx;
        margin-right: 32rpx;
        border-radius: 50rpx;
        font-size: 20px;
        background-color: #008AFE;
        color: #FFFFFF;
        text-align: center;
    }
	
	.get{
	 /* position: ; */
	 top: 40rpx;
	 right: 30rpx;
	 background-color: orange;
	 height: 70rpx;
	 line-height: 70rpx;
	 color: white;
	 border-radius: 10rpx;
	 padding: 0 20rpx;
	}
</style>
