package br.com.rita.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.rita.dao.FuncionarioDAO;
import br.com.rita.dao.RetiradaDAO;
import br.com.rita.domain.Funcionario;
import br.com.rita.domain.Retirada;
public class RetiradaDAOTest {

@Test
@Ignore
public void salvar() {
	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	Funcionario funcionario = funcionarioDAO.buscarPorCodigo(2L);
	
	Retirada retirada = new Retirada();
	retirada.setFuncionario(funcionario);
	retirada.setHorario(new Date());
	
	RetiradaDAO retiradaDAO = new RetiradaDAO();
	retiradaDAO.salvar(retirada);
	
}

@Test
@Ignore
public void listar() {
	RetiradaDAO RetiradaDAO = new RetiradaDAO();
	
	List<Retirada> retiradas = RetiradaDAO.listar();
	
	System.out.println(retiradas);
	
	
}

@Test
@Ignore
public void buscarPorCodigo() {
	RetiradaDAO retiradaDAO = new RetiradaDAO();
	Retirada retirada = retiradaDAO.buscarPorCodigo(1L);

	System.out.println(retirada);

}

@Test
@Ignore
public void excluir() {
	RetiradaDAO retiradaDAO = new RetiradaDAO();
	
	Retirada retirada = retiradaDAO.buscarPorCodigo(1L);

	retiradaDAO.excluir(retirada);

}

@Test
@Ignore
public void editar() {
	
	
	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);
	
	RetiradaDAO retiradaDAO = new RetiradaDAO();
	Retirada retirada = retiradaDAO.buscarPorCodigo(2L);
	
	retirada.setFuncionario(funcionario);
	retirada.setHorario(new Date());
	
	
	retiradaDAO.editar(retirada);
	
}


}
