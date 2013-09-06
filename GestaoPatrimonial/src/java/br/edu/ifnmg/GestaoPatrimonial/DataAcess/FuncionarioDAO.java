/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DomainModel;

import br.edu.ifnmg.GestaoPatrimonial.DataAcess.DAOGenerico;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Stereotype;
import javax.persistence.Query;

/**
 *
 * @author veronica
 */ 
@Stateless(name = "IFuncionarioRepositorio")
public class FuncionarioDAO 
    extends DAOGenerico<Funcionario>
    implements IFuncionarioRepositorio

    {
    public FuncionarioDAO(){
        super(Funcionario.class);
    }

    @Override
    public List<Funcionario> Buscar(Funcionario obj) {
        // Corpo da consulta
        String consulta = "select f from Funcionario f";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj.getId() != null) {
            filtro = " c.id =: id";
            parametros.put("id", obj.getId());
        }

        if (obj.getLogin() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " c.login =: login";
            parametros.put("login", obj.getLogin());
        }

        if (obj.getNome() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " c.nome =: nome";
            parametros.put("nome", obj.getNome());
        }
        if (obj.getSenha() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " c.senha =: senha";
            parametros.put("senha", obj.getSenha());
        }

        if (obj.getTipo() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " c.tipo =: tipo";
            parametros.put("tipo", obj.getTipo());
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
