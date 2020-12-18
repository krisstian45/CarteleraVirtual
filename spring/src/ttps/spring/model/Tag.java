package ttps.spring.model;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@tagId")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreTag;

	@ManyToMany(mappedBy = "tags")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Cartelera> carteleras;

	public Tag() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreTag() {
		return nombreTag;
	}

	public void setNombreTag(String nombreTag) {
		this.nombreTag = nombreTag;
	}

	public Set<Cartelera> getCartelera() {
		return carteleras;
	}

	public void setCartelera(Cartelera cartelera) {
		this.carteleras.add(cartelera);
	}
}
