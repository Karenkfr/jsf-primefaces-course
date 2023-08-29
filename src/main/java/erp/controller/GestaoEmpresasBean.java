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
import erp.service.CadastroEmpresaService;
import erp.util.FacesMensages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresasRepository empresasRepository;

	@Inject
	private FacesMensages facesMensages;

	@Inject
	private RamoAtividadesRepository ramoAtividadesRepository;

	@Inject
	private CadastroEmpresaService cadastroEmpresaService;

	private List<Empresa> listaEmpresas;

	private String termoPesquisa;

	private Converter ramoAtividadeConverter;

	private Empresa empresa;

	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}

	public void salvar() {
		cadastroEmpresaService.salvar(empresa);

		if (jaHouvePesquisa()) {
			pesquisar();
		}

		facesMensages.info("Empresa cadastrada com sucesso!");
	}

	public void pesquisar() {
		listaEmpresas = empresasRepository.pesquisar(termoPesquisa);

		if (listaEmpresas.isEmpty()) {
			facesMensages.info("Sua consulta não retornou registros.");
		}
	}

	public void todasEmpresas() {
		//listaEmpresas = empresasRepository.todas();
	}

	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> listaRamoAtividades = ramoAtividadesRepository.pesquisar(termo);

		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);

		return listaRamoAtividades;
	}

	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
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

	public Empresa getEmpresa() {
		return empresa;
	}

}