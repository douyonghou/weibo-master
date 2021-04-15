# -*- coding:utf-8 -*-
import matplotlib
import matplotlib.pyplot as plt

# plt.figure()
# 处理乱码
sql = "select replace(replace(gender, 'f', '女'), 'm', '男') as sex, count(1) from tb_weibo_user group by sex"

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
sum = 0
for row in cursor:
    location_list.append(row[0])
    cont_list.append(row[1])
    print(row[0], row[1])
    sum = sum + row[1]

print(sum)
new_lit = []
for k in cont_list:
    print (k / sum)
    new_lit.append(k / sum)


plt.rcParams['font.sans-serif'] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False


fig = plt.figure(figsize=(5,2.5))
ax = fig.add_axes([0,0,1,1])
ax.axis('equal')

# langs = ['C', 'C++', 'Java', 'Python', 'PHP']
# new_lit = [23,17,35,29,12]
ax.pie(new_lit, labels = location_list,autopct='%1.2f%%')
plt.savefig('../resources/static/images/22.png', bbox_inches = 'tight')
