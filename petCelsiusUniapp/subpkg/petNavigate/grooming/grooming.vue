<template>
	<view>
		{{navigate.title}}
	</view>
</template>

<script>
	export default {
		data() {
			return {
				navigate:""
			};
		},
		
		onLoad(data) {
			// 获取其他页面传递过来的对象，并解码
			let navigate = JSON.parse(decodeURIComponent(data.navigate))
			this.navigate = navigate
			console.log(navigate)
		}		
		
	}
</script>

<style lang="scss">

</style>
<template>
	<view>
		{{navigate.title}}
	</view>
</template>

<script>
	export default {
		data() {
			return {
				navigate:""
			};
		},
		
		onLoad(data) {
			// 获取其他页面传递过来的对象，并解码
			let navigate = JSON.parse(decodeURIComponent(data.navigate))
			this.navigate = navigate
			console.log(navigate)
		}		
		
	}
</script>

<style lang="scss">

</style>
