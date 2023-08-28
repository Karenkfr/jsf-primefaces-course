package erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import erp.model.Empresa;
import erp.model.RamoAtividade;
import erp.model.TipoEmpresa;
import erp.repository.EmpresasRepository;
import erp.repository.RamoAtividadesRepository;
import erp.util.FacesMensages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresasRepository empresas;

	@Inject
	private RamoAtividadesRepository ramoAtividadesRepository;

	private List<Empresa> listaEmpresas;

	private String termoPesquisa;

	private Converter ramoAtividadeConverter;

	@Inject
	private FacesMensages facesMensages;

	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);

		if (listaEmpresas.isEmpty()) {
			facesMensages.info("Sua consulta não retornou registros.");

		}
	}

	public void todasEmpresas() {
		// listaEmpresas = empresas.todas();
	}

	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> listaRamoAtividades = ramoAtividadesRepository.pesquisar(termo);

		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);

		return listaRamoAtividades;
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

	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
}