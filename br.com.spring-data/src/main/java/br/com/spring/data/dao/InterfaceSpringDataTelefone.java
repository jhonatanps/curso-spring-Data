package br.com.spring.data.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.data.model.TelefoneSpringData;

@Repository
public interface InterfaceSpringDataTelefone extends CrudRepository<TelefoneSpringData, Long> {

}
