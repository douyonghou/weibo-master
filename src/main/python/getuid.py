#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
import urllib.request
from time import sleep
from urllib import parse
from bs4 import BeautifulSoup

import weibo

import ciyun_data


def getUserId(userName, pageNum):

    html_doc = "https://s.weibo.com/user/&nickname=" + parse.quote(userName) + "&page=" + pageNum
    req = urllib.request.Request(html_doc)
    webpage = urllib.request.urlopen(req)
    html = webpage.read()
    soup = BeautifulSoup(html, 'html.parser')    # 文档对象
    for a in soup.find_all('a', class_='s-btn-c'):
        if a:
            print(a["uid"])
            uid = a["uid"]
            return uid

if __name__ == "__main__":
    userName = "窦永厚"
    # userName = sys.argv[1]
    # print(userName)
    uid = getUserId(userName, "1")
    weibo.main([uid])
    # sleep(10)
    ciyun_data.main()


