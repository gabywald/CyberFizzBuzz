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
The module TicTacToe
"""

class TicTacToe ( object ):
  """ This class defines TicTacToe game. """
  def __init__(self):
    """ Constructor. """
    self.board = []
    
  def __str__(self) : 
    """TicTacToe to str. """
    str = "TicTacToe() \n" 
    str += "\t board: %s \n" % (self.board)
    return str
  
  def create_board(self):
    """ Create an empty board. """
    for i in range(3):
      row = []
      for j in range(3):
        row.append('-')
      self.board.append(row)
  
  def read_board(self, path):
    """ Read a board from file indicated by path. """
    with open(path, "r") as file:
      data = file.read()
      ## self.board = data
      ## self.create_board()
      for elts in data.split('\n'):
        row = []
        if (elts != ""):
          for elt in elts:
            row.append(elt)
          self.board.append(row)
  
  def write_board(self, path):
    """ Write a board to file indicated by path. """
    with open(path, "w") as file:
      for item in self.board:
        for elt in item:
          file.writelines( elt )
        file.writelines( "\n" )

  def get_random_first_player(self):
    return random.randint(0, 1)

  def fix_spot(self, row, col, player):
    self.board[row][col] = player

  def is_player_win(self, player):
    win = None

    n = len(self.board)

    ## Checking rows
    for i in range(n):
      win = True
      for j in range(n):
        if self.board[i][j] != player:
          win = False
          break
      if win:
        return win

    ## Checking columns
    for i in range(n):
      win = True
      for j in range(n):
        if self.board[j][i] != player:
          win = False
          break
      if win:
        return win

    ## Checking diagonals
    win = True
    for i in range(n):
      if self.board[i][i] != player:
        win = False
        break
    if win:
      return win

    win = True
    for i in range(n):
      if self.board[i][n - 1 - i] != player:
        win = False
        break
    if win:
      return win
    return False

    for row in self.board:
      for item in row:
        if item == '-':
          return False
    return True

  def is_board_filled(self):
    for row in self.board:
      for item in row:
        if item == '-':
          return False
    return True

  def swap_player_turn(self, player):
    return 'X' if player == 'O' else 'O'

  def show_board(self):
    for row in self.board:
      for item in row:
        print(item, end=" ")
      print()

  def start(self):
    self.create_board()
    player = 'X' if self.get_random_first_player() == 1 else 'O'
    while True:
      print(f"Player {player} turn")
      self.show_board()
      
      ## Taking user input
      row, col = list(
        map(int, input("Enter row and column numbers to fix spot: ").split()))
      print()
      
      ## Fixing the spot
      self.fix_spot(row - 1, col - 1, player)
      
      ## Checking whether current player is won or not
      if self.is_player_win(player):
        print(f"Player {player} wins the game!")
        break

      ## Checking whether the game is draw or not
      if (self.is_board_filled()):
        print("Match Draw!")
        break

      ## Swapping the turn
      player = self.swap_player_turn(player)

    ## Showing the final view of board
    print()
    self.show_board()

