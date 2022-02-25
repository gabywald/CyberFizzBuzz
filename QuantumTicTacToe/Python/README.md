# Project "Quantic Tic-Tac-Toe" in Python

**NOTE : this is WIP (Work In Progress) !**

Some notes about this implementation !
   * This file README.md
   * Directory "notesAndDocuments" to regroup some specific notes about the game in construction
     * Some Flask Tests (for the moment)
     * Python Flask Postman collection
     * ... 
   * Python Files for this project
     * BasicAI.py (module)
     * PlayerHelper.py (module)
     * QuantumTicTacToe.py (module)
     * runPlayerOnTicTacToeServer.py (script, server-side)
     * runTicTacToeFlaskServer.py (script, client-side)
     * TicTacToe.py (module)

## Dev Context

  * Ubuntu 20.04
  * Python 3.8.10

Some Tests done with Postman

## How-To-Play

  * Script "runTicTacToeFlaskServer.py" to start the server (with REST API) ; 
  * Script "runPlayerOnTicTacToeServer.py" to play interactively. 
  
In Unix / Linux System : set the executable flag for the two (2) scripts above, then run server, then run the player script. 

When prompted for a position ("Enter row and column numbers to fix spot (row, col): ") indicates row and column values separated by a space (for example '1 1') then enter. 

Human Player is 'X', and AI is "O". 

## Developments Notes

**What is To Do / Planification / Done**

Tasks to be done : 
  * REST interfaces
    * Starting a game ; 
    * Playing OR getting result. 
   * Simple Tic-Tac-Toe implementation
    * Run / Start a game (generate ID or choice by the user)
    * Send input by user (and turn by AI). 
    * Interactive Script to request API !
  * Minimalist AI (random pic in vacant cell)
  * Link between REST and Tic-Tac-Toe
    * Create a game Board
    * Load game Board
    * Change game Board
    * Record game Board
    * Interactive Script for player
    * ...
  * Change to "Quantum Tic-Tac-Toe" ( **TODO** )
    * Specific input to make the "quantum effect" (?) ; 
    * ... 
  * Other tasks ( **TODO** )
    * Check input values by user (only between 1 and number of rows / cols) ; 
    * Better authentication ?! (login and password of user ?) ; 
    * Automatic removal of ended games (or too old) ; 
    * Other interaction for exit game (?) ; 
    * ... 

*Remember the movie 'WarGames' : "A game where the best way to win is not to play !" (not the Tic-Tac-Toe !)*

### "Getting better" some points

  * TO BE stateless :
    * Board and hash (private key and salt to generate only on server-side)
    * T of board + hash on each transaction
    * no record on server-side

  * stateful : 
    * BDD record if needed ; 
    * Memory Python ; 
    * Scalability in that case ?!
    
  * Quantum Part : 
    * Graph representation
    * Check if any library of that king already exists for that
    
  * externalisation / sharing of 'null value' if board (actually used is '-')

  * Unit Tests !
  * Check code with Python IDE
  * pipy (et transfert vers typage plus fort)

## External resources

### Starting existing ideas of Tic-Tac-Toe

  * https://geekflare.com/tic-tac-toe-python-code/
  * https://www.askpython.com/python/examples/tic-tac-toe-using-python
  * https://iqcode.com/code/python/tic-tac-toe-python

### About Python Flask

  * https://pythonbasics.org/flask-rest-api/
  * https://www.tutorialspoint.com/flask/index.htm
  * https://www.tutorialspoint.com/flask/flask_quick_guide.htm

### Web Services in Python

  * https://docs.python-requests.org/en/latest/user/quickstart/#make-a-request
  * https://bogotobogo.com/python/python_http_web_services.php
  * ...


