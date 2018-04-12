package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@Table(name="genre")
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	private String label;

	//bi-directional many-to-many association to Book
	@JoinTable(
	        name = "has",
	        joinColumns = @JoinColumn(
	    	        name = "id",
	    	        referencedColumnName = "id"
	    	),
	        inverseJoinColumns = @JoinColumn(
	                name = "id_genre",
	                referencedColumnName = "id"
	        )
	)
	@ManyToMany
//	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private List<Book> books;

	public Genre() {
	}

	protected Integer getId() {
		return this.id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getLabel() {
		return this.label;
	}

	protected void setLabel(String label) {
		this.label = label;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}