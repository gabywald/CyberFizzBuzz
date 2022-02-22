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

import requests
import json
import PlayerHelper

## Get a game created !
print( "STARTING GAME" )
rCreateGame = requests.get("http://127.0.0.1:5000/startagame")

data = json.loads(rCreateGame.text) ## Convert it to a Python dictionary

print( "Game UUID: ", data["party"], "\n" )

## starting_board = PlayerHelper.convertBoard( [['-', '-', '-'], ['-', '-', '-'], ['-', '-', '-']] )

rPlayGame = PlayerHelper.playerTurn( rCreateGame )

## LOOP interaction with user !
while( ("error" not in rPlayGame.json()) and ("finished" not in rPlayGame.json()) ):
  rPlayGame = PlayerHelper.playerTurn( rPlayGame )

## Detect why game has end !
if ("error" in rPlayGame.json()):
  print( "ERROR: ", rPlayGame.json()["error"])

if ("finished" in rPlayGame.json()):
  print( "End Of Game: ", rPlayGame.json()["finished"])

## ... 



