package com.cavalcante.springapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cavalcante.springapi.model.Pessoa;
import com.cavalcante.springapi.repository.PessoaRepository;

/**
 * @author Paulo Eduardo
 * @date 20/04/20
 * @version 0.0.1
 */

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public void updatePropertyActive(Boolean ativo, Long id) {
		Pessoa pessoaSalva = findById(id);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}
	
	private Pessoa findById(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findById(id).orElse(null);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}
}