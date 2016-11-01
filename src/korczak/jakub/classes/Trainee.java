package korczak.jakub.classes;

import java.time.LocalDate;
import java.time.Period;

public class Trainee extends Employee
{

	private LocalDate practiceStartDate;
	private int practiseTime;
	
	public Trainee(String firstName, String surname, int year, int month, int day, 
			double salary, Manager mang, int startYear2, int startMonth2, int startDay2)
	{
		super(firstName, surname, year, month, day, salary, mang);
		this.practiceStartDate = LocalDate.of(startYear2, startMonth2, startDay2);
		this.practiseTime = setPractiseTime();
	}

	
	public LocalDate getPracticeStartDate()
	{
		return practiceStartDate;
	}
	public void setPracticeStartDate(LocalDate practiceStartDate)
	{
		this.practiceStartDate = practiceStartDate;
	}
	
	public int setPractiseTime()
	{
		LocalDate currentDate = LocalDate.now();
		if ((practiceStartDate != null) && (currentDate != null))
		{
			return Period.between(practiceStartDate, currentDate).getYears();
		} else
		{
			return 0;
		}
	}

	public int getPractiseTime()
	{
		return practiseTime;
	}


	@Override
	public String toString()
	{
		return super.toString() + "Trainee: [ practiceStartDate: " + practiceStartDate + ", practiseTime: " + practiseTime + " ]";
	}
	
	
}