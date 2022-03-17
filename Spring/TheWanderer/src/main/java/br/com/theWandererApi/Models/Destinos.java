package br.com.theWandererApi.Models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Destinos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String destino;
	private String img;
	private Double preco;
	
	public Destinos() {
	}

	public Destinos(Long id, String destino, String img, Double preco) {
		super();
		this.id = id;
		this.destino = destino;
		this.img = img;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, id, img, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destinos other = (Destinos) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(id, other.id) && Objects.equals(img, other.img)
				&& Objects.equals(preco, other.preco);
	}

	@Override
	public String toString() {
		return "Destinos [id=" + id + ", destino=" + destino + ", img=" + img + ", preco=" + preco + "]";
	}
	
	
}
