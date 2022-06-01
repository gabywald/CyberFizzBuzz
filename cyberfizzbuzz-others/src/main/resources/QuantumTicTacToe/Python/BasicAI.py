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
The module BasicAI
"""

import random

def playOn( board: list):
  """ Defines behaviour of the AI. """
  randomRow = random.randint(0, len( board ) - 1)
  randomCol = random.randint(0, len( board[randomRow] ) - 1)
  while (board[randomRow][randomCol] != "-"):
    randomRow = random.randint(0, len( board ) - 1)
    randomCol = random.randint(0, len( board[randomRow] ) - 1)
  return (randomRow, randomCol)

class BasicAI( object ):
  """ This class defines a Basic AI for TicTacToe game. """
  def __init__(self):
    """ Constructor. """
    self.board = []
  
  def playOn( board: list):
    """ Defines behaviour of the AI. """
    randomRow = random.randint(0, len( board ) - 1)
    randomCol = random.randint(0, len( board[randomRow] ) - 1)
    while (board[randomRow][randomCol] != "-"):
      randomRow = len( board )
      randomCol = len( board[randomRow] )
    return (randomRow, randomCol)

