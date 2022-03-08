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

from TicTacToe import TicTacToe
## import QuantumTicTacToe
import BasicAI

import json
from flask import Flask, request, jsonify

import os.path
import uuid

from AESCipher import AESCipher 

cipher = AESCipher( "OneHilariousKeyPassPhrase" )

app = Flask(__name__)

def createParty(  ):
  party = TicTacToe()
  party.create_board()
  return party.board

def createPartyAndWrite( name: str ):
  party = TicTacToe()
  party.create_board()
  party.write_board( name )
  return party.board

def readParty( path: str ):
  party = TicTacToe()
  party.read_board( path )
  return party
  
def writeParty( party: str, path: str ):
  party.write_board( path )
  return party

@app.route("/startagame", methods=["GET"])
def query_records():
  ## Generate a UUID for the game
  name = str(uuid.uuid4())
  board = createParty( )
  # print( str(board) )
  encoded = cipher.encrypt( str(board) )
  print( encoded )
  return json.dumps( { "party" : name, "board" : board, "encoded" : encoded } )
   

@app.route("/play", methods=["POST"])
def update_record():
  record = json.loads(request.data)
  partyID = record["party"]
  toreturn = None
  ## game => check it !
  decoded = cipher.decrypt( str(record["encoded"]) )
  print( decoded )
  print( record["board"] )
  if (decoded != str(record["board"])):
    return json.dumps({ "error" : "Invalid Board encryption !", "board": record["board"] })
  
  row = int(record["move2row"])
  col = int(record["move2col"])
  
  print( "row: ", row, "col: ", col )
  
  current_game = TicTacToe()
  current_game.board = record["board"]
  current_game.fix_spot( row-1, col-1, 'X' )
  
  ## AI part / move done by AI !
  tupleByAI = BasicAI.playOn( current_game.board )
  current_game.fix_spot( tupleByAI[0], tupleByAI[1], 'O' )
  
  print( str(current_game.board) )
  encoded = cipher.encrypt( str(current_game.board) )
  print( encoded )
  
  if (current_game.is_player_win( "X" )):
    print( "HUMAN WIN !" )
    toreturn = json.dumps({ "party" : partyID, "board" : current_game.board, "encoded" : encoded, "finished": "Human Win !" })
  elif (current_game.is_player_win( "O" )):
    print( "AI WIN !" )
    toreturn = json.dumps({ "party" : partyID, "board" : current_game.board, "encoded" : encoded, "finished": "AI Win !" })
  else:
    toreturn = json.dumps({ "party" : partyID, "board" : current_game.board, "encoded" : encoded })

  return toreturn


app.run(debug=True)

