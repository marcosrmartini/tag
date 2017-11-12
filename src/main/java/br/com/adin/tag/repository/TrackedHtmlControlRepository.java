package br.com.adin.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.adin.tag.model.TrackedHtmlControl;

public interface TrackedHtmlControlRepository extends JpaRepository<br.com.adin.tag.model.TrackedHtmlControl, String>{

	@Query("select t from TrackedHtmlControl t where trackerConfiguration.id = :idTrack")
	List<TrackedHtmlControl> listar(@Param(value = "idTrack") String idTrack);
	

}
