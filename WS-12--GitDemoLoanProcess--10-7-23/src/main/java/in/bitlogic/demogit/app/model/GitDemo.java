package in.bitlogic.demogit.app.model;



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
