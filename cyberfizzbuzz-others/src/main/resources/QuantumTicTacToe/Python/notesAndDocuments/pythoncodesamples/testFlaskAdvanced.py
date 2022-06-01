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

## Base exampletaken from https://pythonbasics.org/flask-rest-api/

import json
from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route("/", methods=["GET"])
def query_records():
  name = request.args.get("name")
  print(name)
  with open("tmp/data.txt", "r") as f:
    data = f.read()
    records = json.loads(data)
    for record in records:
      print( record )
      if (record["name"] == name):
        return jsonify(record)
      return jsonify({"error": "data not found"})


@app.route("/", methods=["PUT"])
def create_record():
  record = json.loads(request.data)
  print(record)
  with open("tmp/data.txt", "r") as f:
    data = f.read()
    if not data:
      records = [record]
    else:
      records = json.loads(data)
      records.append(record)
    with open("tmp/data.txt", "w") as f:
      f.write(json.dumps(records, indent=2))
    return jsonify(record)


@app.route("/", methods=["POST"])
def update_record():
  record = json.loads(request.data)
  print(record) 
  new_records = []
  with open("tmp/data.txt", "r") as f:
    data = f.read()
    records = json.loads(data)
  for r in records:
    if (r["name"] == record["name"]):
      r["email"] = record["email"]
    new_records.append(r)
  with open("tmp/data.txt", "w") as f:
    f.write(json.dumps(new_records, indent=2))
  return jsonify(record)


@app.route("/", methods=["DELETE"])
def delte_record():
  record = json.loads(request.data)
  new_records = []
  with open("tmp/data.txt", "r") as f:
    data = f.read()
    records = json.loads(data)
    for r in records:
      if r["name"] == record["name"]:
        continue
      new_records.append(r)
    with open("tmp/data.txt", "w") as f:
      f.write(json.dumps(new_records, indent=2))
    return jsonify(record)

app.run(debug=True)

