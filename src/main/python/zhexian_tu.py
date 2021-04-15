# -*- coding:utf-8 -*-
import matplotlib
import matplotlib.pyplot as plt

plt.figure(figsize=(6,2.7))
# 处理乱码
matplotlib.rcParams['font.sans-serif'] = ['SimHei']  # 用黑体显示中文
sql = "select substring_index(created_at, ' ', 1) as dt, count(1) as cnt from tb_weibo_data group by substring_index(created_at, ' ', 1) having dt like '%2021-03%'"

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
res = cursor.execute(sql)

location_list = []
cont_list = []
for row in cursor:
    location_list.append(row[0].split("-")[2])
    cont_list.append(row[1])


# "r" 表示红色，ms用来设置*的大小
plt.plot(location_list, cont_list, "r", label="发布时间")

# plt.plot([1, 2, 3, 4], [20, 30, 80, 40], label="b")
# plt.xticks(rotation=45)
# plt.xlabel("发布日期")
# plt.ylabel("数量")
# plt.title("时间")
# upper left 将图例a显示到左上角
# plt.legend(loc="upper left")
# 在折线图上显示具体数值, ha参数控制水平对齐方式, va控制垂直对齐方式
for x1, y1 in zip(location_list, cont_list):
    plt.text(x1, y1, str(y1), ha='center', fontsize=8, rotation=0)
plt.savefig('../resources/static/images/33.png', bbox_inches = 'tight')
# plt.show()
