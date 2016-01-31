package com.amachi.fwk.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.amachi.fwk.common.model.Model;
import com.amachi.fwk.util.StatusEnum;
import com.amachi.fwk.util.TypeAccountEnum;
import com.amachi.fwk.util.TypeAnuncioEnum;

/**
 * Anuncio
 */

@Entity
@Table(name="ANUNCIO", uniqueConstraints =  {@UniqueConstraint(name="UK_NAME_ANUNCIO", columnNames = {"NAME"}), @UniqueConstraint(name="UK_EMAIL_ANUNCIO", columnNames = {"EMAIL"})})
//@Table(name="ANUNCIO", uniqueConstraints=@UniqueConstraint(name="UK_NAME_ANUNCIO", columnNames={"NAME"}))
public class Anuncio implements Model {


	/**
	 * serialVersionUID
	 * Nov 27, 2015
	 */
	private static final long serialVersionUID = 1111955405490231386L;

	@Id
	@GeneratedValue
	@Column(name = "ID_ANUNCIO", nullable = false)
	private Long idAnuncio;
	
	@ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
	@JoinColumn(name="FK_ID_CATEGORY", nullable=false, referencedColumnName="ID_CATEGORY", foreignKey=@ForeignKey(name="FK_ANUNCIO_CATEGORY"))
	private Category category;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "EMAIL", nullable = false, length = 50)
	private String email;

	@Column(name = "TELEPHONE", length = 50)
	private String telephone;
	
	@Column(name = "TITLE", nullable = false, length = 250)
	private String title;

	@Column(name = "TEXT", nullable = false, length = 65535)
	private String text;

	@Column(name = "PRIX")
	private Float prix;

	@ManyToOne
	@JoinColumn(name="FK_ID_DEPARTAMENTO", nullable=false, referencedColumnName="ID_DEPARTAMENTO", foreignKey=@ForeignKey(name="FK_ANUNCIO_DEPARTAMENTO"))
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_MUNICIPIO", nullable=false, referencedColumnName="ID_MUNICIPIO", foreignKey=@ForeignKey(name="FK_ANUNCIO_MUNICIPIO"))
	private Municipio municipio;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_ANUNCIO")
	private TypeAnuncioEnum typeAnuncio;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_ACCOUNT")
	private TypeAccountEnum typeAccount;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", columnDefinition = "varchar(20) default 'INACTIVE'")
	private StatusEnum status;

	@Column(name = "DATE_PUBLICATION", nullable = false, insertable = true, updatable = false)
	private Date datePublication;

	@Column(name = "DATE_PUBLICATION_UPDATE", insertable = false, updatable = true)
	private Date datePublicationUpdate;
	
	@OneToMany(targetEntity=ImageAnuncio.class, mappedBy="anuncio", fetch= FetchType.EAGER, 
			cascade={ CascadeType.ALL, CascadeType.REMOVE})
	private List<ImageAnuncio> imagesAnuncios = new ArrayList<ImageAnuncio>();
	
	@Column(name = "NOMBRE_IMAGES")
	private int nombreImages;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "criterioAnuncioId.anuncio", 
			cascade={ CascadeType.ALL, CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<CriterioAnuncio> criterioAnuncios = new HashSet<CriterioAnuncio>(0);

	
	/**
	 * Constructor
	 */
	public Anuncio() {
	}
	
	/**
	 * Constructor
	 * @param idAnuncio
	 */
	public Anuncio(Long idAnuncio) {
		super();
		this.idAnuncio = idAnuncio;
	}

	
	/**
	 * Attribute getter idAnuncio
	 * @return idAnuncio
	 */
	public Long getIdAnuncio() {
		return idAnuncio;
	}

	/**
	 * Attribute setter idAnuncio
	 * @param idAnuncio idAnuncio
	 */
	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Attribute getter category
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Attribute setter category
	 * @param category category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Attribute getter prix
	 * 
	 * @return prix
	 */
	public Float getPrix() {
		return prix;
	}

	/**
	 * Attribute setter prix
	 * 
	 * @param prix
	 *            prix
	 */
	public void setPrix(Float prix) {
		this.prix = prix;
	}

	/**
	 * Attribute getter typeAccount
	 * 
	 * @return accountType
	 */
	public TypeAccountEnum getTypeAccount() {
		return typeAccount;
	}

	/**
	 * Attribute setter typeAccount
	 * 
	 * @param typeAccount
	 *            typeAccount
	 */
	public void setTypeAccount(TypeAccountEnum typeAccount) {
		this.typeAccount = typeAccount;
	}

	/**
	 * Attribute getter status
	 * 
	 * @return status
	 */
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * Attribute setter status
	 * 
	 * @param status
	 *            status
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * Attribute getter title
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Attribute setter title
	 * 
	 * @param title
	 *            title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Attribute getter text
	 * 
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Attribute setter text
	 * 
	 * @param text
	 *            text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Attribute getter anuncioType
	 * 
	 * @return anuncioType
	 */
	
	public TypeAnuncioEnum getTypeAnuncio() {
		return typeAnuncio;
	}

	/**
	 * Attribute setter typeAnuncio
	 * 
	 * @param typeAnuncio
	 *            typeAnuncio
	 */
	public void setTypeAnuncio(TypeAnuncioEnum typeAnuncio) {
		this.typeAnuncio = typeAnuncio;
	}

	/**
	 * Attribute getter datePublication
	 * 
	 * @return datePublication
	 */
	public Date getDatePublication() {
		return datePublication;
	}

	/**
	 * Attribute setter datePublication
	 * 
	 * @param datePublication
	 *            datePublication
	 */
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	/**
	 * Attribute getter datePublicationUpdate
	 * 
	 * @return datePublicationUpdate
	 */
	public Date getDatePublicationUpdate() {
		return datePublicationUpdate;
	}

	/**
	 * Attribute setter datePublicationUpdate
	 * 
	 * @param datePublicationUpdate
	 *            datePublicationUpdate
	 */
	public void setDatePublicationUpdate(Date datePublicationUpdate) {
		this.datePublicationUpdate = datePublicationUpdate;
	}

	/**
	 * Attribute getter departamento
	 * @return departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * Attribute setter departamento
	 * @param departamento departamento
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	/**
	 * Attribute getter municipio
	 * @return municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}

	/**
	 * Attribute setter municipio
	 * @param municipio municipio
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/**
	 * Attribute getter imagesAnuncios
	 * @return imagesAnuncios
	 */
	public List<ImageAnuncio> getImagesAnuncios() {
		return imagesAnuncios;
	}

	/**
	 * Attribute setter imagesAnuncios
	 * @param imagesAnuncios imagesAnuncios
	 */
	public void setImagesAnuncios(List<ImageAnuncio> imagesAnuncios) {
		this.imagesAnuncios = imagesAnuncios;
	}

    /**
	 * Attribute getter nombreImages
	 * @return nombreImages
	 */
	public int getNombreImages() {
	    return nombreImages;
	}
	
	/**
	 * Attribute setter nombreImages
	 * @param nombreImages nombreImages
	 */
	public void setNombreImages(int nombreImages) {
	    this.nombreImages = nombreImages;
	}

	/**
	 * Attribute getter criterioAnuncios
	 * @return criterioAnuncios
	 */
	public Set<CriterioAnuncio> getCriterioAnuncios() {
		return criterioAnuncios;
	}

	/**
	 * Attribute setter criterioAnuncios
	 * @param criterioAnuncios criterioAnuncios
	 */
	public void setCriterioAnuncios(Set<CriterioAnuncio> criterioAnuncios) {
		this.criterioAnuncios = criterioAnuncios;
	}
	
	/**
	 * Method addCriterioAnuncio
	 * @param criterioAnuncio
	 * @return void
	 */
	public void addCriterioAnuncios(CriterioAnuncio criterioAnuncio) {
		this.criterioAnuncios.add(criterioAnuncio);
	}

}
