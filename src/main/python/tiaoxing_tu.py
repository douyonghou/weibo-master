#-*-coding:utf-8-*-
import matplotlib.pyplot as plt
plt.figure(figsize=(6,2.7))
from matplotlib.font_manager import FontProperties
from pylab import *
import pymysql
mysql_config = {
    'host': 'localhost',
    'port': 3306,
    'user': 'root',
    'password': '123456',
    'charset': 'utf8mb4',
    'db': 'weibo'
}
connection = pymysql.connect(**mysql_config)
cursor = connection.cursor()
res = cursor.execute("select substring_index(location, ' ', 1), count(0) from tb_weibo_user group by substring_index(location, ' ', 1)")
location_list = []
cont_list = []
for row in cursor:
    location_list.append(row[0])
    cont_list.append(row[1])
mpl.rcParams['font.sans-serif'] = ['SimHei']
# font = FontProperties(fname=r"D:\other-download\chrome\weibo-crawler-master\test\simhei.ttf",size = 6)
plt.bar(location_list,cont_list,label='用户数量')
plt.legend()
# plt.xlabel('地区')
# plt.ylabel('数目')
# plt.title(u'微博用户地区分布',FontProperties=font)
# plt.show()
plt.savefig('../resources/static/images/11.png', bbox_inches = 'tight')
