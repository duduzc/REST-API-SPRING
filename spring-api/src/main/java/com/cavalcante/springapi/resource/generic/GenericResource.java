package com.cavalcante.springapi.resource.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cavalcante.springapi.model.generic.GenericModel;
import com.cavalcante.springapi.repository.generic.GenericRepository;

/**
 * @author Paulo Eduardo
 * @date 12/04/20
 * @version 0.0.1
 */

public class GenericResource<T extends GenericModel> {
	
	@Autowired
	private GenericRepository<T> genericRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<T> listAll() {
		return genericRepository.findAll();
	}
}