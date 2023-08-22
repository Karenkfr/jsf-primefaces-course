package erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import erp.model.Empresa;
import erp.repository.EmpresasRepository;
import erp.util.Transacional;

public class CadastroEmpresaService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresasRepository empresasRepository;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresasRepository.guardar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresasRepository.remover(empresa);
	}

}
