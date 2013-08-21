package com.imaginea.colearn.dao;

import java.io.Serializable;
import java.util.List;

public interface DAOInteface<T extends Object,P extends Serializable> {
	
	public P save(T newEntity);
	public T getOnPk(P id);
	public List<T> getAsLsOnPk(String queryParamName, Object queryParamVal);
	public List<T> getAllAsLs();
	public void update(T inputEntity);
	public void delete(T inputEntity);
	
}
