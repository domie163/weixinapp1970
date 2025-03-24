# 数据爬取文件

import scrapy
import pymysql
import pymssql
from ..items import SaichengItem
import time
import re
import random
import platform
import json
import os
from urllib.parse import urlparse
import requests

# 赛程
class SaichengSpider(scrapy.Spider):
    name = 'saichengSpider'
    spiderUrl = 'https://rest.thecfa.cn/game-plan/get-plan-result?lid=2022082219&round=0&year=2022'
    start_urls = spiderUrl.split(";")
    protocol = ''
    hostname = ''

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)


    # 列表解析
    def parse(self, response):
        
        _url = urlparse(self.spiderUrl)
        self.protocol = _url.scheme
        self.hostname = _url.netloc
        plat = platform.system().lower()
        if plat == 'windows_bak':
            pass
        elif plat == 'linux' or plat == 'windows':
            connect = self.db_connect()
            cursor = connect.cursor()
            if self.table_exists(cursor, '0bb1r_saicheng') == 1:
                cursor.close()
                connect.close()
                self.temp_data()
                return

        data = json.loads(response.body)
        list = data
        
        for item in list:

            fields = SaichengItem()


            fields["bisaishijian"] = item['gametime']
            fields["lunci"] = item['gamesession']
            fields["zhudui"] = item['hostteamname']
            fields["bifen"] = item['score']
            fields["kedui"] = item['clientteamname']

            yield fields

    # 详情解析
    def detail_parse(self, response):
        fields = response.meta['fields']



        return fields

    # 去除多余html标签
    def remove_html(self, html):
        if html == None:
            return ''
        pattern = re.compile(r'<[^>]+>', re.S)
        return pattern.sub('', html).strip()

    # 数据库连接
    def db_connect(self):
        type = self.settings.get('TYPE', 'mysql')
        host = self.settings.get('HOST', 'localhost')
        port = int(self.settings.get('PORT', 3306))
        user = self.settings.get('USER', 'root')
        password = self.settings.get('PASSWORD', '123456')

        try:
            database = self.databaseName
        except:
            database = self.settings.get('DATABASE', '')

        if type == 'mysql':
            connect = pymysql.connect(host=host, port=port, db=database, user=user, passwd=password, charset='utf8')
        else:
            connect = pymssql.connect(host=host, user=user, password=password, database=database)

        return connect

    # 断表是否存在
    def table_exists(self, cursor, table_name):
        cursor.execute("show tables;")
        tables = [cursor.fetchall()]
        table_list = re.findall('(\'.*?\')',str(tables))
        table_list = [re.sub("'",'',each) for each in table_list]

        if table_name in table_list:
            return 1
        else:
            return 0

    # 数据缓存源
    def temp_data(self):

        connect = self.db_connect()
        cursor = connect.cursor()
        sql = '''
            insert into saicheng(
                bisaishijian
                ,lunci
                ,zhudui
                ,bifen
                ,kedui
            )
            select
                bisaishijian
                ,lunci
                ,zhudui
                ,bifen
                ,kedui
            from 0bb1r_saicheng
            where(not exists (select
                bisaishijian
                ,lunci
                ,zhudui
                ,bifen
                ,kedui
            from saicheng where
             saicheng.bisaishijian=0bb1r_saicheng.bisaishijian
            and saicheng.lunci=0bb1r_saicheng.lunci
            and saicheng.zhudui=0bb1r_saicheng.zhudui
            and saicheng.bifen=0bb1r_saicheng.bifen
            and saicheng.kedui=0bb1r_saicheng.kedui
            ))
            limit {0}
        '''.format(random.randint(20,30))

        cursor.execute(sql)
        connect.commit()

        connect.close()
