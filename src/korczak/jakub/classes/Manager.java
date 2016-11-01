package korczak.jakub.classes;

import korczak.jakub.interf.IWorking;

public class Manager extends Person implements IWorking
{

	private static int globalID = 1;
	private int id;

	public Manager(String firstName, String surname, int year, int month, int day)
	{
		super(firstName, surname, year, month, day);
		this.id = globalID++;
	}

	

	public int getId()
	{
		return id;
	}



	@Override
	public String toString()
	{
		return super.toString() +  "ManagerID: " + id + " ]";
	}

	@Override
	public void working()
	{
		System.out.println(getFirstName() + " is managing...");
		
	}

	@Override
	public void resting()
	{
		System.out.println(getFirstName() + " is playing golf...");
		
	}
	
	

}