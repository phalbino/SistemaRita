package br.com.rita.main;

import br.com.rita.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
	
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

		

	}

}
