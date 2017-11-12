package br.com.adin.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.adin.tag.model.UrlsToTrack;

public interface UrlsToTrackRepository extends JpaRepository<UrlsToTrack, String> {

	@Query("select u from UrlsToTrack u where trackerConfiguration.id = :idTrack")
	List<UrlsToTrack> listarUrls(@Param(value = "idTrack") String idTrack);

	@Transactional
	@Modifying
	@Query("delete from UrlsToTrack u where trackerConfiguration.id = :idTrack")
	void deletarUrl(@Param(value = "idTrack") String idTrack);


	
}
