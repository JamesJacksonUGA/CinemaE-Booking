package cinema.booking.models;

public class TicketTypeSelection {

	private Integer adult = 0;
	private Integer child = 0;
	private Integer senior = 0;
	
	
	public TicketTypeSelection() {
		
	}
	public Integer getAdult() {
		return adult;
	}
	public void setAdult(Integer adult) {
		this.adult = adult;
	}
	public Integer getChild() {
		return child;
	}
	public void setChild(Integer child) {
		this.child = child;
	}
	public Integer getSenior() {
		return senior;
	}
	public void setSenior(Integer senior) {
		this.senior = senior;
	}
	
}
