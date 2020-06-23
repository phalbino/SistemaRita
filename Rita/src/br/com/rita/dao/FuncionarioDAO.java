package br.com.rita.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.rita.domain.Funcionario;
import br.com.rita.util.HibernateUtil;




public class FuncionarioDAO {
	
	
	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.save(funcionario);
			transacao.commit(); // confirmando a transa��o

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}
			throw ex;
		}

		finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Funcionario> funcionarios = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionarios = consulta.list();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return funcionarios;
	}
	
	
	
	public Funcionario buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();
			

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		
		return funcionario;
	}
	
	
	public void excluir(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.delete(funcionario);
			transacao.commit(); // confirmando a transa��o

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}

		}

		finally {
			sessao.close();
		}

	}
	
	
	
	
	
	public void editar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			
			sessao.update(funcionario);
			transacao.commit(); // confirmando a transa��o

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}
			throw ex;
		} finally {
			sessao.close();
		}

	}
}
