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
