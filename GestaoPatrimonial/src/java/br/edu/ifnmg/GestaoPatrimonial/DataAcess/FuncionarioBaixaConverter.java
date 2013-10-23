/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Funcionario;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IFuncionarioRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ITipoFuncionarioRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.TipoFuncionario;
import java.io.Serializable;
import javax.ejb.EJB;
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
@Named(value = "FuncionarioBaixaConverter")
@SessionScoped
public class FuncionarioBaixaConverter implements Serializable, Converter {
    
    @EJB
    IFuncionarioRepositorio dao;

    public FuncionarioBaixaConverter() {
    }
    
    
    @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return dao.Abrir(id);
        }
    }

    @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Funcionario f = (Funcionario) value;
            return f.getId().toString();
        }
    }

   
}
