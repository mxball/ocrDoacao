<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/css/home.css"/>" />
</head>
<body>
	<main>
		<h1>Doação de Notas Fiscais</h1>
		<form action="/cadastra" method="post" class="form">
			<ul>
				<li>
					CNPJ: <input type="text" id="cnpj" name="notafiscal.cnpj">
				</li>
				<li>
					COO: <input type="text" id="coo" name="notafiscal.coo">
				</li>
				<li>
					Valor: <input type="text" id="valor" name="notafiscal.valor">
				</li>
				<li>
					Data: <input type="text" id="data" name="notafiscal.data">
				</li>
				     <button type="submit">Enviar</button>
			</ul>
		</form>
	</main>
</body>
</html>