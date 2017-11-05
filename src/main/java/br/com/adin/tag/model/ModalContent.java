package br.com.adin.tag.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the modal_contents database table.
 * 
 */
@Entity
@Table(name="modal_contents")
@NamedQuery(name="ModalContent.findAll", query="SELECT m FROM ModalContent m")
public class ModalContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Lob
	@Column(name="html_content")
	private String htmlContent;

	private int priority;

	@Column(name="tracked_product_content")
	private String trackedProductContent;

	//bi-directional many-to-one association to TrackerConfiguration
	@ManyToOne
	@JoinColumn(name="tracker_configurations_id")
	private TrackerConfiguration trackerConfiguration;

	public ModalContent() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHtmlContent() {
		return this.htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTrackedProductContent() {
		return this.trackedProductContent;
	}

	public void setTrackedProductContent(String trackedProductContent) {
		this.trackedProductContent = trackedProductContent;
	}

	public TrackerConfiguration getTrackerConfiguration() {
		return this.trackerConfiguration;
	}

	public void setTrackerConfiguration(TrackerConfiguration trackerConfiguration) {
		this.trackerConfiguration = trackerConfiguration;
	}

}