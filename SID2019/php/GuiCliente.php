<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
setTimeout(() => {
	let el = document.querySelector("select[name='migracao']");
	if (el.value == 0) {
		el.value = "Básica";
	}
}, 29500 /* 5 min*/ );
   setTimeout(function(){ document.getElementById("myForm").submit(); }, 30000);
</script>
</head>
<body>

	Migração
	<form id="myForm" name="myForm" method="post" action="migrate.php">
	<select name="migracao">
		<option value="0">Selecione um tipo de migração</option>
		<option value="Básica">Básica</option>
		<option value="Completa">Completa</option>
	</select>
	<input type="submit" value="OK!"/>
	</form>


</body>
</html>
