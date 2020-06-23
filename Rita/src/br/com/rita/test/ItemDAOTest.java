package br.com.rita.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rita.dao.ItemDAO;
import br.com.rita.dao.ProdutoDAO;
import br.com.rita.dao.RetiradaDAO;
import br.com.rita.domain.Item;
import br.com.rita.domain.Produto;
import br.com.rita.domain.Retirada;

public class ItemDAOTest {

	@Test
	@Ignore
	public void salvar() {

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(2L);

		RetiradaDAO retiradaDAO = new RetiradaDAO();
		Retirada retirada = retiradaDAO.buscarPorCodigo(2L);

		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(3);
		item.setRetirada(retirada);

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);

	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();

		List<Item> itens = itemDAO.listar();

		System.out.println(itens);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {

		ItemDAO itemDAO = new ItemDAO();

		Item item = itemDAO.buscarPorCodigo(1L);

		System.out.println(item);
	}

	@Test
	@Ignore
	public void excluir() {
		ItemDAO itemDAO = new ItemDAO();

		Item item = itemDAO.buscarPorCodigo(1L);
	
		itemDAO.excluir(item);
	}
	@Test
	public void editar() {
		

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(1L);

		RetiradaDAO retiradaDAO = new RetiradaDAO();
		Retirada retirada = retiradaDAO.buscarPorCodigo(2L);
		

		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(2L);
		
		item.setProduto(produto);
		item.setQuantidade(5);
		item.setRetirada(retirada);
		
		itemDAO.editar(item);
		
	}
	
	
	
	
}
