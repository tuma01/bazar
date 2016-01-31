package com.amachi.fwk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.amachi.fwk.common.model.Model;

/**
 * ImageAnuncio
 * @author tuma
 * @date Sep 20, 2015
 *
 */
@Entity
@Table(name = "IMAGE_ANUNCIO", uniqueConstraints=@UniqueConstraint(name="UK_FILE_NAME_TYPE", columnNames={"FILE_NAME", "FILE_TYPE"}))
public class ImageAnuncio implements Model {
	
	/**
	 * serialVersionUID
	 * Nov 27, 2015
	 */
	private static final long serialVersionUID = 2026043221457437329L;
	private Integer idImageAnuncio;
	private String fileType;
	private String fileName ;
	private byte[] file;
	//private InputStream inputStream;
	private Short position;
	private String description;
	
	private Anuncio anuncio;
	
	/**
	 * Attribute getter idImageAnuncio
	 * @return idImageAnuncio
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_IMAGE_ANUNCIO", nullable=false, unique=true)
	public Integer getIdImageAnuncio() {
		return idImageAnuncio;
	}
	/**
	 * Attribute setter idImageAnuncio
	 * @param idImageAnuncio idImageAnuncio
	 */
	public void setIdImageAnuncio(Integer idImageAnuncio) {
		this.idImageAnuncio = idImageAnuncio;
	}
	/**
	 * Attribute getter fileType
	 * @return fileType
	 */
	@Column(name="FILE_TYPE", nullable = false, length = 10)
	public String getFileType() {
		return fileType;
	}
	/**
	 * Attribute setter fileType
	 * @param fileType fileType
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * Attribute getter fileName
	 * @return fileName
	 */
	@Column(name="FILE_NAME", nullable=false, length=50)
	public String getFileName() {
		return fileName;
	}
	/**
	 * Attribute setter fileName
	 * @param fileName fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Attribute getter file
	 * @return file
	 */
	@Lob
	@Column(name="FILE", nullable=true, length=100000)
	public byte[] getFile() {
		return file;
	}
	/**
	 * Attribute setter file
	 * @param file file
	 */
	public void setFile(byte[] file) {
		this.file = file;
	}
	
	/**
	 * Attribute getter position
	 * @return position
	 */
	@Column(name="POSITION")
	public Short getPosition() {
		return position;
	}
	/**
	 * Attribute setter position
	 * @param position position
	 */
	public void setPosition(Short position) {
		this.position = position;
	}
	/**
	 * Attribute getter description
	 * @return description
	 */
	@Column(name="DESCRIPTION", length=100)
	public String getDescription() {
		return description;
	}
	/**
	 * Attribute setter description
	 * @param description description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Attribute getter anuncio
	 * @return anuncio
	 */
	@ManyToOne
	@JoinColumn(name="FK_ID_ANUNCIO", nullable=true, referencedColumnName="ID_ANUNCIO", foreignKey=@ForeignKey(name="FK_IMAGE_ANUNCIO"))
	public Anuncio getAnuncio() {
		return anuncio;
	}
	/**
	 * Attribute setter anuncio
	 * @param anuncio anuncio
	 */
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
//	/**
//	 * Attribute getter inputStream
//	 * @return inputStream
//	 */
//	@Lob
//	@Column(name="INPUTSTREAM_FILE", nullable=false, length=100000)
//	public InputStream getInputStream() {
//		return inputStream;
//	}
//	/**
//	 * Attribute setter inputStream
//	 * @param inputStream inputStream
//	 */
//	public void setInputStream(InputStream inputStream) {
//		this.inputStream = inputStream;
//	}
	
	

}
