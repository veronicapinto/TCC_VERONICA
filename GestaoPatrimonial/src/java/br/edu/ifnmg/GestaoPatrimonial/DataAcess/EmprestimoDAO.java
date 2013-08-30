/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Emprestimo;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IEmprestimoRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author veronica
 */
@Stateless(name= "IEmprestimoRepositorio")
public class EmprestimoDAO 
extends DAOGenerico<Emprestimo>
implements IEmprestimoRepositorio 
    {
        public EmprestimoDAO() {
            super(Emprestimo.class);
        
    }

    @Override
    public List<Emprestimo> Buscar(Emprestimo obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
 