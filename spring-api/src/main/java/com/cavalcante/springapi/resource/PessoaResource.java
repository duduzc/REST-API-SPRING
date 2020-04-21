package com.cavalcante.springapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cavalcante.springapi.model.Pessoa;
import com.cavalcante.springapi.resource.generic.GenericResource;
import com.cavalcante.springapi.service.PessoaService;

/**
 * @author Paulo Eduardo
 * @date 16/04/20
 * @version 0.0.1
 */

@RestController
@RequestMapping("/pessoa")
public class PessoaResource extends GenericResource<Pessoa>{
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(value = "/{id}/ativo", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePropertieActive(@RequestBody Boolean ativo, @PathVariable Long id) {
		pessoaService.updatePropertyActive(ativo, id);	
	}
}