#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib.request
from urllib import parse
from bs4 import BeautifulSoup

from src.test import weibo


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
    # userName = sys.argv[0]
    uid = getUserId(userName, "1")
    weibo.main([uid])


