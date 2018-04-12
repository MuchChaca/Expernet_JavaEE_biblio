package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name="person")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	private String adress;

	@Column(length=255)
	private String city;

	@Temporal(TemporalType.DATE)
	@Column(name="date_birth")
	private Date dateBirth;

	@Column(length=255)
	private String email;

	@Column(length=255)
	private String fname;

	@Column(name="\"isAdmin\"")
	private Boolean isAdmin;

	@Column(length=255)
	private String lname;

	@Column(nullable=false, length=255)
	private String login;

	@Column(length=255)
	private String password;

	@Column(length=255)
	private String phone;

	@Column(length=255)
	private String zipcode;

	//bi-directional many-to-many association to BookInstance
	@JoinTable(
	        name = "borrow",
	        joinColumns = @JoinColumn(
	    	        name = "id",
	    	        referencedColumnName = "id"
	    	),
	        inverseJoinColumns = @JoinColumn(
	                name = "id_person",
	                referencedColumnName = "id"
	        )
	)
	@ManyToMany
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private List<BookInstance> bookinstances;

	public Person() {
	}

	protected Integer getId() {
		return this.id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getAdress() {
		return this.adress;
	}

	protected void setAdress(String adress) {
		this.adress = adress;
	}

	protected String getCity() {
		return this.city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	protected Date getDateBirth() {
		return this.dateBirth;
	}

	protected void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	protected String getEmail() {
		return this.email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getFname() {
		return this.fname;
	}

	protected void setFname(String fname) {
		this.fname = fname;
	}

	protected Boolean getIsAdmin() {
		return this.isAdmin;
	}

	protected void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	protected String getLname() {
		return this.lname;
	}

	protected void setLname(String lname) {
		this.lname = lname;
	}

	protected String getLogin() {
		return this.login;
	}

	protected void setLogin(String login) {
		this.login = login;
	}

	protected String getPassword() {
		return this.password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	protected String getPhone() {
		return this.phone;
	}

	protected void setPhone(String phone) {
		this.phone = phone;
	}

	protected String getZipcode() {
		return this.zipcode;
	}

	protected void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<BookInstance> getBookinstances() {
		return this.bookinstances;
	}

	public void setBookinstances(List<BookInstance> bookinstances) {
		this.bookinstances = bookinstances;
	}

}