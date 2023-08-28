package erp.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import erp.model.Empresa;
import erp.repository.EmpresasRepository;
import erp.util.FacesMensages;


@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private EmpresasRepository empresas;
    
    private List<Empresa> listaEmpresas;
    
    private String termoPesquisa;
    
    @Inject
    private FacesMensages facesMensages;
    
    public void pesquisar() {
    	listaEmpresas = empresas.pesquisar(termoPesquisa);
    	
    	if(listaEmpresas.isEmpty()) {
    		facesMensages.info("Sua consulta não retornou registros.");
    		
    	}
    }
    
    public void todasEmpresas() {
        //listaEmpresas = empresas.todas();
    }
    
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
    
    public String getTermoPesquisa() {
		return termoPesquisa;
	}
    public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
}