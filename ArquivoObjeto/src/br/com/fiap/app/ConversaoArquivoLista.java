package br.com.fiap.app;

import java.util.List;

import br.com.fiap.model.Registro;
import br.com.fiap.negocio.ProdutoBO;

public class ConversaoArquivoLista {

	public static void main(String[] args) {
		
		ProdutoBO neg = new ProdutoBO();
		String arq = "/Users/eduardogondo/Downloads/precos.csv";
		try {
			List<Registro> lista = neg.leArquivoPrecos(arq);
			for(Registro reg : lista) {
				System.out.println(reg.getLocal() + " " + reg.getProduto());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
