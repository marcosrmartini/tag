package br.com.adin.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.adin.tag.model.Customer;

public interface CustomersRepository extends JpaRepository<Customer, String> {

		
	@Query("select c from Customer c where (upper(c.customerName) like :name) or upper(c.publicKey) like :name")
	List<Customer> pesquisaPorNome(@Param(value = "name")  String name);

	@Query("select c from Customer c where (upper(c.customerName) like :name) and (upper(c.publicKey) like :publicKey)")
	Customer pesquisaPorNomePublicKey(@Param(value = "name")  String name, @Param(value = "publicKey")  String publicKey);


}
