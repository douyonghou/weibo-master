# -*- coding: utf-8 -*-

import pymysql
import jieba
import pandas as pd
def main():
    # 连接数据库
    db = pymysql.connect(host='127.0.0.1', port=3306, user='root', password='123456', db='weibo', charset='utf8')
    cursor = db.cursor()

    # 执行查询语句
    sql = 'select * from tb_weibo_data'
    cursor.execute(sql)
    result = cursor.fetchall()
    # 开始打印
    print("开始打印")
    i = 1
    str = ""
    for res in result:
        str += res[4]
        i = i + 1
    cursor.close()

    # 开始用jieba统计词频
    words = jieba.lcut(str)
    counts = {}
    for word in words:
        if len(word) == 1:
            continue
        else:
            counts[word] = counts.get(word, 0) + 1
    items = list(counts.items())
    items.sort(key=lambda x: x[1], reverse=True)
    df = pd.DataFrame(items, columns=['云词', '数量'])
    write = df.to_csv("../resources/data/yunci.csv", index=False)


if __name__ == '__main__':
    main()


# for i in range(100):
#     word, count = items[i]
#     print("{0:<10}{1:>5}".format(word, count))

