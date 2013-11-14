/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IContaPatrimonialRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author veronica
 */
@Named(value = "contaPatrimonialConverter")
@SessionScoped
public class ContaPatrimonialConverter implements Serializable, Converter {

    @EJB
    IContaPatrimonialRepositorio daoContapatrimonial;

    /**
     * Creates a new instance of ContaPatrimonialConverter
     */
    public ContaPatrimonialConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;

        } else {
            Long id = Long.parseLong(value);
            return daoContapatrimonial.Abrir(id);

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            ContaPatrimonial cp = (ContaPatrimonial) value;
            return cp.getId().toString();
        }
    }
}
