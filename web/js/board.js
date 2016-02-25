var playerId = 1;  // Will eventually be based on login
var board = [];
var size = 19;
clearBoard();


/*
Returns the id of the html cell
at the given row and column
*/
function getCell(row, col){
   return document.getElementById("r" + row + "c" + col);
}


/*
Returns the index in the board array
corresponding to the given row, 
column pair
*/
function getIndex(row, col){
   return 19*row + col;
}


/*
Called when the user clicks on a cell
Writes a json string with the action and
row/cell to send to the server
*/
function requestPlace(r, c){
   var details =
   {
      row : r,
      col : c
   }
   sendString(makeString(playerId, 1, details));
}


/*
Calls getCell() to get the cell to modify
Changes the contents of the cell to the 
letter 'O' if the cell was previously empty
Alternates colors
*/
function placePiece(row, col, color){
   var cell = getCell(row, col);
   var colors = ['white', 'black'];
   var index = getIndex(row,col);
   if(color < 0)
      removePiece(row, col);
   else if(board[index] < 0){  // If cell is currently blank
      board[index] = color;
      cell.style.backgroundImage = "url(/images/" + colors[color] + "Stone.png)";
   }
   else{
      // If server sends an incorrect placement
      // command, refresh entire board
   }
}


/*
Removes a piece from the board,
replacing in with a blank space
*/
function removePiece(row, col){
   var cell = getCell(row, col);
   cell.style.backgroundImage = "none";
   board[getIndex(row, col)] = -1;
}


/*
Iterates through all cells on the board and
removes all stones
*/
function clearBoard(){
   for (var row = 0; row < size; row++)
      for (var col = 0; col < size; col++)
         removePiece(row, col);
}


/*
Requests a copy of the board from
the server when an error occurs
*/
function requestReset(){
   var details =
   {
   };
   sendString(makeString(playerId, 3, {})); 
}

/*
When an error occurs and the client and
server don't the same board stored in
memory, the server sends an entire board
to the client
*/
function resetBoard(newBoard){
   clearBoard();  // Have to clear the board before replacing pieces
   for (var row = 0; row < size; row++)
      for (var col = 0; col < size; col++)
         placePiece(row, col, newBoard[getIndex(row, col)]);
}
