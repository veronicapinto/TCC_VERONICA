/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presention;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ContaPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Funcionario;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IFuncionarioRepositorio;
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
@Named(value = "funcionarioController")
@SessionScoped
public class FuncionarioController implements Serializable {

    Funcionario entidade;
    Funcionario filtro;
    List<Funcionario> listagem;
    @EJB
    IFuncionarioRepositorio dao;

    /**
     * Creates a new instance of FuncionarioController
     */
    public FuncionarioController() {
        entidade = new Funcionario();
        filtro = new Funcionario();
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
        return "FuncionarioEditar.xhtml";
    }

    public String criar() {
        entidade = new Funcionario();
        return "FuncionarioEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "FuncionarioListagem.xhtml";
    }

    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "FuncionarioListagem.xhtml";
    }

    public String voltar() {
        return "FuncionarioListagem.xhtml";
    }

    public Funcionario getEntidade() {
        return entidade;
    }

    public void setEntidade(Funcionario entidade) {
        this.entidade = entidade;
    }

    public List<Funcionario> getListagem() {
        if (listagem == null) {
            Funcionario filtro = new Funcionario();
            listagem = dao.Buscar(filtro);
        }
        return listagem;
    }

    public void setListagem(List<Funcionario> listagem) {
        this.listagem = listagem;
    }

    public Funcionario getFiltro() {
        return filtro;
    }

    public void setFiltro(Funcionario filtro) {
        this.filtro = filtro;
    }
}
