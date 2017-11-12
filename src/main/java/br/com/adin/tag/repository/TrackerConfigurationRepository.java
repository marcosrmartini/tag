package br.com.adin.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.adin.tag.model.TrackerConfiguration;

public interface TrackerConfigurationRepository extends JpaRepository<TrackerConfiguration, String> {

	@Query("select t from TrackerConfiguration t where customer.id = :idCustomer")
	TrackerConfiguration buscarTracker(@Param(value = "idCustomer") String idCustomer);


}
