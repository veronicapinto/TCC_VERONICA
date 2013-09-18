/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presention;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.BemPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IBemPatrimonialRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author veronica
 */
@Named(value = "bemController")
@SessionScoped
public class BemController implements Serializable {

    
    BemPatrimonial entidade;
    
    @EJB
    IBemPatrimonialRepositorio dao;
    
    /**
     * Creates a new instance of BemController
     */
    public BemController() {
        entidade = new BemPatrimonial();
    }
}
