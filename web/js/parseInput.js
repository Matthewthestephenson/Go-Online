/*
This is the only function ojb
this file. Given a JSON-formatted
input string, it calls the
function that corresponds to the
requested action
*/
function parseInput(inputString){
   // Create an object from the JSON string
   var obj = JSON.parse(inputString);
   
   switch(obj.action){

   // Place piece
   case 2:
      placePiece(obj.details.row, obj.details.col, obj.details.color);
      break;

   // Reset board
   case 4:
      resetBoard(obj.details.board);
      break;

   // Input action not recognized
   default:
      alert("invalid action number");
      break;
   }
}
