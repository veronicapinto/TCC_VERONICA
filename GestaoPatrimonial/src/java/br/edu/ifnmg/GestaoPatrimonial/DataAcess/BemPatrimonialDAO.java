/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.BemPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IBemPatrimonialRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author veronica
 */
@Stateless(name = "IBemPatrimonialRepositorio")
public class BemPatrimonialDAO
        extends DAOGenerico<BemPatrimonial>
        implements IBemPatrimonialRepositorio {

    public BemPatrimonialDAO() {
        super(BemPatrimonial.class);
    }

    @Override
    public List<BemPatrimonial> Buscar(BemPatrimonial obj) {

        // Corpo da consulta
        String consulta = "select b from BemPatrimonial b";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if(obj!=null)
            
        if (obj.getConta() != null && obj.getConta().toString().length() > 0) {
            filtro += " b.conta =: conta";
            parametros.put("conta", obj.getConta());
        }

        if (obj.getDescricao() != null && obj.getDescricao().length() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.descricao =:descricao ";
            parametros.put("descricao", obj.getDescricao());
        }


        if (obj.getEstadoCons() != null && obj.getEstadoCons().toString().length() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.estadoCons =:estadoCons";
            parametros.put("estadoCons", obj.getEstadoCons());
        }

        if (obj.getFuncionario() != null && obj.getFuncionario().toString().length() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.funcionario =:funcionario";
            parametros.put("funcionario", obj.getFuncionario());
        }

        if (obj.getId() != null && obj.getId() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.id =:id ";
            parametros.put("id", obj.getId());
        }

        if (obj.getLocal() != null && obj.getLocal().toString().length() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.local =:local";
            parametros.put("local", obj.getLocal());
        }

        if (obj.getQuantidade() != null && obj.getQuantidade() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.quantidade=: quantidade";
            parametros.put("quantidade", obj.getQuantidade());
        }
        if (obj.getTipo() != null && obj.getTipo().toString().length() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.tipo =:tipo";
            parametros.put("tipo", obj.getTipo());
        }

        if (obj.getUnidade() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.unidade =:unidade";
            parametros.put("unidade", obj.getUnidade());
        }
        if (obj.getValor() != 0 && obj.getValor() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.valor =:valor";
            parametros.put("valor", obj.getValor());
        }


        if (obj.getData() != null && obj.getData().toString().length() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.data =:data";
            parametros.put("data", obj.getData());
        }

        if (obj.getDataAquisicao() != null && obj.getDataAquisicao().toString().length() > 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro += " b.dataAquisicao =:dataAquisicao ";
            parametros.put("dataAquisicao", obj.getDataAquisicao());
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