package br.com.adin.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.adin.tag.model.UserTrackingConfigurationTriggerButton;

public interface UserTrackingConfigurationTriggerButtonRepository extends JpaRepository<UserTrackingConfigurationTriggerButton, String> {

	
	@Query("select u from UserTrackingConfigurationTriggerButton u where u.userTrackingConfiguration.id = :idUserTrack")
	List<UserTrackingConfigurationTriggerButton> listar(@Param(value = "idUserTrack") String idTrack);

	@Transactional
	@Modifying
	@Query("delete from UserTrackingConfigurationTriggerButton u where u.userTrackingConfiguration.id = :idTrack")
	void deletar(@Param(value = "idTrack") String idTrack);

}
