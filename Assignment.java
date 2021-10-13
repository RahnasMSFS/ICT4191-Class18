package lk.ac.vau.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assignment implements Serializable{

	@Id
	@ManyToOne    //many workers assigned for a building
	@JoinColumn(name = "Worker_ID",referencedColumnName = "Worker_ID")
	private Worker worker;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "Building_ID",referencedColumnName = "Building_ID")
	private Building building;
	
	private Date StartDate;
	private int NoofDays;
	
	public Assignment()
	{}

	public Assignment(Worker worker, Building building, Date startDate, int noofDays) {
		super();
		this.worker = worker;
		this.building = building;
		StartDate = startDate;
		NoofDays = noofDays;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public int getNoofDays() {
		return NoofDays;
	}

	public void setNoofDays(int noofDays) {
		NoofDays = noofDays;
	}
}
