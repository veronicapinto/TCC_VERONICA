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
@Stateless (name="IBemPatrimonialRepositorio")
public class BemPatrimonialDAO
    extends DAOGenerico<BemPatrimonial> 
    implements IBemPatrimonialRepositorio
{
    public BemPatrimonialDAO(){
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
        if (obj.getConta() != null) {
            filtro = " b.conta =: conta";
            parametros.put("conta", obj.getConta());
        }

        if (obj.getData() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.data =: data";
            parametros.put("data", obj.getData());
        }

        if (obj.getDataAquisicao() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.dataAquisicao =: dataAquisicao";
            parametros.put("dataAquisicao", obj.getDataAquisicao());
        }

        if (obj.getDataBaixa() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.dataBaixa =: dataBaixa";
            parametros.put("dataBaixa", obj.getDataBaixa());

        }
        if (obj.getDescricao() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.descricao =: descricao";
            parametros.put("descricao", obj.getDescricao());
        }

        if (obj.getDescricaoBaixa() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.descricaoBaixa =: descricaoBaixa";
            parametros.put("descricaoBaixa", obj.getDescricaoBaixa());
        }

        if (obj.getDescricaoTipoAq() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.descricaoTipoAq =: descricaoTipoAq";
            parametros.put("descricaoTipoAq", obj.getDescricaoTipoAq());
        }


        if (obj.getEstadoCons() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.estadoCons =: estadoCons";
            parametros.put("estadoCons", obj.getEstadoCons());
        }

        if (obj.getFuncionario() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.funcionario =: funcionario";
            parametros.put("funcionario", obj.getFuncionario());
        }

        if (obj.getFuncionarioBaixa() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.funcionarioBaixa =: funcionarioBaixa";
            parametros.put("funcionarioBaixa", obj.getFuncionarioBaixa());
        }


        if (obj.getId() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.id =: id";
            parametros.put("id", obj.getId());
        }

        if (obj.getLocal() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.local =: local";
            parametros.put("local", obj.getLocal());
        }

        if (obj.getMotivo() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.motivo =: motivo";
            parametros.put("motivo", obj.getMotivo());
        }

        if (obj.getQuantidade() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.quantidade =: quantidade";
            parametros.put("quantidade", obj.getQuantidade());
        }
        if (obj.getTipo() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.tipo =: tipo";
            parametros.put("tipo", obj.getTipo());
        }

        if (obj.getUnidade() != null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.unidade =: unidade";
            parametros.put("unidade", obj.getUnidade());
        }
        if (obj.getValor() != 0) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " b.valor =: valor";
            parametros.put("valor", obj.getValor());
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