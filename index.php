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
   for ($row = 0; $row < $size; $row++){
      echo "<tr>\n";
      for ($col = 0; $col < $size; $col++){
         $id = "r" . $row . "c" . $col;
         echo "\t<td class='gridCell' id='" . $id . "' onclick='cellClick(" . $row . "," . $col . ")'></td>\n";
      }
      echo "</tr>\n";
   }
?>
</table>
<button onclick="clearBoard()">Clear Board</button>
<script>
var turn = 0;

function getCell(row, col){
   return document.getElementById("r" + row + "c" + col);
}

function cellClick(row, col){
   var cell = getCell(row, col);
   var colors = ['white', 'black'];
   if(cell.innerHTML == ""){
      cell.style.color = colors[turn];
      cell.innerHTML = "O";
      turn = 1 - turn;
   }
}

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

