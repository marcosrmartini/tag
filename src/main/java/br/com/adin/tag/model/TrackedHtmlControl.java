package br.com.adin.tag.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tracked_html_control database table.
 * 
 */
@Entity
@Table(name="tracked_html_control")
@NamedQuery(name="TrackedHtmlControl.findAll", query="SELECT t FROM TrackedHtmlControl t")
public class TrackedHtmlControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="attribute_to_monitor")
	private String attributeToMonitor;

	@Column(name="html_control_value")
	private String htmlControlValue;

	//bi-directional many-to-one association to TrackerConfiguration
	@ManyToOne
	@JoinColumn(name="tracker_id")
	private TrackerConfiguration trackerConfiguration;

	public TrackedHtmlControl() {
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

	public String getHtmlControlValue() {
		return this.htmlControlValue;
	}

	public void setHtmlControlValue(String htmlControlValue) {
		this.htmlControlValue = htmlControlValue;
	}

	public TrackerConfiguration getTrackerConfiguration() {
		return this.trackerConfiguration;
	}

	public void setTrackerConfiguration(TrackerConfiguration trackerConfiguration) {
		this.trackerConfiguration = trackerConfiguration;
	}

}