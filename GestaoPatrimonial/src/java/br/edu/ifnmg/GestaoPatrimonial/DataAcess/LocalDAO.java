/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ILocalRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Local;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author veronica
 */


/**
 *
 * @author veronica
 */
@Stateless(name = "ILocalRepositorio")
public class LocalDAO
        extends DAOGenerico<Local>
        implements ILocalRepositorio {

    public LocalDAO() {
        super(Local.class);
    }

    @Override
    public Local Abrir(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Local> Buscar(Local obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

