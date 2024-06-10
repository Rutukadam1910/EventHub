package com.event.event_management.module;

import java.sql.Date;
import java.util.Arrays;
import jakarta.persistence.*;

@Entity
public class CollegeDashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE)
    private int id;

    @Lob
    @Column(name="eventposter", length=1000000000)
    private byte[] eventposter;

    private String collegeName;

    private String eventName;

    private Date startDate;

    private Date endDate;

    private String entryFee;

    private Date registrationLastDate;

    private String prizes;

    private String registrationLink;

    private String venue;

    private String eventDescription;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getEventposter() {
		return eventposter;
	}

	public void setEventposter(byte[] eventposter) {
		this.eventposter = eventposter;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(String entryFee) {
		this.entryFee = entryFee;
	}

	public Date getRegistrationLastDate() {
		return registrationLastDate;
	}

	public void setRegistrationLastDate(Date registrationLastDate) {
		this.registrationLastDate = registrationLastDate;
	}

	public String getPrizes() {
		return prizes;
	}

	public void setPrizes(String prizes) {
		this.prizes = prizes;
	}

	public String getRegistrationLink() {
		return registrationLink;
	}

	public void setRegistrationLink(String registrationLink) {
		this.registrationLink = registrationLink;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "CollegeDashboard [id=" + id + ", eventposter=" + Arrays.toString(eventposter) + ", collegeName="
				+ collegeName + ", eventName=" + eventName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", entryFee=" + entryFee + ", registrationLastDate=" + registrationLastDate + ", prizes=" + prizes
				+ ", registrationLink=" + registrationLink + ", venue=" + venue + ", eventDescription="
				+ eventDescription + ", college=" + college + "]";
	}

	public CollegeDashboard(int id, byte[] eventposter, String collegeName, String eventName, Date startDate,
			Date endDate, String entryFee, Date registrationLastDate, String prizes, String registrationLink,
			String venue, String eventDescription, College college) {
		super();
		this.id = id;
		this.eventposter = eventposter;
		this.collegeName = collegeName;
		this.eventName = eventName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.entryFee = entryFee;
		this.registrationLastDate = registrationLastDate;
		this.prizes = prizes;
		this.registrationLink = registrationLink;
		this.venue = venue;
		this.eventDescription = eventDescription;
		this.college = college;
	}

	public CollegeDashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
}