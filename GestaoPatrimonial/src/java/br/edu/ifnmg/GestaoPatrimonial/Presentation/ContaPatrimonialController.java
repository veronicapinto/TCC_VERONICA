/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IContaPatrimonialRepositorio;
import com.sun.org.apache.bcel.internal.generic.RETURN;
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
        return "ContaPatrimonialEditar.xhtml";
    }

    public String criar() {
        entidade = new ContaPatrimonial();
        return "ContaPatrimonialEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ContaPatrimonialListagem.xhtml";
    }

    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ContaPatrimonialListagem.xhtml";

    }

    public String voltar() {
        listagem = null;
        return "ContaPatrimonialListagem.xhtml";
    }

    public ContaPatrimonial getEntidade() {
        return entidade;
    }

    public void setEntidade(ContaPatrimonial entidade) {
        this.entidade = entidade;
    }

    public List<ContaPatrimonial> getListagem() {
        if (listagem == null) {
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
