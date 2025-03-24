# 数据容器文件

import scrapy

class SpiderItem(scrapy.Item):
    pass

class SaichengItem(scrapy.Item):
    # 比赛时间
    bisaishijian = scrapy.Field()
    # 轮次
    lunci = scrapy.Field()
    # 主队
    zhudui = scrapy.Field()
    # 比分
    bifen = scrapy.Field()
    # 客队
    kedui = scrapy.Field()

class HonghuangpaiItem(scrapy.Item):
    # 序号
    xuhao = scrapy.Field()
    # 姓名
    xingming = scrapy.Field()
    # 球队
    qiudui = scrapy.Field()
    # 红牌
    hongpai = scrapy.Field()
    # 黄牌
    huangpai = scrapy.Field()

class SheshoubangItem(scrapy.Item):
    # 排名
    paiming = scrapy.Field()
    # 球员
    qiuyuan = scrapy.Field()
    # 球队
    qiudui = scrapy.Field()
    # 进球数
    jinqiushu = scrapy.Field()
    # 点球数
    dianqiushu = scrapy.Field()

