package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {


	public Integer saveWhUserType(WhUserType whUserType);
	public void updateWhUserType(WhUserType whUserType);
	public void deleteWhUserType(Integer whUserTypeId);

	public WhUserType getOneWhUserType(Integer whUserTypeId);
	public List<WhUserType> getAllWhUserTypes();

	public List<Object[]> getWhUserTypeCount();
	

}
