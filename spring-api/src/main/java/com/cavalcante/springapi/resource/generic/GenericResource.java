package com.cavalcante.springapi.resource.generic;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cavalcante.springapi.event.ResourceCreatedEvent;
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
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<T> listAll() {
		return genericRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<T> create(@Valid @RequestBody T entity, HttpServletResponse response) { 
		T entitySave = genericRepository.save(entity);	
		publisher.publishEvent(new ResourceCreatedEvent(this, response, entitySave.getId()));		
		return ResponseEntity.status(HttpStatus.CREATED).body(entitySave);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<T> getById(@PathVariable(value = "id") long id) { 
		T entity = genericRepository.findById(id).orElse(null);
		return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") long id){
		genericRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<T> update (@Valid @RequestBody T entity, @PathVariable(value = "id") long id){
		T entitySave = genericRepository.findById(id).orElse(null);
		if(entitySave == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, entitySave, "id");
		genericRepository.save(entitySave);	
		
		return ResponseEntity.ok(entitySave);
	}
}