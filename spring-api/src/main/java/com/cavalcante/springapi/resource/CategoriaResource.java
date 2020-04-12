package com.cavalcante.springapi.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cavalcante.springapi.model.Categoria;
import com.cavalcante.springapi.resource.generic.GenericResource;

/**
 * @author Paulo Eduardo
 * @date 12/04/20
 * @version 0.0.1
 */

@RestController
@RequestMapping("/categoria")
public class CategoriaResource extends GenericResource<Categoria> {

}