package br.com.adin.tag.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="public_key")
	private String publicKey;

	//bi-directional many-to-one association to TrackerConfiguration
	@OneToMany(mappedBy="customer")
	private List<TrackerConfiguration> trackerConfigurations;

	public Customer() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPublicKey() {
		return this.publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public List<TrackerConfiguration> getTrackerConfigurations() {
		return this.trackerConfigurations;
	}

	public void setTrackerConfigurations(List<TrackerConfiguration> trackerConfigurations) {
		this.trackerConfigurations = trackerConfigurations;
	}

	public TrackerConfiguration addTrackerConfiguration(TrackerConfiguration trackerConfiguration) {
		getTrackerConfigurations().add(trackerConfiguration);
		trackerConfiguration.setCustomer(this);

		return trackerConfiguration;
	}

	public TrackerConfiguration removeTrackerConfiguration(TrackerConfiguration trackerConfiguration) {
		getTrackerConfigurations().remove(trackerConfiguration);
		trackerConfiguration.setCustomer(null);

		return trackerConfiguration;
	}

}