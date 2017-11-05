package br.com.adin.tag.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tracker_configurations database table.
 * 
 */
@Entity
@Table(name="tracker_configurations")
@NamedQuery(name="TrackerConfiguration.findAll", query="SELECT t FROM TrackerConfiguration t")
public class TrackerConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	//bi-directional many-to-one association to ModalContent
	@OneToMany(mappedBy="trackerConfiguration")
	private List<ModalContent> modalContents;

	//bi-directional many-to-one association to TrackedHtmlControl
	@OneToMany(mappedBy="trackerConfiguration")
	private List<TrackedHtmlControl> trackedHtmlControls;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer customer;

	//bi-directional many-to-one association to UrlsToTrack
	@OneToMany(mappedBy="trackerConfiguration")
	private List<UrlsToTrack> urlsToTracks;

	//bi-directional many-to-one association to UserTrackingConfiguration
	@OneToMany(mappedBy="trackerConfiguration")
	private List<UserTrackingConfiguration> userTrackingConfigurations;

	public TrackerConfiguration() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ModalContent> getModalContents() {
		return this.modalContents;
	}

	public void setModalContents(List<ModalContent> modalContents) {
		this.modalContents = modalContents;
	}

	public ModalContent addModalContent(ModalContent modalContent) {
		getModalContents().add(modalContent);
		modalContent.setTrackerConfiguration(this);

		return modalContent;
	}

	public ModalContent removeModalContent(ModalContent modalContent) {
		getModalContents().remove(modalContent);
		modalContent.setTrackerConfiguration(null);

		return modalContent;
	}

	public List<TrackedHtmlControl> getTrackedHtmlControls() {
		return this.trackedHtmlControls;
	}

	public void setTrackedHtmlControls(List<TrackedHtmlControl> trackedHtmlControls) {
		this.trackedHtmlControls = trackedHtmlControls;
	}

	public TrackedHtmlControl addTrackedHtmlControl(TrackedHtmlControl trackedHtmlControl) {
		getTrackedHtmlControls().add(trackedHtmlControl);
		trackedHtmlControl.setTrackerConfiguration(this);

		return trackedHtmlControl;
	}

	public TrackedHtmlControl removeTrackedHtmlControl(TrackedHtmlControl trackedHtmlControl) {
		getTrackedHtmlControls().remove(trackedHtmlControl);
		trackedHtmlControl.setTrackerConfiguration(null);

		return trackedHtmlControl;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<UrlsToTrack> getUrlsToTracks() {
		return this.urlsToTracks;
	}

	public void setUrlsToTracks(List<UrlsToTrack> urlsToTracks) {
		this.urlsToTracks = urlsToTracks;
	}

	public UrlsToTrack addUrlsToTrack(UrlsToTrack urlsToTrack) {
		getUrlsToTracks().add(urlsToTrack);
		urlsToTrack.setTrackerConfiguration(this);

		return urlsToTrack;
	}

	public UrlsToTrack removeUrlsToTrack(UrlsToTrack urlsToTrack) {
		getUrlsToTracks().remove(urlsToTrack);
		urlsToTrack.setTrackerConfiguration(null);

		return urlsToTrack;
	}

	public List<UserTrackingConfiguration> getUserTrackingConfigurations() {
		return this.userTrackingConfigurations;
	}

	public void setUserTrackingConfigurations(List<UserTrackingConfiguration> userTrackingConfigurations) {
		this.userTrackingConfigurations = userTrackingConfigurations;
	}

	public UserTrackingConfiguration addUserTrackingConfiguration(UserTrackingConfiguration userTrackingConfiguration) {
		getUserTrackingConfigurations().add(userTrackingConfiguration);
		userTrackingConfiguration.setTrackerConfiguration(this);

		return userTrackingConfiguration;
	}

	public UserTrackingConfiguration removeUserTrackingConfiguration(UserTrackingConfiguration userTrackingConfiguration) {
		getUserTrackingConfigurations().remove(userTrackingConfiguration);
		userTrackingConfiguration.setTrackerConfiguration(null);

		return userTrackingConfiguration;
	}

}