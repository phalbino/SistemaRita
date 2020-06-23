package br.com.rita.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rita.dao.FabricanteDAO;
import br.com.rita.domain.Fabricante;

public class FabricanteDAOTest {
	@Ignore
	@Test
	public void salvar() {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAO A");
		
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAO B");
	
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1); dao.salvar(f2);
	}
	@Ignore
	@Test
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		
			System.out.println(fabricantes);
		
	}
	@Ignore
	@Test
	public void buscarPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(1L);
		Fabricante f2 = dao.buscarPorCodigo(3L);
		System.out.println(f1);
		System.out.println(f2);
	
	}
	@Ignore
	@Test
	public void excluir() {
		
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante fabricante = dao.buscarPorCodigo(1L);
		
	
		dao.excluir(fabricante);
	
	}
		
	
	@Test
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante fabricante = dao.buscarPorCodigo(4L);
		
	
		fabricante.setDescricao("DESCRICAO H");
		
	
		dao.editar(fabricante);
		
	}
	




}
	
	
	

