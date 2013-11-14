/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.TipoAquisicao;
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
@Named(value = "tipoAquisicaoConverter")
@SessionScoped
public class TipoAquisicaoConverter implements Serializable, Converter {

    /**
     * Creates a new instance of TipoAquisicaoConverter
     */
    public TipoAquisicaoConverter() {
    }

    @Override
    //Converter de String para valor
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            return TipoAquisicao.valueOf(value);
        }
    }

    @Override
    //Converter o valor para String
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            TipoAquisicao ta = (TipoAquisicao) value;
            return ta.toString();
        }
    }
}
