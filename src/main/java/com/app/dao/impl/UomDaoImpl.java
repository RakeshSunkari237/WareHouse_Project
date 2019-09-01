package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveUom(Uom uom) {
		return (Integer) ht.save(uom);
	}

	public void updateUom(Uom uom) {
		ht.update(uom);
	}

	public void deleteUom(Integer uomId) {
		ht.delete(new Uom(uomId));
	}

	public Uom getOneUom(Integer uomId) {
		return ht.get(Uom.class, uomId);
	}


	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}

	@SuppressWarnings("deprecation")
	public List<Object[]> getUomTypeCount() {
		String hql=" select uomType,count(uomType) from "
						+Uom.class.getName()+
						" group by uomType ";
		@SuppressWarnings("unchecked")
		List<Object[]> uomTypes = (List<Object[]>) ht.find(hql);
		return uomTypes;
	}

}
