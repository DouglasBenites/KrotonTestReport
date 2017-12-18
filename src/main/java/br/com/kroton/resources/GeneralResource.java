package br.com.kroton.resources;

import java.util.List;

public interface GeneralResource<T> {
	
	//m�todos de pesquisa
	public T getById(Integer id);
	public List<T> getAll();
	
	//m�todo de cria��o
	public T add(T entity);
	
	//m�todo de exclus�o
	public void delete(Integer id);
	
	//m�todo de atualiza��o
	public T update(T entity);
}
