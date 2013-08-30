/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IContaPatrimonialRepositorio;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author veronica
 */
@Stateless(name="IContaPatrimonialRepositorio")
public class ContaPatrimonialDAO
        extends DAOGenerico<ContaPatrimonial>
        implements IContaPatrimonialRepositorio {

    public ContaPatrimonialDAO() {
        super(ContaPatrimonial.class);

    }


    @Override
    public List<ContaPatrimonial> Buscar(ContaPatrimonial obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

