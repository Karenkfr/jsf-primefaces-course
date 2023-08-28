package erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import erp.model.Empresa;



public class EmpresasRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public EmpresasRepository() {

	}

	public EmpresasRepository(EntityManager manager) {
		this.entityManager = manager;
	}

	public EmpresasRepository porId(Long id) {
		return entityManager.find(EmpresasRepository.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
		String jpql = "from Empresa where razaoSocial like :razaoSocial";
		
		TypedQuery<Empresa> query = entityManager
				.createQuery(jpql, Empresa.class);
		
		query.setParameter("razaoSocial", nome + "%");
		
		return query.getResultList();
	}
	
	public List<Empresa> todas() {
         return entityManager.createQuery("from Empresa", Empresa.class).getResultList();
    }

	public Empresa guardar(Empresa empresa) {
		return entityManager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		
	}
}