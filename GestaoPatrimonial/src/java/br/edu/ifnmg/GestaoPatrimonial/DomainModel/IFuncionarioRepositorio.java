/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DomainModel;

import javax.ejb.Remote;

/**
 *
 * @author veronica
 */
@Remote
public interface IFuncionarioRepositorio 
    extends IRepositorio<Funcionario>{
    
    public Funcionario porLogin(String login);
}
