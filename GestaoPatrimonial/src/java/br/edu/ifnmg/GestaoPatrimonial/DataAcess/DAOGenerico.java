/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Entidade;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IRepositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author veronica
 */

public abstract class DAOGenerico<T extends Entidade> implements IRepositorio<T> {
    @PersistenceContext(name="GestaoPatrimonialPU")
    protected EntityManager manager;
    private Class tipo;
    public DAOGenerico (Class t) {
        tipo = t;
    }
    
   

 
    @Override
    public T Salvar(T obj) {
        try{
            if(manager.contains(obj) || (obj.getId() != null && obj.getId() > 0)) {
                obj = manager.merge(obj);
            }
            else {
                manager.persist(obj);
            }
            
            manager.flush();
            return obj;
        }catch (Exception ex){
        System.out.println(ex.getMessage());
        return null;
        }
    }
    
          
    
    @Override
    public T Abrir(Long id) {
        try {
            T obj = (T) manager.find(tipo, id);
            return obj;
            //abrir
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    @Override
      public abstract List<T> Buscar(T obj);

    @Override
    public boolean Apagar(T obj) {
        try {
            manager.remove(manager.merge(obj));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}