<!DOCTYPE html>
<html>
<head>
   <title>PHP test</title>
   <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<table>
<?php
   $size = 20;
   $cellPadding = 10;
   for ($row = 0; $row < $size; $row++){  // For each row
      echo "<tr>\n";  // Create a new html row
      for ($col = 0; $col < $size; $col++){  // For each column in the row
         $id = "r" . $row . "c" . $col;   // Formulate the cell's id
         echo "\t<td class='gridCell' id='" . $id . "' onclick='cellClick(" . $row . "," . $col . ")'></td>\n";  // Create a new html cell
      }
      echo "</tr>\n";  // Close the row tag
   }
?>
</table>
<button onclick="clearBoard()">Clear Board</button>
<script>
var turn = 0;

/*
Returns the id of the html cell at the given row and column
*/
function getCell(row, col){
   return document.getElementById("r" + row + "c" + col);
}

/*
Calls getCell() to get the cell to modify
Changes the contents of the cell to the 
letter 'O' if the cell was previously empty
Alternates colors
*/
function cellClick(row, col){
   var cell = getCell(row, col);
   var colors = ['white', 'black'];
   if(cell.innerHTML == ""){
      cell.style.color = colors[turn];
      cell.innerHTML = "O";
      turn = 1 - turn;
   }
}

/*
Iterates through all cells on the board and
removes all 'stones'
*/
function clearBoard(){
   var row, col;
   for (row = 0; row < 20; row++){
      for (col = 0; col < 20; col++){
         getCell(row, col).innerHTML = "";
      }
   }
}
</script>
</body>
</html>

