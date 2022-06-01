#!/usr/bin/python3
# -*- coding: utf-8 -*-

__author__ = "Gabriel Chandesris"
__copyright__ = "CC Gabriel Chandesris (2022)"
__credits__ = ""
__licence__ = "GNU GENERAL PUBLIC LICENSE v3"
__version__ = "1.0.0a"
__maintainer__ = "Gabriel Chandesris"
__email__ = "gabywald[at]gmail.com"
__contact__ = "gabywald[at]gmail.com"
__status__ = "Development"

## When run : test with http://127.0.0.1:5000/

from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello_world():
  return "Hello World"

if __name__ == '__main__':
  app.run()

