package br.com.kroton.resources;

import java.util.List;

public interface GeneralResource<T> {
	
	//métodos de pesquisa
	public T getById(Integer id);
	public List<T> getAll();
	
	//método de criação
	public T add(T entity);
	
	//método de exclusão
	public void delete(Integer id);
	
	//método de atualização
	public T update(T entity);
}
