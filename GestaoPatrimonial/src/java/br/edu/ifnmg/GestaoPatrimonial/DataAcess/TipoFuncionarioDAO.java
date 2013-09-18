/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ITipoFuncionarioRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.TipoFuncionario;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

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
    public List<TipoFuncionario> Buscar(TipoFuncionario obj) {
// Corpo da consulta
        String consulta = "select tf from TipoFuncionario tf";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj.getDescricao() != null) {
            filtro = " tf.descricao =: descricao";
            parametros.put("descricao", obj.getDescricao());
        }

        if (obj.getId() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " tf.id =: id";
            parametros.put("id", obj.getId());
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
