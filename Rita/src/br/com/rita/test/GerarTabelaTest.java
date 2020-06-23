package br.com.rita.test;

import org.junit.Test;

import br.com.rita.util.HibernateUtil;

public class GerarTabelaTest {

	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
