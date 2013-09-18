/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Emprestimo;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IEmprestimoRepositorio;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;


/**
 *
 * @author veronica
 */
@Stateless(name= "IEmprestimoRepositorio")
public class EmprestimoDAO 
extends DAOGenerico<Emprestimo>
implements IEmprestimoRepositorio 
    {
        public EmprestimoDAO() {
            super(Emprestimo.class);
        
    }

    @Override
    public List<Emprestimo> Buscar(Emprestimo obj) {
        // Corpo da consulta
        String consulta = "select e from Emprestimo e";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj.getBem() != null) {
            filtro = " e.bem =: bem";
            parametros.put("bem", obj.getBem());
        }

        if (obj.getDataEmprestimo() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " e.dataEmprestimo =: dataEmprestimo";
            parametros.put("dataEmprestimo", obj.getDataEmprestimo());
        }


        if (obj.getDevolucao() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " e.devolucao =: devolucao";
            parametros.put("devolucao", obj.getDevolucao());
        }

        if (obj.getFuncionario() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " e.funcionario =: funcionario";
            parametros.put("funcionario", obj.getFuncionario());
        }

        if (obj.getId() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " e.id =: id";
            parametros.put("id", obj.getId());
        }

        if (obj.getLocal() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " e.local =: local";
            parametros.put("local", obj.getLocal());
        }

        if (obj.getPrevisaoDevolucao() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " e.previsaoDevolucao=: previsaoDevolucao";
            parametros.put("previsaoDevolucao", obj.getPrevisaoDevolucao());
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
