package erp.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import erp.model.Empresa;
import erp.repository.EmpresasRepository;


@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private EmpresasRepository empresas;
    
    private List<Empresa> listaEmpresas;
    
    public void todasEmpresas() {
        //listaEmpresas = empresas.todas();
    }
    
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
}