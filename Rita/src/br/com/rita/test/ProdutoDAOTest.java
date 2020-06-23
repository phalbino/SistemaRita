package br.com.rita.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rita.dao.FabricanteDAO;
import br.com.rita.dao.ProdutoDAO;
import br.com.rita.domain.Fabricante;
import br.com.rita.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void iserir() {
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(5l);
		
		Produto produto = new Produto();
		produto.setDescricao("Feijão");
		produto.setQuantidade(35);
		produto.setFabricante(fabricante);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
	}
	@Test
	@Ignore
	public void buscarPorCodigo() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(2L);
		
		System.out.println(produto);		
		
		
	}
	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<Produto> produtos = produtoDAO.listar();
		
		System.out.println(produtos);
		
		
	}
	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(3L);
	
		produtoDAO.excluir(produto);
	
	}
	
	@Test
	@Ignore
	public void editar() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(1L);
		
		produto.setDescricao("Pateko");
		produto.setQuantidade(40);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(6l);
		
		produto.setFabricante(fabricante);

		produtoDAO.editar(produto);
		
	}

}
