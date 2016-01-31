package com.amachi.fwk.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.amachi.fwk.common.model.Model;

/**
 * Municipio
 * @author tuma
 * @date Feb 1, 2015
 *
 */
@Entity
@Table(name = "MUNICIPIO", uniqueConstraints=@UniqueConstraint(name="UK_NAME_ID_DEPARTAMENTO", columnNames={"NAME","FK_ID_DEPARTAMENTO"}))
public class Municipio implements Model {

	/**
	 * serialVersionUID
	 * Feb 1, 2015
	 */
	private static final long serialVersionUID = 8864702703651119060L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_MUNICIPIO", unique = true, nullable = false)
	private Integer idMunicipio;
	
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	
	@Embedded
	private UserConnexion userConnexion;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_DEPARTAMENTO", nullable=false, referencedColumnName="ID_DEPARTAMENTO", foreignKey=@ForeignKey(name="FK_MUNICIPIO_DEPARTAMENTO"))
	private Departamento departamento;

	/**
	 * Constructor
	 */
	public Municipio() {
	}

	/**
	 * Constructor
	 * @param name
	 */
	public Municipio(String name) {
		this.name = name;
	}

	/**
	 * Attribute getter idMunicipio
	 * @return idMunicipio
	 */
	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * Attribute setter idMunicipio
	 * @param idMunicipio idMunicipio
	 */
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
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

}
