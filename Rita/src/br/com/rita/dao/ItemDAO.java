package br.com.rita.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.rita.domain.Item;
import br.com.rita.util.HibernateUtil;



public class ItemDAO {

	public void salvar(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.save(item);
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
	public List<Item> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Item> item = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Item.listar");
			item = consulta.list();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return item;
	}
	
	
	
	public Item buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Item item = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Item.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			item = (Item) consulta.uniqueResult();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return item;
	}
	
	
	public void excluir(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.delete(item);
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
	
	
	
	public void editar(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			
			sessao.update(item);
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
}
