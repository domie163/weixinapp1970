# 数据爬取文件

import scrapy
import pymysql
import pymssql
from ..items import SheshoubangItem
import time
import re
import random
import platform
import json
import os
from urllib.parse import urlparse
import requests

# 射手榜
class SheshoubangSpider(scrapy.Spider):
    name = 'sheshoubangSpider'
    spiderUrl = 'https://data.thecfa.cn/shooter.do?lid=2022082219&year=2022'
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
            if self.table_exists(cursor, '0bb1r_sheshoubang') == 1:
                cursor.close()
                connect.close()
                self.temp_data()
                return

        data = json.loads(response.body)
        list = data
        
        for item in list:

            fields = SheshoubangItem()


            fields["paiming"] = item['ranking']
            fields["qiuyuan"] = item['playername']
            fields["qiudui"] = item['teamname']
            fields["jinqiushu"] = item['goalnum']
            fields["dianqiushu"] = item['pknum']

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
            insert into sheshoubang(
                paiming
                ,qiuyuan
                ,qiudui
                ,jinqiushu
                ,dianqiushu
            )
            select
                paiming
                ,qiuyuan
                ,qiudui
                ,jinqiushu
                ,dianqiushu
            from 0bb1r_sheshoubang
            where(not exists (select
                paiming
                ,qiuyuan
                ,qiudui
                ,jinqiushu
                ,dianqiushu
            from sheshoubang where
             sheshoubang.paiming=0bb1r_sheshoubang.paiming
            and sheshoubang.qiuyuan=0bb1r_sheshoubang.qiuyuan
            and sheshoubang.qiudui=0bb1r_sheshoubang.qiudui
            and sheshoubang.jinqiushu=0bb1r_sheshoubang.jinqiushu
            and sheshoubang.dianqiushu=0bb1r_sheshoubang.dianqiushu
            ))
            limit {0}
        '''.format(random.randint(20,30))

        cursor.execute(sql)
        connect.commit()

        connect.close()
