/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ITipoFuncionarioRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.TipoFuncionario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author veronica
 */
@Stateless(name = "ITipoFuncionarioRepositorio")
public class TipoFuncionarioDAO
        extends DAOGenerico<TipoFuncionario>
        implements ITipoFuncionarioRepositorio {

    public TipoFuncionarioDAO() {
        super(TipoFuncionario.class);
    }

    @Override
    public TipoFuncionario Abrir(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TipoFuncionario> Buscar(TipoFuncionario obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
