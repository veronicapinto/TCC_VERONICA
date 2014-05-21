/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DomainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author veronica
 */
@Entity
public class Leilao implements Entidade, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numeroLeilao;
    
    @OneToMany(mappedBy = "leilao", fetch= FetchType.EAGER)
    private List<BemPatrimonial> bensLeiloados;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLeilao;
    private double valorTotal;
    private String arrematante;
    private String observacoes;

       public void add(BemPatrimonial bem) {
        if (!bensLeiloados.contains(bem)) {
            bensLeiloados.add(bem);
        }
        valorTotal = valorTotal + bem.getValor();
    }

    public void remove(BemPatrimonial bem) {
        if (bensLeiloados.contains(bem)) {
            bensLeiloados.remove(bem);
        }
        valorTotal = valorTotal - bem.getValor();


    }
    
    public Leilao(){
        bensLeiloados = new ArrayList<BemPatrimonial>();
    }
    
    //GETS E SETS...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroLeilao() {
        return numeroLeilao;
    }

    public void setNumeroLeilao(Integer numeroLeilao) {
        this.numeroLeilao = numeroLeilao;
    }

    public List<BemPatrimonial> getBensLeiloados() {
        return bensLeiloados;
    }

    public void setBensLeiloados(List<BemPatrimonial> bensLeiloados) {
        this.bensLeiloados = bensLeiloados;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataLeilao() {
        return dataLeilao;
    }

    public void setDataLeilao(Date dataLeilao) {
        this.dataLeilao = dataLeilao;
    }

    public String getArrematante() {
        return arrematante;
    }

    public void setArrematante(String arrematante) {
        this.arrematante = arrematante;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leilao)) {
            return false;
        }
        Leilao other = (Leilao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numeroLeilao.toString();
    }
}
