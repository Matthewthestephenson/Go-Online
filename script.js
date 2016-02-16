var turn = 0;

/*
Returns the id of the html cell at the given row and column
*/
function getCell(row, col){
   return document.getElementById("r" + row + "c" + col);
}

/*
Called when the user clicks on a cell
Writes a json string with the action and
row/cell to send to the server
*/
function requestPlace(r, c){
   var requestObject =
      {
         playerID : 1,
         action : 1,
         details :
            {
               row : r,
               col : c
            }
      }
   document.getElementById('jsonOutput').innerHTML=JSON.stringify(requestObject);
}

/*
Calls getCell() to get the cell to modify
Changes the contents of the cell to the 
letter 'O' if the cell was previously empty
Alternates colors
*/
function placePiece(row, col){
   var cell = getCell(row, col);
   var colors = ['white', 'black'];
   if(cell.innerHTML == ""){
      cell.style.color = colors[turn];
      cell.style.backgroundImage = "url(" + colors[turn] + "Stone.png)";
      cell.innerHTML = "O";
      turn = 1 - turn;
   }
}

/*
Called when the user clicks "Clear Board"
Not implemented because this won't be in
final project
*/
function requestClear(){
   document.getElementById('jsonOutput').innerHTML="function not implemented";
   clearBoard();
}

/*
Iterates through all cells on the board and
removes all 'stones'
*/
function clearBoard(){
   var row, col, cell;
   for (row = 0; row < 19; row++){
      for (col = 0; col < 19; col++){
         cell = getCell(row, col);
         cell.style.backgroundImage = "none";
         cell.innerHTML = "";
      }
   }
}

/*
Parses the input JSON string
*/
function parseInput(inputString){
   var inputObject = JSON.parse(inputString);
   switch(inputObject.action){
   case 2:
      placePiece(inputObject.details.row, inputObject.details.col);
      break;
   default:
      break;
   }
}
