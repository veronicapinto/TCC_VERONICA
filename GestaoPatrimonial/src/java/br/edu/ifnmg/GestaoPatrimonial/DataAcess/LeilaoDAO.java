/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DataAcess;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.BemPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ILeilaoRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Leilao;
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
@Stateless(name = "ILeilaoRepositorio")
public class LeilaoDAO
        extends DAOGenerico<Leilao>
        implements ILeilaoRepositorio {

    public LeilaoDAO() {
        super(Leilao.class);

    }

    @Override
    public List<Leilao> Buscar(Leilao obj) {

        //corpo da consulta
        String consulta = "select l from Leilao l";
        //A parte Where da consulta
        String filtro = "";

        //Guarda a lista de parametros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getArrematante() != null && obj.getArrematante().length() > 0) {
                filtro += " l.arrematante=:arrematante ";
                parametros.put("arrematante", obj.getArrematante());
            }
            if (obj.getNumeroLeilao() != null && obj.getNumeroLeilao() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " l.numeroLeilao=:numeroLeilao ";
                parametros.put("numeroLeilao", obj.getNumeroLeilao());
            }

            if (obj.getId() != null && obj.getId() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " l.id =:id";
                parametros.put("id", obj.getId());
            }

            if (obj.getDataLeilao() != null && obj.getDataLeilao().toString().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " l.dataLeilao=:dataLeilao";
                parametros.put("dataLeilao", obj.getDataLeilao());
            }

            if (obj.getBensLeiloados() != null) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " l.bensLeiloados=:bensLeiloados";
                parametros.put("bensLeiloados", obj.getBensLeiloados());
            }

            if (obj.getValorBemLeiloado() != 0 && obj.getValorBemLeiloado() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " b.valorBemLeiloado=:valorBemLeiloado";
                parametros.put("valorBemLeiloado", obj.getValorBemLeiloado());
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
