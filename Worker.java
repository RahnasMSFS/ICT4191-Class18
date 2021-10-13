package lk.ac.vau.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Worker {

	@Id
	private int Worker_ID;
	private String Worker_Name;
	private double Hourly_rate;
	
	enum SkillType{
		Electric,
		Plumbing,
		Roofing,
		Framing
	}
	
	@Enumerated(EnumType.STRING)
	private SkillType Skill_type;
	
	@ManyToOne
	@JoinColumn(name = "Supervisor_ID",referencedColumnName = "Worker_ID")
	private Worker Supervisor;
	
	/*1 supervisor manage many workers
	@OneToMany(mappedBy = "Supervisor")
	private List<Worker>workers;*/
	
	//one worker has many assignment
	@OneToMany(mappedBy = "worker")
	private List<Assignment>WorkAssignments;
	
	public Worker()
	{}

	public Worker(int worker_ID, String worker_Name, double hourly_rate, SkillType skill_type, Worker supervisor,
			List<Assignment> workAssignments) {
		super();
		Worker_ID = worker_ID;
		Worker_Name = worker_Name;
		Hourly_rate = hourly_rate;
		Skill_type = skill_type;
		Supervisor = supervisor;
		WorkAssignments = workAssignments;
	}

	public int getWorker_ID() {
		return Worker_ID;
	}

	public void setWorker_ID(int worker_ID) {
		Worker_ID = worker_ID;
	}

	public String getWorker_Name() {
		return Worker_Name;
	}

	public void setWorker_Name(String worker_Name) {
		Worker_Name = worker_Name;
	}

	public double getHourly_rate() {
		return Hourly_rate;
	}

	public void setHourly_rate(double hourly_rate) {
		Hourly_rate = hourly_rate;
	}

	public SkillType getSkill_type() {
		return Skill_type;
	}

	public void setSkill_type(SkillType skill_type) {
		Skill_type = skill_type;
	}

	@JsonIgnore
	public Worker getSupervisor() {
		return Supervisor;
	}

	public void setSupervisor(Worker supervisor) {
		Supervisor = supervisor;
	}

	@JsonIgnore
	public List<Assignment> getWorkAssignments() {
		return WorkAssignments;
	}

	public void setWorkAssignments(List<Assignment> workAssignments) {
		WorkAssignments = workAssignments;
	}
}
	
	
