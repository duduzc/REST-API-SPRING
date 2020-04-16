package com.cavalcante.springapi.resource.generic;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<T> create(@Valid @RequestBody T entity, HttpServletResponse response) { 
		T entitySave = genericRepository.save(entity);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(entitySave.getId()).toUri();
		
		return ResponseEntity.created(uri).body(entitySave);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<T> getById(@PathVariable(value = "id") long id) { 
		T entity = genericRepository.findById(id).orElse(null);
		return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
	}
	
}