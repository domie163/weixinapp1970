# 数据爬取文件

import scrapy
import pymysql
import pymssql
from ..items import HonghuangpaiItem
import time
import re
import random
import platform
import json
import os
from urllib.parse import urlparse
import requests

# 红黄牌
class HonghuangpaiSpider(scrapy.Spider):
    name = 'honghuangpaiSpider'
    spiderUrl = 'https://data.thecfa.cn/cardsResult.do?lid=2022082219&year=2022'
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
            if self.table_exists(cursor, '0bb1r_honghuangpai') == 1:
                cursor.close()
                connect.close()
                self.temp_data()
                return

        data = json.loads(response.body)
        list = data
        
        for item in list:

            fields = HonghuangpaiItem()


            fields["xuhao"] = item['ranking']
            fields["xingming"] = item['playername']
            fields["qiudui"] = item['teamname']
            fields["hongpai"] = item['redCard']
            fields["huangpai"] = item['yellowCard']

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
            insert into honghuangpai(
                xuhao
                ,xingming
                ,qiudui
                ,hongpai
                ,huangpai
            )
            select
                xuhao
                ,xingming
                ,qiudui
                ,hongpai
                ,huangpai
            from 0bb1r_honghuangpai
            where(not exists (select
                xuhao
                ,xingming
                ,qiudui
                ,hongpai
                ,huangpai
            from honghuangpai where
             honghuangpai.xuhao=0bb1r_honghuangpai.xuhao
            and honghuangpai.xingming=0bb1r_honghuangpai.xingming
            and honghuangpai.qiudui=0bb1r_honghuangpai.qiudui
            and honghuangpai.hongpai=0bb1r_honghuangpai.hongpai
            and honghuangpai.huangpai=0bb1r_honghuangpai.huangpai
            ))
            limit {0}
        '''.format(random.randint(20,30))

        cursor.execute(sql)
        connect.commit()

        connect.close()
