<template>
	<view>
		{{heartInfo.petname}}
	</view>
</template>

<script>
	export default {
		data() {
			return {
				heartInfo:"",
			};
		},
		
		onLoad(data) {
			// 获取其他页面传递过来的对象，并且解码
			const item = JSON.parse(decodeURIComponent(data.item));
			// console.log(item)
			this.heartInfo = item
			
			// 获取详情详情和图片
		}
	}
</script>

<style lang="scss">

</style>
