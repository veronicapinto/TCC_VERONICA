/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ITipoFuncionarioRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.TipoFuncionario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author veronica
 */
@Named(value = "tipoFuncionarioController")
@SessionScoped
public class TipoFuncionarioController implements Serializable {

    TipoFuncionario entidade;
    TipoFuncionario filtro;
    List<TipoFuncionario> listagem;
    @EJB
    ITipoFuncionarioRepositorio dao;

    /**
     * Creates a new instance of TipoFuncionarioController
     */
    public TipoFuncionarioController() {
        entidade = new TipoFuncionario();
        filtro = new TipoFuncionario();
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
        exibirMensagem("Salvo com Sucesso!");
    }

    public String editar() {
        return "TipoFuncionarioEditar.xhtml";
    }

    public String criar() {
        entidade = new TipoFuncionario();
        return "TipoFuncionarioEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "TipoFuncionarioListagem.xhtml";
    }

    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "TipoFuncionarioListagem";
    }

    public String voltar() {
        listagem =null;
        return "TipoFuncionarioListagem.xhtml";
    }

    public TipoFuncionario getEntidade() {
        return entidade;
    }

    public void setEntidade(TipoFuncionario entidade) {
        this.entidade = entidade;
    }

    public List<TipoFuncionario> getListagem() {
        if (listagem == null) {
            TipoFuncionario filtro = new TipoFuncionario();
            listagem = dao.Buscar(filtro);
        }
        return listagem;
    }

    public void setListagem(List<TipoFuncionario> listagem) {
        this.listagem = listagem;
    }

    public TipoFuncionario getFiltro() {
        return filtro;
    }

    public void setFiltro(TipoFuncionario filtro) {
        this.filtro = filtro;
    }
}
