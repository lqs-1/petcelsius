import App from './App'

import axios from 'axios'
axios.defaults.withCredentials = true




uni.setStorageSync("user", "")
// 导入网络请求的包
// npm install @escook/request-miniprogram ,前提是安装了node
import {$http} from "@escook/request-miniprogram"
// 挂载到uni
uni.$http = $http
// 设置根路径
$http.baseUrl = 'http://localhost:10001/'
// 封装请求的提示消息到uni，不传就是默认失败
uni.$showMsg = function(title = "数据请求失败", duration = 1500){
	uni.showToast({
		title,
		duration,
		icon:'none'
	})
}

// 一个请求拦截器
$http.beforeRequest = function(options){
	uni.showLoading({
		title:"数据加载中"
	})
}
// 一个响应拦截器
$http.afterRequest = function(){
	uni.hideLoading()
}







// #ifndef VUE3
import Vue from 'vue'
Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
    ...App
})
app.$mount()
// #endif



// #ifdef VUE3
import { createSSRApp } from 'vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app
  }
}
// #endif