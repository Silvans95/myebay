package it.prova.myebay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "acquisto")
public class Acquisto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "utenteAcquirente")
	private String utenteAcquirente;
	@Column(name = "dataAcquisto")
	private Date dataAcquisto;
	@Column(name = "prezzo")
	private Integer prezzo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id",nullable = false)
	private Utente utente;
	
//############################ COSTRUTTORI ###########################
	
	public Acquisto() {
		// TODO Auto-generated constructor stub
	}

//############################ GET SET ###########################
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUtenteAcquirente() {
		return utenteAcquirente;
	}

	public void setUtenteAcquirente(String utenteAcquirente) {
		this.utenteAcquirente = utenteAcquirente;
	}

	public Date getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
}
