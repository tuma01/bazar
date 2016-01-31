package com.amachi.fwk.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.amachi.fwk.common.model.Model;


/**
 * Pays
 * @author tuma
 * @date Dec 6, 2015
 *
 */
@Entity
@Table(name = "PAYS", uniqueConstraints=@UniqueConstraint(name="UK_NAME_PAYS", columnNames = {"NAME"}))
public class Pays implements Model {
	/**
	 * serialVersionUID
	 * Jan 23, 2015
	 */
	private static final long serialVersionUID = -9202968517766084395L;
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_PAYS", unique = true, nullable = false)
	private Integer idPays;
	
	@Column(name = "NAME",  nullable = false, length = 50)
	private String name;
	
	@Column(name = "CODE_A1", length = 2)
	private String codeA1;
	
	@Column(name = "CODE_A2", length = 2)
	private String codeA2;
	
	@OneToMany(targetEntity=Departamento.class, mappedBy="pays", fetch= FetchType.EAGER)
	private List<Departamento> departamentos;
	
	@Embedded
	private UserConnexion userConnexion;

	/**
	 * Constructor
	 */
	public Pays() {
	}

	/**
	 * Constructor
	 * @param name
	 */
	public Pays(String name) {
		this.name = name;
	}

	/**
	 * Constructor
	 * @param name
	 * @param codeA1
	 * @param codeA2
	 */
	public Pays(String name, String codeA1, String codeA2) {
		this.name = name;
		this.codeA1 = codeA1;
		this.codeA2 = codeA2;
	}

	/**
	 * Attribute getter idPays
	 * @return idPays
	 */
	public Integer getIdPays() {
		return idPays;
	}

	/**
	 * Attribute setter idPays
	 * @param idPays idPays
	 */
	public void setIdPays(Integer idPays) {
		this.idPays = idPays;
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
	 * Attribute getter codeA1
	 * @return codeA1
	 */
	public String getCodeA1() {
		return codeA1;
	}

	/**
	 * Attribute setter codeA1
	 * @param codeA1 codeA1
	 */
	public void setCodeA1(String codeA1) {
		this.codeA1 = codeA1;
	}

	/**
	 * Attribute getter codeA2
	 * @return codeA2
	 */
	public String getCodeA2() {
		return codeA2;
	}

	/**
	 * Attribute setter codeA2
	 * @param codeA2 codeA2
	 */
	public void setCodeA2(String codeA2) {
		this.codeA2 = codeA2;
	}

	/**
	 * Attribute getter departamentos
	 * @return departamentos
	 */
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	/**
	 * Attribute setter departamentos
	 * @param departamentos departamentos
	 */
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
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
