package br.com.kroton.dao.generic;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import br.com.kroton.jpa.TramiteEntity;

public class TramiteDAO extends GenericDAO<TramiteEntity> {

	public TramiteDAO() {
		super(TramiteEntity.class);
	}
	
	public List<TramiteEntity> filter(BigInteger solicitacao){
		Query query = em.createQuery("FROM TramiteEntity t INNER JOIN FETCH t.usuario WHERE t.solicitacao.id = ?1");
		query.setParameter(1, solicitacao);
		@SuppressWarnings("unchecked")
		List<TramiteEntity> result = query.getResultList();
		return result;
	}

}
