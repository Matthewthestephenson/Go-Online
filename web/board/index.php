<!DOCTYPE html>
<html>
<head>
   <title>PHP test</title>
   <link rel="stylesheet" type="text/css" href="/css/board.css">
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
<h4>
   Info about JSON string:
</h4>
<p>
   To place a piece on the board, the input json string
   is
   <br />
   {"playerID":0, "action":2, "details":{"row":1, "col":2}}
   <br />
   The playerID can be any number for this test.
   <br />
   The row and column values can be changed to anything from 0 to 18 in this example
</p>
<script type="text/javascript" src="/js/network.js">
</script>
<script type="text/javascript" src="/js/script.js">
</script>
</body>
</html>

