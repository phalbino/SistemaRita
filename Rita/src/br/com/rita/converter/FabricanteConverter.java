package br.com.rita.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rita.dao.FabricanteDAO;
import br.com.rita.domain.Fabricante;

@FacesConverter("fabricanteConverter")
public class FabricanteConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
	try {
		Long codigo = Long.parseLong(valor);
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(codigo);
		return fabricante;
	}catch(RuntimeException ex) {
		return null;
	}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componen, Object objeto) {
		try {
		Fabricante fabricante = (Fabricante) objeto;
		Long codigo = fabricante.getCodigo();
		return codigo.toString();
		}catch(RuntimeException ex) {
		return null;
	}
	}
}

