/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import br.edu.ifnmg.GestaoPatrimonial.DomainModel.BemPatrimonial;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.IBemPatrimonialRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.ILeilaoRepositorio;
import br.edu.ifnmg.GestaoPatrimonial.DomainModel.Leilao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author veronica
 */
@Named(value = "leilaoController")
@SessionScoped
public class LeilaoController implements Serializable {

    Leilao entidade;
    Leilao filtro;
    List<Leilao> listagem;
    List<BemPatrimonial> listagemBensLeiloados;
    @EJB
    ILeilaoRepositorio dao;
    @EJB
    IBemPatrimonialRepositorio daoBemPatrimonial;
    private BemPatrimonial bem;
    

    /**
     * Creates a new instance of LeilaoController
     */
    public LeilaoController() {
        entidade = new Leilao();
        filtro = new Leilao();
      //  bem = new BemPatrimonial();

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
        return "LeilaoEditar.xhtml";
    }

    public String criar() {
        entidade = new Leilao();
        return "LeilaoEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "LeilaoListagem.xhtml";
    }

    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "LeilaoListagem.xhtml";
    }

    public String voltar() {
        listagem = null;
        return "LeilaoListagem.xhtml";
    }
    
    
    // GETS E SETS...

    public Leilao getEntidade() {
        return entidade;
    }

    public void setEntidade(Leilao entidade) {
        this.entidade = entidade;
    }

    public Leilao getFiltro() {
        return filtro;
    }

    public void setFiltro(Leilao filtro) {
        this.filtro = filtro;
    }

    public List<Leilao> getListagem() {
        if (listagem == null) {
            Leilao filtro = new Leilao();
            listagem = dao.Buscar(filtro);
        }
        return listagem;
    }

    public void setListagem(List<Leilao> listagem) {
        this.listagem = listagem;
    }

    public List<BemPatrimonial> getListagemBensLeiloados() {
         if(listagemBensLeiloados == null) {
            BemPatrimonial filtro = new BemPatrimonial();
            listagemBensLeiloados = daoBemPatrimonial.Buscar(null);
         }
        return listagemBensLeiloados;
    }

    public void setListagemBensLeiloados(List<BemPatrimonial> listagemBensLeiloados) {
       
      this.listagemBensLeiloados = listagemBensLeiloados;
    }

    
    
    public ILeilaoRepositorio getDao() {
        return dao;
    }

    public void setDao(ILeilaoRepositorio dao) {
        this.dao = dao;
    }

    public BemPatrimonial getBem() {
        return bem;
    }

    public void setBem(BemPatrimonial bem) {
        this.bem = bem;
    }
    
    
    //
    public void addBem() {
        entidade.add(bem);
        salvar();
        bem = new BemPatrimonial();

    }
    public void removeBem(){
        entidade.remove(bem);
         removeBem();
        
        bem = new BemPatrimonial();
        
    }
        }



    
    
    




