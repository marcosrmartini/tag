package br.com.adin.tag.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the user_tracking_configuration_trigger_button
 * database table.
 * 
 */
@Entity
@Table(name = "user_tracking_configuration_trigger_button")
@NamedQuery(name = "UserTrackingConfigurationTriggerButton.findAll", query = "SELECT u FROM UserTrackingConfigurationTriggerButton u")
public class UserTrackingConfigurationTriggerButton implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id	
	@Column(name = "trigger_button_key")
	private String triggerButtonKey;

	@Column(name = "trigger_button")
	private String triggerButton;

	
	// bi-directional many-to-one association to UserTrackingConfiguration
	@ManyToOne
	@JoinColumn(name = "user_tracking_configuration_id")
	private UserTrackingConfiguration userTrackingConfiguration;

	public UserTrackingConfigurationTriggerButton() {
	}

	public String getTriggerButton() {
		return this.triggerButton;
	}

	public void setTriggerButton(String triggerButton) {
		this.triggerButton = triggerButton;
	}

	public UserTrackingConfiguration getUserTrackingConfiguration() {
		return this.userTrackingConfiguration;
	}

	public void setUserTrackingConfiguration(
			UserTrackingConfiguration userTrackingConfiguration) {
		this.userTrackingConfiguration = userTrackingConfiguration;
	}

	public String getTriggerButtonKey() {
		return triggerButtonKey;
	}

	public void setTriggerButtonKey(String triggerButtonKey) {
		this.triggerButtonKey = triggerButtonKey;
	}

	
	
}