package br.com.adin.tag.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_tracking_configuration_trigger_button database table.
 * 
 */
@Entity
@Table(name="user_tracking_configuration_trigger_button")
@NamedQuery(name="UserTrackingConfigurationTriggerButton.findAll", query="SELECT u FROM UserTrackingConfigurationTriggerButton u")
public class UserTrackingConfigurationTriggerButton implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserTrackingConfigurationTriggerButtonPK id;

	@Column(name="trigger_button")
	private String triggerButton;

	//bi-directional many-to-one association to UserTrackingConfiguration
	@ManyToOne
	@JoinColumn(name="user_tracking_configuration_id" , insertable=false, updatable=false)
	private UserTrackingConfiguration userTrackingConfiguration;

	public UserTrackingConfigurationTriggerButton() {
	}

	public UserTrackingConfigurationTriggerButtonPK getId() {
		return this.id;
	}

	public void setId(UserTrackingConfigurationTriggerButtonPK id) {
		this.id = id;
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

	public void setUserTrackingConfiguration(UserTrackingConfiguration userTrackingConfiguration) {
		this.userTrackingConfiguration = userTrackingConfiguration;
	}

}