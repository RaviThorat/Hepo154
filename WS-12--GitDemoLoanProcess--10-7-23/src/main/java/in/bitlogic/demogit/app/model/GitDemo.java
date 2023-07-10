package in.bitlogic.demogit.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data	
@AllArgsConstructor
@NoArgsConstructor
public class GitDemo 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

	private int loanAppId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String Email;
	

}
