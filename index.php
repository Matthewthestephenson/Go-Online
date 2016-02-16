<!DOCTYPE html>
<html>
<head>
   <title>PHP test</title>
   <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<table id="goBoard">
<?php
   $size = 19;
   $cellPadding = 10;
   for ($row = 0; $row < $size; $row++){  // For each row
      echo "<tr>\n";  // Create a new html row
      for ($col = 0; $col < $size; $col++){  // For each column in the row
         $id = "r" . $row . "c" . $col;   // Formulate the cell's id
         echo "\t<td class='gridCell' id='" . $id . "' onclick='requestPlace(" . $row . "," . $col . ")'></td>\n";  // Create a new html cell
      }
      echo "</tr>\n";  // Close the row tag
   }
?>
</table>
<button onclick="requestClear()">Clear Board</button>
<p>
   <b>Json String to be sent:</b>
   <span id="jsonOutput"></span>
</p>
<p>
   <input id="jsonInput"></input>
   <button onclick="parseInput(document.getElementById('jsonInput').value)">
      Input
   </button>
</p>
<script type="text/javascript" src="script.js">
</script>
</body>
</html>

