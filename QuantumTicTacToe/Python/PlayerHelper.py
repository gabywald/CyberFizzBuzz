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

"""
The module PlayerHelper
"""

import requests
import json

## |--------|--------|--------|
## |        |        |        |
## |--------|--------|--------|
## |        |        |        |
## |--------|--------|--------|
## |        |        |        |
## |--------|--------|--------|

def convertBoard( game_board ):
  """ To convert the receive board to human visualization. """
  linesep	= "|--------|--------|--------|"
  startline	= "|    "
  endline	= "   " ## |
  toreturn	= "" ## linesep
  for elts in game_board:
    toreturn	+= linesep + "\n"
    for elt in elts:
      toreturn += startline
      if (elt == "-"):
        toreturn += " "
      else:
        toreturn += elt
      toreturn += endline
    toreturn += "|\n"
  toreturn	+= linesep
  return toreturn

def playerTurn(rPlayGame: requests):
  """ When Player indicates a new move. """
  print(f"Human Player turn")
  print( convertBoard(rPlayGame.json()["board"]) )
    
  ## Taking user input
  row, col = list( map(int, input("Enter row and column numbers to fix spot (row, col): ").split()) )
  
  ## Send the player move
  body2send = json.dumps({ "party" : rPlayGame.json()["party"], "move2row" : row, "move2col" : col  })
  ## print( body2send )
  rPlayGame = requests.post("http://127.0.0.1:5000/play", data = body2send)
  
  if ("error" in rPlayGame.json()):
    return rPlayGame.json()
  
  print( convertBoard( rPlayGame.json()["board"] ) )
  return rPlayGame

