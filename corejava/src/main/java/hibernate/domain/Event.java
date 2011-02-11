package hibernate.domain;

import java.util.Date;

public class Event {

	private String id;

	private String title;

	private Date date;

	public Event() {
	}

	public String getId() {
		return id;
	}

	/**
	 * Id is maintain by hibernate internal, so use private modifier
	 * 
	 * @param id
	 */
	private void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:" + id + " title:"+ title + "date:" + date;
	}

}