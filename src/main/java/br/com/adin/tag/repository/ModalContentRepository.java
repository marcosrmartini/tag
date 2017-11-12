package br.com.adin.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.adin.tag.model.ModalContent;

public interface ModalContentRepository extends JpaRepository<ModalContent, String>{

	@Query("select m from ModalContent m where trackerConfiguration.id = :idTrack")
	List<ModalContent> listar(@Param(value = "idTrack") String idTrack);

	
}
