/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presention;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IContaPatrimonialRepositorio;
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
@Named(value = "contaPatrimonialController")
@SessionScoped
public class ContaPatrimonialController implements Serializable {

   
    ContaPatrimonial entidade;
    
    ContaPatrimonial filtro;
    
    List<ContaPatrimonial> listagem;
    @EJB
    IContaPatrimonialRepositorio dao;

    /**
     * Creates a new instance of ContaPatrimonialController
     */
    public ContaPatrimonialController() {
        entidade = new ContaPatrimonial();
        filtro = new ContaPatrimonial();
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
    
    public String editar(){
        return "ContaPatrimonialEditar.xhtml";
    }
    
    public String criar(){
        entidade = new ContaPatrimonial();
        return "ContaPatrimonialEditar.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ContaPatrimonialListagem.xhtml";
    }
    
    public String filtrar(){
        listagem = dao.Buscar(filtro);
        return "ContaPatrimonialListagem.xhtml";
    }
    
    public String voltar(){
        return "ContaPatrimonialListagem.xhtml";
    }

    public ContaPatrimonial getEntidade() {
        return entidade;
    }

    public void setEntidade(ContaPatrimonial entidade) {
        this.entidade = entidade;
    }

    public List<ContaPatrimonial> getListagem() {
        if(listagem == null){
            ContaPatrimonial filtro = new ContaPatrimonial();
            listagem = dao.Buscar(filtro);
        }

        return listagem;
    }

    public void setListagem(List<ContaPatrimonial> listagem) {
        this.listagem = listagem;
    }

    public ContaPatrimonial getFiltro() {
        return filtro;
    }

    public void setFiltro(ContaPatrimonial filtro) {
        this.filtro = filtro;
    }
    
}