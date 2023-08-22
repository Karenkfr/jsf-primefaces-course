package erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import erp.model.Empresa;
import erp.model.RamoAtividade;
import erp.model.TipoEmpresa;

public class CamadaPersistencia {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jsf");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//declarando os repositórios
		RamoAtividadesRepository ramoAtividadesRepository = new RamoAtividadesRepository(em);
		EmpresasRepository empresasRepository = new EmpresasRepository(em);
		
		
		//Buscando as informações do banco
		List<RamoAtividade> listaDeRamoAtividades = ramoAtividadesRepository.pesquisar("");
		List<Empresa> listaDeEmpresas = empresasRepository.pesquisar("");
		
		System.out.println(listaDeEmpresas);
		
		
		//Criando uma empresa
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("João da Silva");
		empresa.setCnpj("41.952.519/0001-77");
		empresa.setRazaoSocial("João da Silva 41952519000177");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaDeRamoAtividades.get(0));
		
		
		//Salvando a empresa
		empresasRepository.guardar(empresa);
		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Empresa> listaDeEmpresas2 = empresasRepository.pesquisar("");
		System.out.println(listaDeEmpresas2);
		
		
		
	}
	
	
	

}
