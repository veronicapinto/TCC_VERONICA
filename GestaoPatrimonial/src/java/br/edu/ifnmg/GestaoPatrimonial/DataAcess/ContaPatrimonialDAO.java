/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IContaPatrimonialRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author veronica
 */
@Stateless(name = "IContaPatrimonialRepositorio")
public class ContaPatrimonialDAO
        extends DAOGenerico<ContaPatrimonial>
        implements IContaPatrimonialRepositorio {

    public ContaPatrimonialDAO() {
        super(ContaPatrimonial.class);

    }

    @Override
    public List<ContaPatrimonial> Buscar(ContaPatrimonial obj) {
        //corpo da consuta
        String consulta = "select c from ContaPatrimonial c";

        //A parte Where da consulta
        String filtro = "";

        //Guarda a lista de parametros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        if (obj != null) {
            //verifica campo por campo os valores que serão filtrados
            if (obj.getConta() != null) {
                filtro += " c.conta=:conta ";
                parametros.put("conta", obj.getConta());
            }
            if (obj.getDescricao() != null && obj.getDescricao().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                 filtro += " lower(c.descricao) like lower('%" + obj.getDescricao() + "%')";
            }
            if (obj.getId() != null && obj.getId() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " c.id =: id ";
                parametros.put("id", obj.getId());
            }
            // Se houver filtros, coloca o "where" na consulta
            if (filtro.length() > 0) {
                consulta = consulta + " where " + filtro;
            }
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
