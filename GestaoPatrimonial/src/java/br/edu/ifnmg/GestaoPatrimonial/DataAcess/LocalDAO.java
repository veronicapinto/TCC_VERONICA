/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ILocalRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Local;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

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
    public List<Local> Buscar(Local obj) {
        // Corpo da consulta
        String consulta = "select l from Local l";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj.getCidade() != null) {
            filtro = " l.cidade =: cidade";
            parametros.put("cidade", obj.getCidade());
        }

        if (obj.getDescricao() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " l.descricao =: descricao";
            parametros.put("descricao", obj.getDescricao());
        }
        if (obj.getEndereco() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " l.endereco =: endereco";
            parametros.put("endereco", obj.getEndereco());
        }
        if (obj.getEstado() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " l.estado =: estado";
            parametros.put("estado", obj.getEstado());
        }
        if (obj.getId() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " l.id =: id";
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

