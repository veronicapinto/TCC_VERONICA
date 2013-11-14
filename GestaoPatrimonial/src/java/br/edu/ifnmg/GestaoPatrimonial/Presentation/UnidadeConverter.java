/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Unidade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author veronica
 */
@Named(value = "unidadeConverter")
@SessionScoped
public class UnidadeConverter implements Serializable, Converter {

    /**
     * Creates a new instance of UnidadeConverter
     */
    public UnidadeConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if(value ==null || value.trim().equals("")) {
           return null;
       }else{
           return Unidade.valueOf(value);
       }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        }else{
            Unidade u = (Unidade) value;
            return u.toString();
        }
    }
}
