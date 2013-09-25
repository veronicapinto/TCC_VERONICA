/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presention;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ILocalRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Local;
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
@Named(value = "localController")
@SessionScoped
public class LocalController implements Serializable {

    Local entidade;
    
    Local filtro;
    
    List<Local> listagem;
    
    @EJB
    ILocalRepositorio dao;

    /**
     * Creates a new instance of LocalController
     */
    public LocalController() {
        entidade = new Local();
        filtro = new Local();
    }

    public void validarEspacoBranco(FacesContext contexto, UIComponent componente, Object valor) {
        String valorString = (String) valor;
        if (valorString.trim().equals("")) {
            ((UIInput) componente).setValid(false);
            String mensagem = componente.getAttributes().get("label")
                    + ":Valor Inválido, preencha com caracteres diferentes de espaço. ";
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
        exibirMensagem("Salvo com Sucesso");
    }

    public String editar() {
        return "LocalEditar.xhtml";

    }
   
   public String criar(){
       entidade = new Local();
       return "LocalEditar.xhtml";
   }
   
   public String apagar(){
       dao.Apagar(entidade);
       listagem = null;
       exibirMensagem("Apagado com Sucesso");
       return "LocalEditar.xhtml";
   }
   
  public String filtrar(){
      listagem = dao.Buscar(filtro);
      return "LocalListagem.xhtml";
  }
  
  public String voltar(){
      return "LocalListagem.xhtml";
  }

    public Local getEntidade() {
        return entidade;
    }

    public void setEntidade(Local entidade) {
        this.entidade = entidade;
    }
    
    public List<Local> getListagem() {
        if(listagem == null){
            Local filtro = new Local();
            listagem = dao.Buscar(filtro);
        }
        return listagem;
    }

    public void setListagem(List<Local> listagem) {
        this.listagem = listagem;
    }

    public Local getFiltro() {
        return filtro;
    }

    public void setFiltro(Local filtro) {
        this.filtro = filtro;
    }
  
  
   
   
}
