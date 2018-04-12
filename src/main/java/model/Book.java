package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the books database table.
 * 
 */
@Entity
@Table(name="books")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=2000)
	private String description;

	@Column(nullable=false, length=255)
	private String title;

	//bi-directional many-to-one association to BookInstance
	@OneToMany(mappedBy="book")
	private List<BookInstance> bookinstances;

	//bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="id_author", nullable=false)
	private Author author;

	//bi-directional many-to-many association to Genre
	@ManyToMany(mappedBy="books")
	private List<Genre> genres;

	public Book() {
	}

	protected Integer getId() {
		return this.id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getDescription() {
		return this.description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected String getTitle() {
		return this.title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	public List<BookInstance> getBookinstances() {
		return this.bookinstances;
	}

	public void setBookinstances(List<BookInstance> bookinstances) {
		this.bookinstances = bookinstances;
	}

	public BookInstance addBookinstance(BookInstance bookinstance) {
		getBookinstances().add(bookinstance);
		bookinstance.setBook(this);

		return bookinstance;
	}

	public BookInstance removeBookinstance(BookInstance bookinstance) {
		getBookinstances().remove(bookinstance);
		bookinstance.setBook(null);

		return bookinstance;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Genre> getGenres() {
		return this.genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

}