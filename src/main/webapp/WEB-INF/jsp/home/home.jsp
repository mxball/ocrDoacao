<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            OCR DOAÇÃO
        </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="/css/home.css"> 
    </head>
    <body>
        <div class="container">
            <div class="header clearfix">
                <nav>
                  <ul class="nav nav-pills pull-right">
                    <li role="presentation" class="active"><a href="#">Home</a></li>
                  </ul>
                </nav>
                <h3 class="text-muted">OCR Doação</h3>
            </div>
            <div class="col">
                <fieldset>
                    <legend>Cupom Fiscal</legend>
                    <!--<img id="notaFiscal" src="http://alimentar.org.br/wp-content/uploads/2012/11/cupom_fiscal_modelo.png">-->
                    <img id="notaFiscal" src="http://videos.web-03.net/artigos/Daruma_Developer/Arredondamento_e_Truncamento_de_Itens/imagem001.jpg">
                </fieldset>
            </div>
            <div class="col">
                <form role="form" action="/cadastra" method="post" class="form">
                    <fieldset>
                        <legend>Dados do cupom fiscal</legend>
                        <div class="hidden">
							<input type="text" value="${id}" name="notafiscal.instituicaoId">
						</div>
                        <div class="form-group">
                            <label for="cnpj">CNPJ:</label>
                            <input type="text" class="form-control" id="cnpj" name="notafiscal.cnpj" placeholder=""
                             value="${notafiscal.cnpj}" >
                            <c:forEach items="${errors}" var="error">
                             	<c:if test = "${error.category == 'notafiscal.cnpj'}">
	                             	<p class="validation_error">* ${error.message}</p>
                            	</c:if>
                            </c:forEach>
                        </div>
                        <div class="form-group">
                            <label for="coo">COO:</label>
                            <input type="text" class="form-control" id="coo" name="notafiscal.coo" value="${notafiscal.coo}" >
                            <c:forEach items="${errors}" var="error">
                            	<c:if test = "${error.category == 'notafiscal.coo'}">
                             		<p class="validation_error">* ${error.message}</p>
                             	</c:if>
                            </c:forEach>
                        </div>
                        
                        <div class="form-group">
                            <label for="valor">Valor:</label>
                            <input type="text" class="form-control" id="valor" name="notafiscal.valor" value="${notafiscal.valor}" >
                            <c:forEach items="${errors}" var="error">
                            	<c:if test = "${error.category == 'notafiscal.valor'}">
                             		<p class="validation_error">* ${error.message}</p>
                             	</c:if>
                            </c:forEach>
                        </div>
                        <div class="form-group">
                            <label for="data">Data:</label>
                            <input type="text" class="form-control" id="data" name="notafiscal.data" value="${notafiscal.data}" >
                        	<c:forEach items="${errors}" var="error">
                            	<c:if test = "${error.category == 'notafiscal.data'}">
                             		<p class="validation_error">* ${error.message}</p>
                             	</c:if>
                            </c:forEach>
                        </div>
                        <div id="erro" class="form-group"></div>
                        <button type="submit" class="btn btn-primary"><b>Confirmar</b></button>
                    </fieldset>
                </form>
            </div>
            <div class="col">
                <fieldset>
                    <legend>Resultado</legend>
                    <div class="form-group">
                        <label for="resultado">Resultado:</label>
                        <textarea name="resultado" class="form-control" id="resultado" cols="20" rows="15"></textarea>
                    </div>
                </fieldset>
            </div>
        </div>
        <script src="/javascript/jquery.min.js"></script>
        <script src="/javascript/jquery.mask.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
            	var erro = false;
            	$("#data").mask("00/00/0000");
            	$("#valor").mask("###0.00", { reverse: true });
               	$("#coo").mask("000000");
               	$("#cnpj").mask("00.000.000/0000-00");
               	$("form").submit(function(e) {
            		var data = $("#data").val();
            		var valor = $("#valor").val();
            		var coo = $("#coo").val();
            		var cnpj = $("#cnpj").val();
               		if (data == null || data == "" || 
               			valor == null || valor == "" ||
               			coo == null ||  coo == "" ||
               			cnpj == null || cnpj == "")
               		{
               			if (!erro){
               				erro = true;
               				$("#erro").prepend("<p class='validation_error'>* Todos os campos são obrigatórios</p>");	
               			}
               			e.preventDefault();
               		}
               	});
            });
        </script>
    </body>
</html>