package br.com.jgle.teste.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jgle.teste.Categoria;
import br.com.jgle.teste.ProdutoTeste;

public class TesteJPA2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Categoria categoria = new Categoria();
		categoria.setCategoria("Produto");
		categoria.setDescricao("Descriçao cat produto");

		ProdutoTeste produto = new ProdutoTeste();
		produto.setName("livros");

		em.persist(produto);

		em.getTransaction().commit();

		em.close();
		emf.close();
		System.out.println("FINISH");
	}
}
