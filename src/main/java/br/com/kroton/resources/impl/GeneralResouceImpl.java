package br.com.kroton.resources.impl;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.kroton.dao.generic.GenericDAO;
import br.com.kroton.resources.GeneralResource;

public abstract class GeneralResouceImpl<T> implements GeneralResource<T> {
	
	public final Class<T> entityClass;
	
	@GET @Path("/filter/{filter}") @Produces(MediaType.APPLICATION_JSON)
	public abstract T getByFilter(@PathParam("filter") String filter);
	
	public GeneralResouceImpl(Class<T> entityClass) {
		this.entityClass= entityClass;
	}

	@GET @Path("/{id}") @Produces(MediaType.APPLICATION_JSON) 
	@Override
	public T getById(@PathParam("id") Integer id) {
		return new GenericDAO<T>(entityClass).getById(id);
	}

	@GET @Produces(MediaType.APPLICATION_JSON) 
	@Override
	public List<T> getAll() {
		return new GenericDAO<T>(entityClass).getAll();
	}

	@POST @Produces(MediaType.APPLICATION_JSON) 
	@Override
	public T add(T entity) {
		return new GenericDAO<T>(entityClass).insert(entity);
	}

	@DELETE @Path("/delete/{id}") @Produces(MediaType.APPLICATION_JSON)
	@Override
	public void delete(@PathParam("id") Integer id) {
		new GenericDAO<T>(entityClass).removeById(id);
	}

	@PUT @Produces(MediaType.APPLICATION_JSON) 
	@Override
	public T update(T entity) {
		return new GenericDAO<T>(entityClass).update(entity);
	}

}
