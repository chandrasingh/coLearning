package com.imaginea.colearn.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAOInterfaceImpl<T, P extends Serializable> implements DAOInteface<T, P>{
	
	
	HibernateTemplate hibernateTempl = new HibernateTemplate();		
	protected String entityName; 

	@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTempl = new HibernateTemplate(sessionFactory);
    }
	
	public P save(T newEntity) {
		return (P) hibernateTempl.save(newEntity);
	}

	public T getOnPk(P id) {
		return (T) hibernateTempl.load(entityName, id);		
	}

	public T getOnMultipleParams(List<String> lsQueryParamName, List<Long> lsQueryValues){
		StringBuilder strQuery = new StringBuilder("from "+entityName+" entity where ");
		for(int k=0; k < lsQueryParamName.size(); k++){
			strQuery.append(" entity."+lsQueryParamName.get(k)+" = " +lsQueryValues.get(k)+" and ");
		}
		strQuery.delete(strQuery.length()-5, strQuery.length());
		List<T> lsResObj = hibernateTempl.find(strQuery.toString());
		if(lsResObj == null || lsResObj.isEmpty() || lsResObj.size()>1){
			return null;
		}else
			return (T) hibernateTempl.find(strQuery.toString()).get(0);		
	}
	
	public List<T> getAsLsOnPk(String queryParamName, Object queryParamVal) {
		return hibernateTempl.find("from "+entityName+" entity where entity." + queryParamName + " = '" +queryParamVal+ "'");
		
	}

	public List<T> getAllAsLs() {
		return hibernateTempl.find("from "+entityName+" entity ");
	}

	public void update(T inputEntity) {
		hibernateTempl.update(inputEntity);		
	}

	public void delete(T inputEntity) {
		hibernateTempl.delete(inputEntity);		
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
}
