# Quantic Tic-Tac-Toe

## Description
The objective of this exercise is to build a Quantic Tic-Tac-Toe game (On a 3x3 board, human vs AI), playable using a REST API. 

## Game rules 

(based on [this wikipedia article](https://en.wikipedia.org/wiki/Quantum_tic-tac-toe), feel free to use it)

The quantic tic-tac-toe is an alternative to the "classic" tic-tac-toe where players' moves are "superpositions" of plays. 

On each turn, the player marks two squares with its letter (`X` or `O`) and each letter is subscripted with the number of the move (odd numbers for X, as it goes first, even for O).

```
(X1, X1), (O2, O2), (X3, X3), (O4, O4) ...
```

The two marks `(X1, X1)` are called "entangled".

Example of a board after 3 moves

```
|--------|--------|--------|
|   X1   |   O2   |        |
|--------|--------|--------|
|        |X1 O2 X3|        |
|--------|--------|--------|
|        |        |   X3   |
|--------|--------|--------|
```

When a "cyclic entanglement" appears, the positions can be reduced using the following rule : 

- The first player that started the cycle chose on which square he wants to "collapse" the first pair. 
- The rest of the cycle is reduced 

For example if the O player plays this move :

```
|--------|--------|--------|
| X1 O4  | O2 O4  |        |
|--------|--------|--------|
|        |X1 O2 X3|        |
|--------|--------|--------|
|        |        |   X3   |
|--------|--------|--------|
```
We now have a cycle : X1 - X1 / O2 - O2 / O4 - O4

If player chose to collapse X1 to the top left corner the board can be reduced as following :

```
|--------|--------|--------|
|   X1   |   O4   |        |
|--------|--------|--------|
|        |   O2   |        |
|--------|--------|--------|
|        |        |   X3   |
|--------|--------|--------|
```

The first player to achieve a tic-tac-toe (three in a row horizontally, vertically, or diagonally) consisting entirely of classical marks is declared the winner.

## Expected Result & Requirements

The result must be a python REST API (using Flask or any other Framework) with two endpoints : 

- One to start a game  
- One to play a move (mark or collapse), returning the new board, completed with the player and opponent (an AI, see below) moves, reduced if needed. Or a message if the game is over. 

The game is a single player one, the opponent being powered by an AI.

There are no requirements in implementing a smart AI, random moves are enough for the purpose of this exercise.

**Additional constraint : The API must be stateless, but secured (in the way that the game can't be hacked).**

The code must be pushed on this Github repository, with clear indications on how to run it. A special consideration will be given to code quality/robustness/efficiency.
