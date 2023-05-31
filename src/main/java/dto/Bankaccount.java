package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Bankaccount {
@Id
@GeneratedValue(generator="accno")
@SequenceGenerator(initialValue=1214567891,allocationSize=1,sequenceName="accno", name="accno")
	long accountno;
	String type;
	double amount;
	boolean status;
	double acclimit;
	
	@ManyToOne
	Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<BankTransaction> bankTransactions;


}
