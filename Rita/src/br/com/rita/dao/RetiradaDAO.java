package br.com.rita.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.rita.domain.Retirada;
import br.com.rita.util.HibernateUtil;

public class RetiradaDAO {
	
	public void salvar(Retirada retirada) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(retirada);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();

		}

	}
	@SuppressWarnings("unchecked")
	public List<Retirada> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Retirada> retirada = null;

		try {
			Query consulta = sessao.getNamedQuery("Retirada.listar");
			retirada = consulta.list();
			
			
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();

		}
		return retirada;	
	}

	public Retirada buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Retirada retirada = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Retirada.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			retirada = (Retirada) consulta.uniqueResult();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return retirada;
	}
	
	public void excluir(Retirada retirada) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(retirada);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();

		}
	}

	public void editar(Retirada retirada) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(retirada);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();

		}

	}
}
