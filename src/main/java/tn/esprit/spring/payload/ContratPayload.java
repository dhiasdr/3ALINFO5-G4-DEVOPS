package tn.esprit.spring.payload;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
public class ContratPayload {
	private Long reference;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	private String typeContrat;
	private float salaire;
	private int idEmploye;
	public Long getReference() {
		return reference;
	}
	public void setReference(Long reference) {
		this.reference = reference;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public int getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	
	
}
