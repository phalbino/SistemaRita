package br.com.rita.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.rita.dao.FuncionarioDAO;
import br.com.rita.domain.Funcionario;
import br.com.rita.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	
	private Funcionario funcionarioCadastro;
	private List<Funcionario> listaFuncionarios;							  
	private List<Funcionario> listaFuncionariosFiltrados;
	private String acao;
	private Long codigo;
	
	
	
	








	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}



	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}



	
	public List<Funcionario> getListaFuncionariosFiltrados() {
		return listaFuncionariosFiltrados;
	}



	public void setListaFuncionariosFiltrados(List<Funcionario> listaFuncionariosFiltrados) {
		this.listaFuncionariosFiltrados = listaFuncionariosFiltrados;
	}



	public String getAcao() {
		return acao;
	}



	public void setAcao(String acao) {
		this.acao = acao;
	}



	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public Funcionario getFuncionarioCadastro() {
			return funcionarioCadastro;
	}



	public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}

	public void novo() {

		funcionarioCadastro = new Funcionario();
	}

	public void salvar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.salvar(funcionarioCadastro);

			funcionarioCadastro = new Funcionario();

			FacesUtil.adicionarMsgInfo("Funcionario Salvo com Sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar Cadastrar um Funcionario" + ex.getMessage());
		}
	}

	public void carregarPesquisa() {

		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			listaFuncionarios = funcionarioDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar listar os Funcionarios" + ex.getMessage());
		}

	}

	public void carregarCadastro() {
		try {
			
			if (codigo != null) {
				

				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

				funcionarioCadastro = funcionarioDAO.buscarPorCodigo(codigo);
			} else {

				funcionarioCadastro = new Funcionario();
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar obter os dados do Funcionario" + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionarioCadastro);

			FacesUtil.adicionarMsgInfo("Funcionario removido com Sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar remover um Funcionario" + ex.getMessage());
		}
	}

	public void editar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.editar(funcionarioCadastro);

			FacesUtil.adicionarMsgInfo("Funcionario editado com Sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Ocorreu um erro ao tentar editar os dados do Funcionario" + ex.getMessage());
		}
	}
	
}
