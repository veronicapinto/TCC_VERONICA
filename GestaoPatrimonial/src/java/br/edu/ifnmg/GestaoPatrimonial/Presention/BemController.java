/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presention;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.BemPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.EstadoConservacao;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Funcionario;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IBemPatrimonialRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IContaPatrimonialRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IFuncionarioRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ILocalRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Local;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Unidade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author veronica
 */
@Named(value = "bemController")
@SessionScoped
public class BemController implements Serializable {

    
    BemPatrimonial entidade;
    
    BemPatrimonial filtro;
    
    List<BemPatrimonial> listagem;
    
    List<ContaPatrimonial> listagemcontas;
    List<Funcionario> listagemfuncionarios;
    List<Local> listagemlocais;
    
    Unidade[] listagemUnidades;
    EstadoConservacao[] listagemEstadosC;
    
    @EJB
    IBemPatrimonialRepositorio dao;    
    
    @EJB
    IContaPatrimonialRepositorio daoConta;    
    
    @EJB
    IFuncionarioRepositorio daoFuncionario;
    
    @EJB
    ILocalRepositorio daoLocal;
    
    
    
    /**
     * Creates a new instance of BemController
     */
    public BemController() {
        entidade = new BemPatrimonial();
        filtro = new BemPatrimonial();
        listagemUnidades = Unidade.values();
        listagemEstadosC = EstadoConservacao.values();
    }

    public void validarEspacoBranco(FacesContext contexto, UIComponent componente, Object valor) {
        String valorString = (String) valor;
        if (valorString.trim().equals("")) {
            ((UIInput) componente).setValid(false);
            String mensagem = componente.getAttributes().get("label")
                    + ":Valor Inválido, preencha com cracteres diferentes de espaço. ";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
            contexto.addMessage(componente.getClientId(contexto), facesMessage);
        }
    }

    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    public void salvar() {
        dao.Salvar(entidade);
        listagem = null;
        exibirMensagem("Salvo com Sucesso!");

    }

    public String editar() {
        return "BemEditar.xhtml";
    }

    public String criar() {
        entidade = new BemPatrimonial();
        return "BemEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "BemListagem.xhtml";
    }

    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "BemListagem.xhtml";
    }

    public String voltar() {
        listagem = null;
        return "BemListagem.xhtml";
    }

    //GETS E SETS...
    public BemPatrimonial getEntidade() {
        return entidade;
    }

    public void setEntidade(BemPatrimonial entidade) {
        this.entidade = entidade;
    }
    
     public BemPatrimonial getFiltro() {
        return filtro;
    }

    public void setFiltro(BemPatrimonial filtro) {
        this.filtro = filtro;
    }
    public List<BemPatrimonial> getListagem() {
        if (listagem == null) {
            BemPatrimonial filtro = new BemPatrimonial();
            listagem = dao.Buscar(filtro);
        }
        return listagem;
    }

    public void setListagem(List<BemPatrimonial> listagem) {
        this.listagem = listagem;
    }

    public List<Funcionario> getListagemfuncionarios() {
        if (listagemfuncionarios == null) {
            BemPatrimonial filtro = new BemPatrimonial();
            listagemfuncionarios = daoFuncionario.Buscar(null);
        }
        
        return listagemfuncionarios;
    }

    public void setListagemfuncionarios(List<Funcionario> listagemfuncionarios) {
        this.listagemfuncionarios = listagemfuncionarios;
    }

    public List<ContaPatrimonial> getListagemcontas() {
        if (listagemcontas == null) {
            BemPatrimonial filtro = new BemPatrimonial();
            listagemcontas = daoConta.Buscar(null);
        }
        return listagemcontas;
    }

    public void setListagemcontas(List<ContaPatrimonial> listagemcontas) {
        this.listagemcontas = listagemcontas;
    }

    public List<Local> getListagemlocais() {
        return listagemlocais;
    }

    public void setListagemlocais(List<Local> listagemlocais) {
        this.listagemlocais = listagemlocais;
    }
    
    
    
    
    

      //GET e SET das enumerações...
    public Unidade[] getListagemUnidades() {
        if (listagemUnidades == null) {
            listagemUnidades = Unidade.values();
        }
        return listagemUnidades;
    }

    public void setListagemUnidades(Unidade[] listagemUnidades) {
        this.listagemUnidades = listagemUnidades;
    }

    public EstadoConservacao[] getListagemEstadosC() {
        if (listagemEstadosC == null) {
            listagemEstadosC = EstadoConservacao.values();
        }
        return listagemEstadosC;
    }

    public void setListagemEstadosC(EstadoConservacao[] listagemEstadosC) {
        this.listagemEstadosC = listagemEstadosC;
    }

   
}
