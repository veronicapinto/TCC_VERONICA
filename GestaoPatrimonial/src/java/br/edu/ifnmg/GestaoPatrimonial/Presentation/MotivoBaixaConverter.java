/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.MotivoBaixa;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Unidade;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author veronica
 */
@Named(value = "MotivoBaixaConverter")
@SessionScoped
public class MotivoBaixaConverter implements Serializable, Converter {

    public MotivoBaixaConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            return MotivoBaixa.valueOf(value);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            MotivoBaixa mb = (MotivoBaixa) value;
            return mb.toString();
        }
    }
}
