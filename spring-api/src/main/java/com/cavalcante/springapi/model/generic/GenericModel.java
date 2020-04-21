package com.cavalcante.springapi.model.generic;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Paulo Eduardo
 * @date 12/04/20
 * @version 0.0.1
 */

@MappedSuperclass
@SuppressWarnings("serial")
public class GenericModel implements Serializable {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Basic(optional = false)  
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT")  
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericModel other = (GenericModel) obj;
		if (id != other.id)
			return false;
		return true;
	}
}