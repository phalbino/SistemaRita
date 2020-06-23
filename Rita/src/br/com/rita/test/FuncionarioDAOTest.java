package br.com.rita.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rita.dao.FuncionarioDAO;
import br.com.rita.domain.Funcionario;

public class FuncionarioDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Funcionario funcionario = new Funcionario();

		funcionario.setCpf("103.032.592-34");
		funcionario.setFuncao("Gerente");
		funcionario.setNome("Corinthiano");
		funcionario.setSenha("1234567");

		FuncionarioDAO dao = new FuncionarioDAO();

		dao.salvar(funcionario);
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO dao = new FuncionarioDAO();

		List<Funcionario> funcionarios = dao.listar();

		System.out.println(funcionarios);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
	FuncionarioDAO dao = new FuncionarioDAO();
	
	Funcionario funcionario = dao.buscarPorCodigo(1L);
	
	System.out.println(funcionario);
	
	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.buscarPorCodigo(3L);

		dao.excluir(funcionario);

	}

	@Test
	
	public void editar() {

		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.buscarPorCodigo(2L);
		funcionario.setNome("Paula Campos");
		funcionario.setSenha("456");
		funcionario.setCpf("064.645.432-54");
		funcionario.setFuncao("Gerente");

		dao.editar(funcionario);

	}

}
