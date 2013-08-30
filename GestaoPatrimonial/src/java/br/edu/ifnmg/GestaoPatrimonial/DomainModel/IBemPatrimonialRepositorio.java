/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DomainModel;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author veronica
 */
@Remote
public interface IBemPatrimonialRepositorio
        extends IRepositorio<BemPatrimonial> 
        {
   }
