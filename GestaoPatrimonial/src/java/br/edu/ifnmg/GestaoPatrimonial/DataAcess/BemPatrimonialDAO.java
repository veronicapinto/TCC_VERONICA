/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.BemPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IBemPatrimonialRepositorio;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author veronica
 */
@Stateless (name="IBemPatrimonialRepositorio")
public class BemPatrimonialDAO
    extends DAOGenerico<BemPatrimonial> 
    implements IBemPatrimonialRepositorio
{
    public BemPatrimonialDAO(){
        super(BemPatrimonial.class);
    }

    

    @Override
    public List<BemPatrimonial> Buscar(BemPatrimonial obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}