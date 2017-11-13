package br.com.adin.tag.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;



/**
 * The persistent class for the urls_to_track database table.
 * 
 */
@Entity
@Table(name="urls_to_track")
@NamedQuery(name="UrlsToTrack.findAll", query="SELECT u FROM UrlsToTrack u")
public class UrlsToTrack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="urls_to_track")
	private String urlsToTrack;

	//bi-directional many-to-one association to TrackerConfiguration
	@ManyToOne
	@JoinColumn(name="tracker_configuration_id")
	private TrackerConfiguration trackerConfiguration;

	public UrlsToTrack() {
	}

	public String getUrlsToTrack() {
		return this.urlsToTrack;
	}

	public void setUrlsToTrack(String urlsToTrack) {
		this.urlsToTrack = urlsToTrack;
	}

	public TrackerConfiguration getTrackerConfiguration() {
		return this.trackerConfiguration;
	}

	public void setTrackerConfiguration(TrackerConfiguration trackerConfiguration) {
		this.trackerConfiguration = trackerConfiguration;
	}

}