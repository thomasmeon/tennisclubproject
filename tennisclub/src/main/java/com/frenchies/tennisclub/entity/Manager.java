package com.frenchies.tennisclub.entity;


import javax.persistence.Entity;
import javax.persistence.Table;


/* CLASS MANAGER */

@Entity
@Table(name="Manager")
public class Manager extends People {
		
	
	//METHODE DE MANAGER
	
		
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof Manager)) {
            return false;
        }

        final Manager other = (Manager) o;

        if ((getMail() == null) ? (other.getMail() != null) : !getMail().equals(other.getMail())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int result = 1;
        result = prime * result + ((getMail() == null) ? 0 : getMail().hashCode());
        return result;
    }		
	
}
