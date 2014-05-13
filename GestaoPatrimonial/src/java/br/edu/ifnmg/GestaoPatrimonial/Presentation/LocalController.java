/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

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

    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    public void salvar() {
        if(entidade.getDescricao().trim().length() == 0){
           exibirMensagem("Valor Inválido, preencha o campo: DESCRIÇÃO com caracteres diferentes de espaço!");
           return;
        }
         if(entidade.getCidade().trim().length() == 0){
           exibirMensagem("Valor Inválido, preencha o campo: CIDADE com caracteres diferentes de espaço!");
           return;
        }
          if(entidade.getEndereco().trim().length() == 0){
           exibirMensagem("Valor Inválido, preencha o campo: ENDEREÇO com caracteres diferentes de espaço!");
           return;
        }
       
        dao.Salvar(entidade);
        listagem = null;
        exibirMensagem("Operação realizada com Sucesso!");
    }

    public String editar() {
        return "LocalEditar.xhtml";

    }

    public String criar() {
        entidade = new Local();
        return "LocalEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com Sucesso!");
        return "LocalEditar.xhtml";
    }

    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "LocalListagem.xhtml";
    }

    public String voltar() {
        listagem = null;
        return "LocalListagem.xhtml";
    }

    public Local getEntidade() {
        return entidade;
    }

    public void setEntidade(Local entidade) {
        this.entidade = entidade;
    }

    public List<Local> getListagem() {
        if (listagem == null) {
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
