package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @SequenceGenerator(initialValue=12110111,allocationSize=1,name="cusid",sequenceName="cusid")
    @GeneratedValue(generator="cusid")
	int cus_id;
	String name;
	String email;
	String password;
	long mobile;
	Date dob;
	String gender;
	
	@OneToMany
	List<Bankaccount> bankaccount ;

	
}
