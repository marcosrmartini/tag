package br.com.adin.tag.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_tracking_configuration database table.
 * 
 */
@Entity
@Table(name="user_tracking_configuration")
@NamedQuery(name="UserTrackingConfiguration.findAll", query="SELECT u FROM UserTrackingConfiguration u")
public class UserTrackingConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="attribute_to_monitor")
	private String attributeToMonitor;

	@Column(name="attribute_to_save")
	private String attributeToSave;

	@Column(name="attribute_value")
	private String attributeValue;

	//bi-directional many-to-one association to TrackerConfiguration
	@ManyToOne
	@JoinColumn(name="tracker_id")
	private TrackerConfiguration trackerConfiguration;

	//bi-directional many-to-one association to UserTrackingConfigurationTriggerButton
	@OneToMany(mappedBy="userTrackingConfiguration")
	private List<UserTrackingConfigurationTriggerButton> userTrackingConfigurationTriggerButtons;

	public UserTrackingConfiguration() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttributeToMonitor() {
		return this.attributeToMonitor;
	}

	public void setAttributeToMonitor(String attributeToMonitor) {
		this.attributeToMonitor = attributeToMonitor;
	}

	public String getAttributeToSave() {
		return this.attributeToSave;
	}

	public void setAttributeToSave(String attributeToSave) {
		this.attributeToSave = attributeToSave;
	}

	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public TrackerConfiguration getTrackerConfiguration() {
		return this.trackerConfiguration;
	}

	public void setTrackerConfiguration(TrackerConfiguration trackerConfiguration) {
		this.trackerConfiguration = trackerConfiguration;
	}

	public List<UserTrackingConfigurationTriggerButton> getUserTrackingConfigurationTriggerButtons() {
		return this.userTrackingConfigurationTriggerButtons;
	}

	public void setUserTrackingConfigurationTriggerButtons(List<UserTrackingConfigurationTriggerButton> userTrackingConfigurationTriggerButtons) {
		this.userTrackingConfigurationTriggerButtons = userTrackingConfigurationTriggerButtons;
	}

	public UserTrackingConfigurationTriggerButton addUserTrackingConfigurationTriggerButton(UserTrackingConfigurationTriggerButton userTrackingConfigurationTriggerButton) {
		getUserTrackingConfigurationTriggerButtons().add(userTrackingConfigurationTriggerButton);
		userTrackingConfigurationTriggerButton.setUserTrackingConfiguration(this);

		return userTrackingConfigurationTriggerButton;
	}

	public UserTrackingConfigurationTriggerButton removeUserTrackingConfigurationTriggerButton(UserTrackingConfigurationTriggerButton userTrackingConfigurationTriggerButton) {
		getUserTrackingConfigurationTriggerButtons().remove(userTrackingConfigurationTriggerButton);
		userTrackingConfigurationTriggerButton.setUserTrackingConfiguration(null);

		return userTrackingConfigurationTriggerButton;
	}

}