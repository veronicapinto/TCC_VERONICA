/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.EstadoConservacao;
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
@Named(value = "estadoCConverter")
@SessionScoped
public class EstadoCConverter implements Serializable, Converter {

    /**
     * Creates a new instance of EstadoCConverter
     */
    public EstadoCConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            return EstadoConservacao.valueOf(value);

        }

    }


    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null || value.toString().equals("")){
            return "";   
        }else{
            EstadoConservacao ec = (EstadoConservacao) value;
            return ec.toString();
        }
        }
}
