package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bookinstance database table.
 * 
 */
@Entity
@Table(name="bookinstance")
@NamedQuery(name="BookInstance.findAll", query="SELECT b FROM BookInstance b")
public class BookInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	private String isbn;

	@Column(length=255)
	private String shape;

	private Boolean status;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id", nullable=false, insertable=false, updatable=false),
//		@JoinColumn(name="id_books", nullable=false)
		})
	private Book book;

	//bi-directional many-to-many association to Person
	@ManyToMany(mappedBy="bookinstances")
	private List<Person> persons;

	public BookInstance() {
	}

	protected Integer getId() {
		return this.id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getIsbn() {
		return this.isbn;
	}

	protected void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	protected String getShape() {
		return this.shape;
	}

	protected void setShape(String shape) {
		this.shape = shape;
	}

	protected Boolean getStatus() {
		return this.status;
	}

	protected void setStatus(Boolean status) {
		this.status = status;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}