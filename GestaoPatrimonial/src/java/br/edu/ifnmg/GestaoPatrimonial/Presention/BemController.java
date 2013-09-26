/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presention;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.BemPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IBemPatrimonialRepositorio;
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
    
    @EJB
    IBemPatrimonialRepositorio dao;
    
    /**
     * Creates a new instance of BemController
     */
    public BemController() {
        entidade = new BemPatrimonial();
        filtro = new BemPatrimonial();
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
        return "BemEditar.xhtml";
    }
    
    public String criar(){
        entidade = new BemPatrimonial();
        return "BemEditar.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "BemListagem.xhtml";
    }
    
    public String filtrar(){
        listagem = dao.Buscar(filtro);
        return "BemListagem.xhtml";
    }
    
    public String voltar(){
        return "BemListagem.xhtml";
    }
    
    //GETS E SETS...

    public BemPatrimonial getEntidade() {
        return entidade;
    }

    public void setEntidade(BemPatrimonial entidade) {
        this.entidade = entidade;
    }
    
     public List<BemPatrimonial> getListagem() {
         if(listagem == null){
             BemPatrimonial filtro = new BemPatrimonial();
             listagem = dao.Buscar(filtro);
         }
        return listagem;
    }

    public void setListagem(List<BemPatrimonial> listagem) {
        this.listagem = listagem;
    }    

    public BemPatrimonial getFiltro() {
        return filtro;
    }

    public void setFiltro(BemPatrimonial filtro) {
        this.filtro = filtro;
    }

   
    
    
    
}
