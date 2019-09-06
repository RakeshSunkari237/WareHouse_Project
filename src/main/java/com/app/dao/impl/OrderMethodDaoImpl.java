package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao{


	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		return (Integer) ht.save(orderMethod);
	}

	public void updateOrderMethod(OrderMethod orderMethod) {
		ht.update(orderMethod);
	}

	public void deleteOrderMethod(Integer orderMethodId) {
		ht.delete(new OrderMethod(orderMethodId));
	}

	public OrderMethod getOneOrderMethod(Integer orderMethodId) {
		return ht.get(OrderMethod.class, orderMethodId);
	}

	public List<OrderMethod> getAllOrderMethods() {
		return 	ht.loadAll(OrderMethod.class);
	}

	public List<Object[]> getOrderMethodModeCount() {
		String hql=" select orderMethodMode,count(orderMethodMode) from com.app.model.OrderMethod group by orderMethodMode";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> orderModes = (List<Object[]>) ht.find(hql);
		return orderModes;
	}

}
