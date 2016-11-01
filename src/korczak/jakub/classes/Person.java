package korczak.jakub.classes;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

import javax.xml.crypto.Data;

public abstract class Person
{


	private String firstName;
	private String surname;
	private LocalDate birthDate;
	private int age;

	public Person(String firstName, String surname, int year, int month, int day)
	{
		this.firstName = firstName;
		this.surname = surname;
		this.birthDate = LocalDate.of(year, month, day);
		this.age = setAge();
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate)
	{
		this.birthDate = birthDate;
	}

	public int setAge()
	{
		LocalDate currentDate = LocalDate.now();
		if ((birthDate != null) && (currentDate != null))
		{
			return Period.between(birthDate, currentDate).getYears();
		} else
		{
			return 0;
		}
	}
	
	

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (birthDate == null)
		{
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null)
		{
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (surname == null)
		{
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "FirstName: " + firstName + ", surname: " + surname + ", age: " + age
				+ " ]";
	}

}