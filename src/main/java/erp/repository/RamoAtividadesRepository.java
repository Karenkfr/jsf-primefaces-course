package erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import erp.model.RamoAtividade;

public class RamoAtividadesRepository implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public RamoAtividadesRepository() {
		
	}
	
	public RamoAtividadesRepository(EntityManager entityManager) {
		
	}
	
	public List<RamoAtividade> pesquisar(String descricao){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
		
		TypedQuery<RamoAtividade> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
		
	}
	

}
