<template>
<view class="content">
	<view :style='{"minHeight":"100vh","width":"100%","padding":"24rpx 0 0px","background":"url() fixed,#ffffff","height":"auto"}'>
		<swiper :style='{"padding":"0px 0 0px ","boxShadow":"inset 0px 0px 0px 0px #f4ead8","borderColor":"#21d5ae","outline":"0px solid #bbb","margin":"0px auto 24rpx","borderRadius":"24rpx","background":"rgba(255,255,255,1)","borderWidth":"16rpx","width":"calc(100% - 40rpx)","borderStyle":"dotted","height":"420rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
			<swiper-item :style='{"width":"calc(100% - 0px)","margin":"0 auto","position":"relative","borderRadius":"24rpx","background":"none","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"calc(100% - 40rpx)","margin":"16rpx auto","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"padding":"0 20rpx 32rpx","color":"#333","left":"20rpx","textAlign":"center","background":"rgba(255,255,255,.6)","bottom":"0px","width":"calc(100% - 40rpx)","lineHeight":"60rpx","fontSize":"28rpx","position":"absolute"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>


		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"20rpx 0 20rpx","boxShadow":"inset 0px 0px 0px 0px #87acf1","margin":"48rpx auto 60rpx","borderColor":"#21d5ae","display":"flex","outline":"0px solid #ccc","borderRadius":"24rpx","flexWrap":"wrap","background":"linear-gradient(180deg, rgba(255,255,255,.1) 0%, rgba(143,232,213,.3) 80%, rgba(27,208,169,.6) 100%)","borderWidth":"8rpx 2rpx 8rpx 2rpx","width":"calc(100% - 40rpx)","borderStyle":"dashed dashed dashed dashed","height":"auto"}'>
            <block v-for="item in menuList" v-bind:key="item.roleName">
                <block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"25%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2('../'+child.tableName+'/list')">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#333","borderRadius":"100%","background":"none","display":"block","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","height":"64rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		
		

		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		

		<!-- 新闻资讯 -->
																										<view class="listBox news">
			<view v-if="false && 1 == 1" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"padding":"0px 0","boxShadow":"0px 0px 0px rgba(0,0,0,.1)","margin":"0 auto 0px","overflow":"hidden","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20221223/5bce14e160f54b0789ffe8844f630e15.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20221223/316e41fd4a6f4d14aa0ba79790fd6d12.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20221223/794be9c86de146ba8bf596bed96d3bd7.png) repeat-x center top / auto 100%","display":"flex","width":"calc(100% - 40rpx)","lineHeight":"104rpx","justifyContent":"space-between","height":"104rpx"}'>
				<view :style='{"padding":"0 0 0 120rpx","boxShadow":"0px 0px 0px rgba(0,0,0,.2)","margin":"0px 0 0","color":"#333","textAlign":"center","display":"inline-block","minWidth":"240rpx","borderRadius":"0px","background":"url() no-repeat right top / auto 100%","width":"calc(100% - 160rpx)","fontSize":"32rpx","lineHeight":"104rpx","fontWeight":"600","height":"104rpx"}'>研讨资讯</view>
				<text :style='{"padding":"0 20rpx 0 0","margin":"0px 0px 0 0","fontSize":"28rpx","color":"#999","background":"none"}' @tap="onPageTap('news')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
					  
						
						<!-- 样式3 -->
			<view class="list-box style3" :style='{"padding":"160rpx 0px 160rpx","margin":"40rpx auto 0","borderColor":"#21d5ae","background":"url(http://codegen.caihongy.cn/20221223/869602be22f342bf8136d5a9f62af2f7.gif) no-repeat right top,url(http://codegen.caihongy.cn/20221223/a3dca8908c4c40b68f285ba0a3226a99.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/5100c3e4960949eeaacbc47dc102c484.png) no-repeat left bottom / 100% auto","borderWidth":"2rpx 0","width":"calc(100% - 0px)","borderStyle":"dashed","height":"auto"}'>
				<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"boxShadow":"0 0px 0px rgba(0,0,0,.3)","padding":"56rpx 20rpx 56rpx","margin":"0 0 20rpx","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221223/eeb1d8003bcf41b0acd7cd88f736e734.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/bc76a8b5867243299dc80d79ed1de844.png) no-repeat left bottom / 100% auto,rgba(238,238,238,.6)","display":"flex","width":"100%","height":"auto"}'>
					<image v-if="item.picture" :style='{"width":"200rpx","objectFit":"cover","borderRadius":"0px","display":"block","height":"200rpx"}' class="list-item-image" mode="aspectFill" :src="baseUrl+item.picture"></image>
					<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","height":"auto"}'>
						<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333"}' class="list-item-title">{{item.title}}</view>
						<view :style='{"padding":"0 20rpx","margin":"0","color":"#999","textAlign":"right","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' class="list-item-pirce">发布时间：{{item.addtime}}</view>
					</view>
				</view>
			</view>
						
		  <!-- 样式4 -->
		  		  
		  <!-- 样式5 -->
		  		  
		  <!-- 样式6 -->
		  		  
		  <!-- 样式7 -->
		  		  
		  <!-- 样式8 -->
		  		  
		  <!-- 样式9 -->
		  			
			<view v-if="false && 1 == 3" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
						<!-- 新闻资讯 -->
				

		<!-- 商品列表 -->
														<view class="listBox list">
			<view v-if="false && 1 == 1" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		  
			<view class="title" :style='{"padding":"0px 0","boxShadow":"0px 0px 0px rgba(0,0,0,.1)","margin":"0 auto 0px","overflow":"hidden","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20221223/5bce14e160f54b0789ffe8844f630e15.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20221223/316e41fd4a6f4d14aa0ba79790fd6d12.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20221223/794be9c86de146ba8bf596bed96d3bd7.png) repeat-x center top / auto 100%","display":"flex","width":"calc(100% - 40rpx)","lineHeight":"104rpx","justifyContent":"space-between","height":"104rpx"}'>
				<view :style='{"padding":"0 0 0 120rpx","boxShadow":"0px 0px 0px rgba(0,0,0,.2)","margin":"0px 0 0","color":"#333","textAlign":"center","display":"inline-block","minWidth":"240rpx","borderRadius":"0px","background":"url() no-repeat right top / auto 100%","width":"calc(100% - 160rpx)","fontSize":"32rpx","lineHeight":"104rpx","fontWeight":"600","height":"104rpx"}'>研讨学术</view>
				<text :style='{"padding":"0 20rpx 0 0","margin":"0px 0px 0 0","fontSize":"28rpx","color":"#999","background":"none"}' @tap="onPageTap('yantaoxueshu')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
		  		  
		  		  
		  		  <!-- 样式3 -->
		  <view v-if="3 == 3" class="list-box style3" :style='{"padding":"160rpx 0px 172rpx","boxShadow":"0 0px 0px rgba(0,0,0,.1)","margin":"40rpx auto","borderColor":"#21d5ae","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221223/869602be22f342bf8136d5a9f62af2f7.gif) no-repeat right top,url(http://codegen.caihongy.cn/20221223/a3dca8908c4c40b68f285ba0a3226a99.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/5100c3e4960949eeaacbc47dc102c484.png) no-repeat left bottom / 100% auto","borderWidth":"2rpx 0px","width":"calc(100% - 0px)","borderStyle":"dashed","height":"auto"}'>
			<view @tap="onDetailTap('yantaoxueshu',product.id)" v-for="(product,index) in homeyantaoxueshulist" :key="index" class="list-item" :style='{"border":"0px solid #83ddca","padding":"56rpx 20rpx 56rpx","boxShadow":"0 0px 0px rgba(0,0,0,.1),inset 0px 0px 0px 0px #ffef92","margin":"0 auto 40rpx","borderRadius":"0px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221223/eeb1d8003bcf41b0acd7cd88f736e734.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/bc76a8b5867243299dc80d79ed1de844.png) no-repeat left bottom / 100% auto,rgba(238,238,238,.6)","display":"flex","width":"calc(100% - 0px)","justifyContent":"space-between","height":"auto"}'>
			  			  			  			  			  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"0px","display":"block","height":"200rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
			  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"0px","display":"block","height":"200rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  <view class="list-item-body" :style='{"border":"0px dotted #f7de91","padding":"0","margin":"0","overflow":"hidden","borderRadius":"16rpx","background":"none","width":"calc(100% - 224rpx)","position":"relative","height":"192rpx"}'>
				                				<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#333","borderRadius":"16rpx","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.baogaozhuti}}</view>
								                				                				                				                				                				                				                				                				                																																																																																											  </view>
			</view>
		  </view>
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
			<view v-if="false && 1 == 3" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
																		<!-- 商品列表 -->
		
		

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				homeyantaoxueshulist: [],
				news: [],
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
        async onLoad(){
            this.role = uni.getStorageSync("role");
            let table = uni.getStorageSync("nowTable");
            let res = await this.$api.session(table);
            this.user = res.data;
            this.tableName = table;
            let menus = menu.list();
            this.menuList = menus;
            this.menuList.forEach((item,key) => {
                if(this.role==item.roleName) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
			// 轮播图
			let swiperList = []
			let res = await this.$api.page('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			// 研讨资讯
			res = await this.$api.list('news', {
				page: 1,
				limit: 6
			});
			this.news = res.data.list


			res = await this.$api.list('yantaoxueshu', {
				page: 1,

				limit: 6
			});
			this.homeyantaoxueshulist = res.data.list
		},

		methods: {

			//轮播图跳转
			onSwiperTap(e) {

			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
