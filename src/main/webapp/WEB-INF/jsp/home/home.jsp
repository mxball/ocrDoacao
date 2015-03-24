<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/css/home.css"/>" />
</head>
<body>
	<main>
		<h1>Doação de Notas Fiscais</h1>
		<form action="doacao" method="post" class="form">
			<ul>
				<li>
					Numero da nota: <input type="text">
				</li>
				<li>
					COO: <input type="text">
				</li>
				<li>
					Valor: <input type="text">
				</li>
			</ul>
		</form>
	</main>
</body>
</html>