/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presention;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.BemPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IBemPatrimonialRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IContaPatrimonialRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author veronica
 */
@Named(value = "contaPatrimonialController")
@SessionScoped
public class ContaPatrimonialController implements Serializable {

   
    ContaPatrimonial entidade;
    
    @EJB
    IContaPatrimonialRepositorio dao;
    /**
     * Creates a new instance of ContaPatrimonialController
     */
    public ContaPatrimonialController() {
        entidade = new ContaPatrimonial();
    }
    
    public void salvar(){
        dao.Salvar(entidade);
    }

    public ContaPatrimonial getEntidade() {
        return entidade;
    }

    public void setEntidade(ContaPatrimonial entidade) {
        this.entidade = entidade;
    }
    
    
}
