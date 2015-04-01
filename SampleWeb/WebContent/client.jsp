<html>
<head>
  <title>Refresh the region</title>
  <style>
	body {
		font-family: Arial;
		font-size: 12px;
	}
  </style>
  <script>
	window.onload = function() {
		document.forms[0].region.focus();
	}
  </script>
</head>
<body>

<form action="client" method="post">
	Enter the name of the region to be updated : <input type="text" name="region"/></br>
	<input type="submit" value="Submit"/>
</form>

</body>
</html>