package br.com.kroton.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.kroton.jpa.CursoEntity;
import br.com.kroton.resources.impl.GeneralResouceImpl;

@Path("curso")
public class CursoService extends GeneralResouceImpl<CursoEntity> {

	public CursoService() {
		super(CursoEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	@GET @Path("/filter/{filter}") @Produces(MediaType.APPLICATION_JSON)
	public CursoEntity getByFilter(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
