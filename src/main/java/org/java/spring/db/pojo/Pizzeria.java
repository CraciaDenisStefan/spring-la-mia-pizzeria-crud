package org.java.spring.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizzeria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
	private String nome;
	@Column(columnDefinition = "TEXT")
    private String descrizione;
	
    private String fotoUrl;
 
    private double prezzo;
    
    public Pizzeria() { }
	public Pizzeria(String nome, String descrizione, String fotoUrl, double prezzo) {
		setNome(nome);
		setDescrizione(descrizione);
		setFotoUrl(fotoUrl);
		setPrezzo(prezzo);
		
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFotoUrl() {
		return fotoUrl;
	}
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getNome() + " - " 
				+ getDescrizione() + " (" + getPrezzo() + ")";
	}
	
}
