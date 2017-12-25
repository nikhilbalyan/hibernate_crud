package org.glassfish.jersey.archetypes.com_mayia.dao;

import java.util.List;

import org.glassfish.jersey.archetypes.com_mayia.pojo.CampusMind;
import org.glassfish.jersey.archetypes.com_mayia.pojo.customexception.StoringException;

public interface CampusMindDAOInterface {
	public boolean add(int num) throws StoringException;

	public List<CampusMind> read(int num);

	public boolean update(int num);

	public boolean delete(int num);

}
