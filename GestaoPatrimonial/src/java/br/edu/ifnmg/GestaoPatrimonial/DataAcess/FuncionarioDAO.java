/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DomainModel;

import br.edu.ifnmg.GestaoPatrimonial.DataAcess.DAOGenerico;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Stereotype;

/**
 *
 * @author veronica
 */ 
@Stateless(name = "IFuncionarioRepositorio")
public class FuncionarioDAO 
    extends DAOGenerico<Funcionario>
    implements IFuncionarioRepositorio

    {
    public FuncionarioDAO(){
        super(Funcionario.class);
    }

    @Override
    public List<Funcionario> Buscar(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    }
