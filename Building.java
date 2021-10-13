package lk.ac.vau.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Building {

	@Id
	private int Building_ID;
	private String Buil_Address;
	
	//predefined values use enum(Limited option)
	enum BuildingType{
		Office,
		Retail,
		Residence,
		Warehouse
	}
	
	@Enumerated(EnumType.STRING)
	private BuildingType buildingType;
	private int Qlty_Level;
	private int Status;
	
	//one building has many assignment
	@OneToMany(mappedBy = "building")
	private List<Assignment>BuildAssignments;
	
	public Building()
	{}

	public Building(int building_ID, String buil_Address, BuildingType buildingType, int qlty_Level, int status,
			List<Assignment> buildAssignments) {
		super();
		Building_ID = building_ID;
		Buil_Address = buil_Address;
		this.buildingType = buildingType;
		Qlty_Level = qlty_Level;
		Status = status;
		BuildAssignments = buildAssignments;
	}

	public int getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(int building_ID) {
		Building_ID = building_ID;
	}

	public String getBuil_Address() {
		return Buil_Address;
	}

	public void setBuil_Address(String buil_Address) {
		Buil_Address = buil_Address;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public int getQlty_Level() {
		return Qlty_Level;
	}

	public void setQlty_Level(int qlty_Level) {
		Qlty_Level = qlty_Level;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public List<Assignment> getBuildAssignments() {
		return BuildAssignments;
	}

	public void setBuildAssignments(List<Assignment> buildAssignments) {
		BuildAssignments = buildAssignments;
	}
}
