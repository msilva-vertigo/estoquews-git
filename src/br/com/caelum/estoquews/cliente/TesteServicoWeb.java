package br.com.caelum.estoquews.cliente;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TesteServicoWeb {

	public static void main(String[] args) throws MalformedURLException {
		
		 URL url = new URL("http://localhost:8080/estoquews-web/EstoqueDeItens?wsdl");
	     QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueDeItens");

	     Service service = Service.create(url, qname);

	     EstoqueWS cliente = service.getPort(EstoqueWS.class);
	     
	     Filtros filtros = new Filtros();
	     Filtro filtro = new Filtro();
	     filtro.setNome("IPhone");
	     filtro.setTipo(TipoItem.CELULAR);;

	     ListaItens itens = cliente.todosOsItens(filtros);
	
		
		 System.out.println(itens.getItem().toString());
		
	}

}
