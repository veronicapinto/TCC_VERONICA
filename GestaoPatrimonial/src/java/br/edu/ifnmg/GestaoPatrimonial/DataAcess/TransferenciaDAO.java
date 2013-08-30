/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ITransferenciaRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Transferencia;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author veronica
 */
@Stateless(name = "ITransferenciaRepositorio")
public class TransferenciaDAO
        extends DAOGenerico<Transferencia>
        implements ITransferenciaRepositorio {

    public TransferenciaDAO() {
        super(Transferencia.class);
    }


    @Override
    public List<Transferencia> Buscar(Transferencia obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
