package com.example.project;

public class CupomFiscal {

	private static final String ENDLN = System.lineSeparator();

	private static boolean isEmpty(String str){
		int spaceCount = str.length() - str.replace(".", "").length();
		return (str == null || spaceCount == str.length());
	}

	public static String dadosLojaParam(String nomeLoja, String logradouro, int numero, String complemento,
			String bairro, String municipio, String estado, String cep, String telefone, String observacao, String cnpj,
			String inscricaoEstadual) throws RuntimeException {
		
		//Implemente aqui
		if (isEmpty(municipio)){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}

		if (isEmpty(cnpj)) {
			throw new RuntimeException("O campo CNPJ da loja é obrigatório");
		}

		if (isEmpty(inscricaoEstadual)) {
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		if (isEmpty(nomeLoja)) {
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}

		if (isEmpty(logradouro)) {
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		if (isEmpty(estado)) {
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}

		String numeroStr = (numero > 0) ? numero + "" : "s/n";

		String ln2 = logradouro + ", " + numeroStr;
		ln2 += isEmpty(complemento) ? "" : " " + complemento;
		ln2 += ENDLN;

		String ln3 = "";
		ln3 += isEmpty(bairro) ? "" : bairro + " - ";
		ln3 += municipio + " - " + estado + ENDLN;

		String ln4 = "";
		ln4 += isEmpty(cep) ? "" : "CEP:" + cep;
		

		if (!isEmpty(telefone)){
			ln4 += isEmpty(ln4) ? "" : " ";
			ln4 += "Tel " + telefone;
		}
		ln4 += isEmpty(ln4) ? "" : ENDLN;

		String ln5 = "";
		ln5 += isEmpty(observacao) ? "" : observacao;
		ln5 += ENDLN;


		String output = nomeLoja + ENDLN;
		output += ln2;
		output += ln3;
		output += ln4;
		output += ln5;
		output += "CNPJ: " + cnpj + ENDLN;
		output += "IE: " + inscricaoEstadual + ENDLN;

		return output;
	}
}
