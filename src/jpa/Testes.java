package jpa;

import java.util.List;

public class Testes {
	
	public static void main(String[] args) {
		UsersJug userJug = new UsersJug();
		userJug.setName("Joaozinho");
		userJug.setEmail("jo@ozinho.com");
		
		CassandraDAO cdao = new CassandraDAO();
		
		cdao.persistir(userJug);
		imprimirLista(cdao.listar());
		
		cdao.remover(userJug);
		imprimirLista(cdao.listar());
	}
	
	public static void imprimirLista(List<UsersJug> users){
		for (UsersJug user : users) {
			System.out.println(user.getName()+" "+user.getEmail()
					+System.lineSeparator());
		}
	}
}



