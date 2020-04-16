package com.cavalcante.springapi.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cavalcante.springapi.model.Pessoa;
import com.cavalcante.springapi.resource.generic.GenericResource;

/**
 * @author Paulo Eduardo
 * @date 16/04/20
 * @version 0.0.1
 */

@RestController
@RequestMapping("/pessoa")
public class PessoaResource extends GenericResource<Pessoa>{

}