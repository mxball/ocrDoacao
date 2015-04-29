<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/css/home.css"/>" />
</head>
<body>
	<main>
		<h1>Doação de Notas Fiscais</h1>
		<img id="notaFiscal" src="/imgs/CupomFiscal.jpg">
		<form class="formDoacao" action="/cadastra" method="post" class="form">
			<ul>
			<c:forEach items="${errors}" var="error">
				<li class="validation_error">${error.message}</li>
				<c:if test = "${error.category == 'notafiscal.cnpj'}">
					
				</c:if>
			</c:forEach>	
			</ul>
			<ul>
				<li>
					CNPJ: <input type="text" id="cnpj" name="notafiscal.cnpj"
						value="${notafiscal.cnpj}">
				</li>
				<li>
					COO: <input type="text" id="coo" name="notafiscal.coo"
						value="${notafiscal.coo}">
				</li>
				<li>
					Valor: <input type="text" id="valor" name="notafiscal.valor"
						value="${notafiscal.valor}">
				</li>
				<li>
					Data: <input type="text" id="data" name="notafiscal.data"
						value="${notafiscal.data}">
				</li>
				     <button type="submit">Enviar</button>
			</ul>
		</form>
	</main>
</body>
</html>