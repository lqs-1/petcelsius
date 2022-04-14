<template>
	<view>
		马上预定
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			};
		},
		
				onLoad() {
					let res = uni.getSystemInfoSync()
					this.windowHeight = res.windowHeight
				},
				onReady() {
					this.context = uni.createLivePusherContext('livePusher', this)
					this.startPreview()
				},
				methods: {
					// 开启预览
					startPreview(){
						this.context.startPreview({
							success:(e)=>{
								console.log(e);
							}
						})
					},
					}
	}
</script>

<style lang="scss">

</style>
