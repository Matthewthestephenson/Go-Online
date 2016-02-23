/*
Makes an object from the playerId, action
number, and details object. Stringifies
the object and returns a string
*/
function makeString(id, act, det){
   var object = 
   {
      playerId : id,
      action   : act,
      details  : det
   }
   var objString = JSON.stringify(object);
   return objString;
}

/*
Sends a string to the server
Currently unimplemented
*/
function sendString(objString){
   document.getElementById('jsonOutput').innerHTML = objString;
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
      alert("invalid action number");
      break;
   }
}
