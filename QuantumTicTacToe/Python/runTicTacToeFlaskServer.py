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

app = Flask(__name__)

def createParty( name ):
  party = TicTacToe()
  party.create_board()
  party.write_board( name )
  return party.board

def readParty( path ):
  party = TicTacToe()
  party.read_board( path )
  return party
  
def writeParty( party, path ):
  party.write_board( path )
  return party

@app.route("/startagame", methods=["GET"])
def query_records():
  if ('name' in request.args):
    ## a name is given for the game
    name = request.args.get("name")
    print(name)
    path_to_file = "tmp/" + name
    if (os.path.exists(path_to_file)):
      toreturn = None
      return json.dumps({ "party" : name, "error" : "Game with this name already exists !" })
    else:
      print( "create Game with name '", name, "'" )
      createParty( path_to_file )
      current_game = readParty( path_to_file )
      return json.dumps({ "party" : name, "board" : current_game.board }) ## jsonify(toreturn) ## "{" + toreturn + " : " + board + "}"
  else:
    ## Generate a UUID for the game
    name = str(uuid.uuid4())
    path_to_file = "tmp/" + name
    board = createParty( path_to_file )
    current_game = readParty( path_to_file )
    return json.dumps({ "party" : name, "board" : current_game.board }) ## jsonify(toreturn) ## "{" + toreturn + " : " + board + "}"
     




@app.route("/play", methods=["POST"])
def update_record():
  record = json.loads(request.data)
  ## print( record )
  ## print( record["party"] )
  partyID = record["party"]
  path2file = "tmp/" + partyID
  toreturn = None
  if (os.path.exists( path2file )):
    ## game exists => read it !
    current_game = readParty( path2file )
    
    row = int(record["move2row"])
    col = int(record["move2col"])
    
    print( "row: ", row, "col: ", col )
    
    current_game.fix_spot( row-1, col-1, 'X' )
    
    ## AI part / move done by AI !
    tupleByAI = BasicAI.playOn( current_game.board )
    current_game.fix_spot( tupleByAI[0], tupleByAI[1], 'O' )
    
    ## record the game !
    writeParty( current_game, path2file )
    
    ## toreturn = json.dumps({ "party" : partyID, "board" : current_game.board })
    
    if (current_game.is_player_win( "X" )):
      print( "HUMAN WIN !" )
      toreturn = json.dumps({ "party" : partyID, "board" : current_game.board, "finished": "Human Win !" })
    elif (current_game.is_player_win( "O" )):
      print( "AI WIN !" )
      toreturn = json.dumps({ "party" : partyID, "board" : current_game.board, "finished": "AI Win !" })
    else:
      toreturn = json.dumps({ "party" : partyID, "board" : current_game.board })
    
  else:
    ## return jsonify("Game does not exists !")
    toreturn = json.dumps({ "party" : partyID, "error" : "Game does not exists !" })
  return toreturn


app.run(debug=True)

