package br.com.adin.tag.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_tracking_configuration_trigger_button database table.
 * 
 */
@Embeddable
public class UserTrackingConfigurationTriggerButtonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_tracking_configuration_id", insertable=false, updatable=false)
	private String userTrackingConfigurationId;

	@Column(name="trigger_button_key")
	private String triggerButtonKey;

	public UserTrackingConfigurationTriggerButtonPK() {
	}
	public String getUserTrackingConfigurationId() {
		return this.userTrackingConfigurationId;
	}
	public void setUserTrackingConfigurationId(String userTrackingConfigurationId) {
		this.userTrackingConfigurationId = userTrackingConfigurationId;
	}
	public String getTriggerButtonKey() {
		return this.triggerButtonKey;
	}
	public void setTriggerButtonKey(String triggerButtonKey) {
		this.triggerButtonKey = triggerButtonKey;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserTrackingConfigurationTriggerButtonPK)) {
			return false;
		}
		UserTrackingConfigurationTriggerButtonPK castOther = (UserTrackingConfigurationTriggerButtonPK)other;
		return 
			this.userTrackingConfigurationId.equals(castOther.userTrackingConfigurationId)
			&& this.triggerButtonKey.equals(castOther.triggerButtonKey);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userTrackingConfigurationId.hashCode();
		hash = hash * prime + this.triggerButtonKey.hashCode();
		
		return hash;
	}
}