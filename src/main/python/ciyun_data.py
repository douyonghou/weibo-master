# -*- coding: utf-8 -*-
import pymysql
import jieba
from wordcloud import WordCloud, ImageColorGenerator
import matplotlib.pyplot as plt
from PIL import Image

def main():

    db = pymysql.connect(host='127.0.0.1', port=3306, user='root', password='123456', db='weibo', charset='utf8')
    cursor = db.cursor()
    sql = 'select * from tb_weibo_data'
    cursor.execute(sql)
    result = cursor.fetchall()
    i = 1
    str = ""
    for res in result:
        str += res[4]
        i = i + 1
    cursor.close()
    words = jieba.lcut(str)
    counts = {}
    for word in words:
        if len(word) == 1:
            continue
        else:
            counts[word] = counts.get(word, 0) + 1
    items = list(counts.items())
    items.sort(key=lambda x: x[1], reverse=True)

    print("111111111111")

    import numpy as np

    bg=np.array(Image.open("src/main/python/yunci.png"))


    font = "src/main/python/STXINGKA.TTF"
    frequencies1 = dict(items)
    wordcloud = WordCloud(
        background_color="white",
        mask=bg,
        font_path = font,
        max_font_size=200,
        relative_scaling=.5
    ).fit_words(frequencies1)
    plt.figure()
    # plt.figure(figsize=(5.3, 2.4))
    plt.imshow(wordcloud)
    plt.axis("off")

    plt.savefig('src/main/resources/static/images/44.png', bbox_inches = 'tight')
if __name__ == '__main__':
    main()

