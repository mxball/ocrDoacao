package br.com.ime.ocrDoacao.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.ime.ocrDoacao.dao.NotaFiscalDao;
import br.com.ime.ocrDoacao.model.NotaFiscal;

@Resource
public class HomeController {

	private final NotaFiscalDao dao;
	private final Result result;
	private final Validator validator;

	public HomeController(NotaFiscalDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	public void home() throws IOException, JSONException {
		JSONObject json = readJsonFromUrl("http://data.ime.usp.br/ocr-web/example/list");
		JSONArray array = json.getJSONArray("images");
		JSONObject jsonObject = array.getJSONObject(0);
		result.include("path", jsonObject.getString("path"));
	}

	@Get("/aacd")
	public void aacd() throws IOException, JSONException {
		result.include("id", 1);
		result.forwardTo(this).home();
	}

	@Get("/graac")
	public void graac() throws IOException, JSONException {
		result.include("id", 2);
		result.forwardTo(this).home();
	}

	@Post("/cadastra")
	public void cadastra(NotaFiscal notafiscal) throws IOException, JSONException {
		validaNotaFiscal(notafiscal);

		if (validator.hasErrors()) {
			decideInstituicao(notafiscal.getInstituicaoId());
		} else {
			dao.adicionaNotaFiscal(notafiscal);
			result.forwardTo(this).home();
		}
	}

	@Get("/notaFiscal")
	public void nota() {
		result.forwardTo("/WEB-INF/jsp/img.jsp");
	}

	private void validaNotaFiscal(NotaFiscal notafiscal) {
		if (notafiscal.validaCnpj()) {
			validator.add(new ValidationMessage("CNPJ inválido.",
					"notafiscal.cnpj"));
		}
		if (notafiscal.validaCoo()) {
			validator.add(new ValidationMessage("O COO deve conter 6 dígitos.",
					"notafiscal.coo"));
		}
		if (notafiscal.validaValor()) {
			validator.add(new ValidationMessage("Valor inválido.",
					"notafiscal.valor"));
		}
		if (notafiscal.validaData()) {
			validator.add(new ValidationMessage("Data de emissão inválida.",
					"notafiscal.data"));
		}

	}

	private void decideInstituicao(int id) throws IOException, JSONException {
		result.include("id", id);
		if (id == 1) {
			validator.onErrorRedirectTo(this).aacd();
		}
		if (id == 2) {
			validator.onErrorRedirectTo(this).graac();
		}
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
}