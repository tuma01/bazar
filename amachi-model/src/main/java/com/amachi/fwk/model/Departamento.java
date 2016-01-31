package com.amachi.fwk.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.amachi.fwk.common.model.Model;

/**
 * Departamento
 * @author tuma
 * @date Feb 1, 2015
 *
 */
@Entity
@Table(name="DEPARTAMENTO", uniqueConstraints=@UniqueConstraint(name="UK_NAME_ID_PAYS", columnNames={"NAME","FK_ID_PAYS"}))
public class Departamento implements Model {

	/**
	 * serialVersionUID
	 * Jan 23, 2015
	 */
	private static final long serialVersionUID = 5444171780700736169L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_DEPARTAMENTO", unique = true, nullable = false)
	private Integer idDepartamento;
	
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_PAYS", nullable=false, referencedColumnName="ID_PAYS", foreignKey=@ForeignKey(name="FK_DEPARTAMENTO_PAYS"))
	private Pays pays;
	
	@OneToMany(targetEntity=Municipio.class, mappedBy="departamento", fetch= FetchType.EAGER)
	private List<Municipio> municipios = new ArrayList<Municipio>();
	
	@Embedded 
	private UserConnexion userConnexion;

	/**
	 * Constructor
	 */
	public Departamento() {
	}

	/**
	 * Constructor
	 * @param name
	 */
	public Departamento(String name) {
		this.name = name;
	}

	/**
	 * Attribute getter idDepartamento
	 * @return idDepartamento
	 */
	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	/**
	 * Attribute setter idDepartamento
	 * @param idDepartamento idDepartamento
	 */
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	/**
	 * Attribute getter name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Attribute setter name
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Attribute getter pays
	 * @return pays
	 */
	public Pays getPays() {
		return pays;
	}

	/**
	 * Attribute setter pays
	 * @param pays pays
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	/**
	 * Attribute getter municipios
	 * @return municipios
	 */
	public List<Municipio> getMunicipios() {
		return municipios;
	}

	/**
	 * Attribute setter municipios
	 * @param municipios municipios
	 */
	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	/**
	 * Attribute getter userConnexion
	 * @return userConnexion
	 */
	public UserConnexion getUserConnexion() {
		return userConnexion;
	}

	/**
	 * Attribute setter userConnexion
	 * @param userConnexion userConnexion
	 */
	public void setUserConnexion(UserConnexion userConnexion) {
		this.userConnexion = userConnexion;
	}

}
