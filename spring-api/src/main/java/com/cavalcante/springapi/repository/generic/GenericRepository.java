package com.cavalcante.springapi.repository.generic;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cavalcante.springapi.model.generic.GenericModel;

/**
 * @author Paulo Eduardo
 * @date 12/04/20
 * @version 0.0.1
 */

public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Serializable> {

}