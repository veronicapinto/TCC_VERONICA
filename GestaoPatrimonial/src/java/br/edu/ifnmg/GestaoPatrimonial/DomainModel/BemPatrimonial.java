/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author veronica
 */
@Entity
public class BemPatrimonial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private ContaPatrimonial conta;
    @ManyToOne
    private Local local;
    @ManyToOne
    private Funcionario funcionarioBaixa;
    @ManyToOne
    Leilao leilao;
    private String descricao;
    private double valor;
    private Integer quantidade;
    private boolean Ativo;
    @Enumerated(EnumType.ORDINAL)
    private Unidade unidade;
    @Enumerated(EnumType.ORDINAL)
    private TipoAquisicao tipo;
    @Enumerated(EnumType.ORDINAL)
    private EstadoConservacao estadoCons;
    @Enumerated(EnumType.ORDINAL)
    private MotivoBaixa motivo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAquisicao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataBaixa;

//Getts e Setts...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ContaPatrimonial getConta() {
        return conta;
    }

    public void setConta(ContaPatrimonial conta) {
        this.conta = conta;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Funcionario getFuncionarioBaixa() {
        return funcionarioBaixa;
    }

    public void setFuncionarioBaixa(Funcionario funcionarioBaixa) {
        this.funcionarioBaixa = funcionarioBaixa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public void setAtivo(boolean Ativo) {
        this.Ativo = Ativo;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public TipoAquisicao getTipo() {
        return tipo;
    }

    public void setTipo(TipoAquisicao tipo) {
        this.tipo = tipo;
    }

    public EstadoConservacao getEstadoCons() {
        return estadoCons;
    }

    public void setEstadoCons(EstadoConservacao estadoCons) {
        this.estadoCons = estadoCons;
    }

    public MotivoBaixa getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoBaixa motivo) {
        this.motivo = motivo;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
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
        if (!(object instanceof BemPatrimonial)) {
            return false;
        }
        BemPatrimonial other = (BemPatrimonial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.GestaoPatrimonial.DomainModel.Bem[ id=" + id + " ]";
    }
}
