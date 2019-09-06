package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveWhUserType(WhUserType whUserType) {
		return (Integer) ht.save(whUserType) ;
	}

	public void updateWhUserType(WhUserType whUserType) {
		ht.update(whUserType);
	}

	public void deleteWhUserType(Integer whUserTypeId) {
		ht.delete(new WhUserType(whUserTypeId));
	}

	public WhUserType getOneWhUserType(Integer whUserTypeId) {
		return ht.get(WhUserType.class, whUserTypeId);
	}

	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	@SuppressWarnings("deprecation")
	public List<Object[]> getWhUserTypeCount() {

		String hql=  " select whUserFor,count(whUserFor) from "
				+ WhUserType.class.getName()
				+ " group by whUserFor";
		List<Object[]> whUserTypes = (List<Object[]>) ht.find(hql);

		return whUserTypes;
	}

	

}
