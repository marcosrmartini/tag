package br.com.adin.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.adin.tag.model.UserTrackingConfiguration;

public interface UserTrackingConfigurationRepository extends JpaRepository<UserTrackingConfiguration, String>{

	@Query("select u from UserTrackingConfiguration u where trackerConfiguration.id = :idTrack")
	List<UserTrackingConfiguration> listar(@Param(value = "idTrack") String idTrack);

	@Query("select u from UserTrackingConfiguration u where trackerConfiguration.id = :idTrack")
	UserTrackingConfiguration Pesquisar(@Param(value = "idTrack") String idTrack);

	
}
