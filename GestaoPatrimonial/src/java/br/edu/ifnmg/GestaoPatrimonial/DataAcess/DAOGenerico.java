/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IRepositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author veronica
 */

public abstract class DAOGenerico<T> implements IRepositorio<T> {
    @PersistenceContext(name="GestaoPatrimonialPU")
    protected EntityManager manager;
    private Class tipo;
    public DAOGenerico (Class t) {
        tipo = t;
    }
    
   

 
    public boolean Salvar(T obj) {
        try{
            //salva o objeto
            manager.merge(obj);
            return true;
        }catch (Exception ex){
        System.out.println(ex.getMessage());
        return false;
        }
    }
    
          
    
    //@Override
    public T Abrir(long id) {
        try {
            T obj = (T) manager.find(tipo, id);
            return obj;
            //abrir
        } catch (Exception ex) {
            return null;
        }
    }
    
    
      public List<T> Buscar(int inicio, int qtd) {
        Query consulta = (Query) manager.createQuery("select b from BemPatrimonial b ");

        consulta.setFirstResult(inicio);
        consulta.setMaxResults(qtd);

        List<T> lista = consulta.getResultList();

        return lista;
    }

   // @Override
    public boolean Apagar(T obj) {
        try {
            manager.remove(manager.merge(obj));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}