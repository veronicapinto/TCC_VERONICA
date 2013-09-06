/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ITransferenciaRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Transferencia;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

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
        // Corpo da consulta
        String consulta = "select t from Transferencia t";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj.getBem() != null) {
            filtro = " c.bem =: bem";
            parametros.put("bem", obj.getBem());
        }

        if (obj.getData() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " c.data =: data";
            parametros.put("data", obj.getData());
        }

        if (obj.getFuncionario() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " c.funcionario =: funcionario";
            parametros.put("funcionario", obj.getFuncionario());
        }


        if (obj.getId() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " c.id =: id";
            parametros.put("id", obj.getId());
        }

        if (obj.getLocal() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " c.local =: local";
            parametros.put("local", obj.getLocal());
        }


        // Se houver filtros, coloca o "where" na consulta
        if (filtro.length() > 0) {
            consulta = consulta + " where " + filtro;
        }

        // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Aplica os parâmetros da consulta
        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }

        // Executa a consulta
        return query.getResultList();

    }
}
