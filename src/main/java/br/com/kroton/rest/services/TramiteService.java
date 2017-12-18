package br.com.kroton.rest.services;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.kroton.dao.generic.TramiteDAO;
import br.com.kroton.jpa.TramiteEntity;
import br.com.kroton.resources.impl.GeneralResouceImpl;

@Path("tramite")
public class TramiteService extends GeneralResouceImpl<TramiteEntity> {

	public TramiteService() {
		super(TramiteEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	@GET @Path("/filter/{filter}") @Produces(MediaType.APPLICATION_JSON)
	public TramiteEntity getByFilter(@PathParam("filter") String filter) {
		return null;
	}
	
	@GET @Path("/filterBySolicitacao/{filter}") @Produces(MediaType.APPLICATION_JSON)
	public List<TramiteEntity> getBySolicitacaoFilter(@PathParam("filter") String filter) {
		TramiteDAO tDAO = new TramiteDAO();
		return tDAO.filter(new BigInteger(filter));
	}


}
