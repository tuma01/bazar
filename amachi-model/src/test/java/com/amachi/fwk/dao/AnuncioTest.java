package com.amachi.fwk.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.CollectionUtils;

import com.amachi.fwk.model.Anuncio;
import com.amachi.fwk.model.Category;
import com.amachi.fwk.model.Criterio;
import com.amachi.fwk.model.CriterioAnuncio;
import com.amachi.fwk.model.CriterioAnuncioId;
import com.amachi.fwk.model.CriterioCategory;
import com.amachi.fwk.model.CriterioCategoryId;
import com.amachi.fwk.model.CriterioValue;
import com.amachi.fwk.model.Departamento;
import com.amachi.fwk.model.Municipio;
import com.amachi.fwk.model.UserConnexion;
import com.amachi.fwk.util.StatusEnum;
import com.amachi.fwk.util.TypeAccountEnum;
import com.amachi.fwk.util.TypeAnuncioEnum;

/**
 * @author tuma
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fwkContextModel-test.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "txManager")
@Transactional
public class AnuncioTest {
	
	@Autowired
	private CriterioCategoryDao criterioCategoryDao;
	
	@Autowired
	private AnuncioDao anuncioDao;
	
	@Autowired
	private CriterioDao criterioDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CriterioAnuncioDao criterioAnuncioDao;
	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private MunicipioDao municipioDao;
	
	@Test
	public void createAnuncioTest() {
		
		Category category = categoryDao.findByPK(Category.class, 2);
		
		Criterio criterioMarca = criterioDao.findByPK(Criterio.class, 1);
		List<CriterioValue> values = criterioMarca.getCriterioValues();
		CriterioValue criterioValue = values.get(0);
		String valuePrincipalMarca = criterioValue.getName();
		String valueOptionalMarca =criterioValue.getValues().get(0).getValueChild();
		
		Criterio criterioCarburant = criterioDao.findByPK(Criterio.class, 2);
		List<CriterioValue> valuesCarburant = criterioCarburant.getCriterioValues();
		CriterioValue criterioValueCarburant = valuesCarburant.get(0);
		String valuePrincipalCarburant = criterioValueCarburant.getName();
		String valueOptionalCarburant = "";
		if(!CollectionUtils.isEmpty(criterioValueCarburant.getValues())) {
			valueOptionalCarburant = criterioValueCarburant.getValues().get(0).getValueChild();
		}
		
		
		CriterioCategory criterioCategoryMarca = new CriterioCategory();
		criterioCategoryMarca.setCriterio(criterioMarca);
		criterioCategoryMarca.setCategory(category);
		criterioCategoryMarca.setCreatedDate(new Date());
		criterioCategoryMarca.setDescription("description del Criterio Marca");
		criterioCategoryDao.createOrUpdate(criterioCategoryMarca);
		
		CriterioCategory criterioCategoryCarburant = new CriterioCategory();
		criterioCategoryCarburant.setCriterio(criterioCarburant);
		criterioCategoryCarburant.setCategory(category);
		criterioCategoryCarburant.setCreatedDate(new Date());
		criterioCategoryCarburant.setDescription("description del Criterio Carburant");
		criterioCategoryDao.createOrUpdate(criterioCategoryCarburant);

		Departamento departamento = departamentoDao.findByPK(Departamento.class, 1);
		Municipio municipio = municipioDao.findByPK(Municipio.class, 2);
//		
		Anuncio anuncio = new Anuncio();
		anuncio.setName("AMACHI");
		anuncio.setDatePublication(new Date());
		anuncio.setDepartamento(departamento);
		anuncio.setMunicipio(municipio);
		anuncio.setEmail("juan.amachi@gmail.com");
		anuncio.setText("texto anuncio");
		anuncio.setTitle("titulo anuncio");
		anuncio.setTypeAccount(TypeAccountEnum.PARTICULAR);
		anuncio.setTypeAnuncio(TypeAnuncioEnum.DEMANDS);
		anuncio.setCategory(category);
		anuncioDao.createOrUpdate(anuncio);
		
		CriterioAnuncio criterioAnuncioMarca = new CriterioAnuncio();
		CriterioAnuncioId id = new CriterioAnuncioId();
		id.setAnuncio(anuncio);
		id.setCriterio(criterioMarca);
		criterioAnuncioMarca.setCriterioAnuncioId(id);
		criterioAnuncioMarca.setValuePrincipal(valuePrincipalMarca);
		criterioAnuncioMarca.setValueOptional(valueOptionalMarca);
		criterioAnuncioMarca.setCriterio(criterioMarca);
		criterioAnuncioMarca.setAnuncio(anuncio);
		criterioAnuncioMarca = criterioAnuncioDao.createOrUpdate(criterioAnuncioMarca);
		
		CriterioAnuncio criterioAnuncioCarburant = new CriterioAnuncio();
		CriterioAnuncioId id2 = new CriterioAnuncioId();
		id2.setAnuncio(anuncio);
		id2.setCriterio(criterioCarburant);
		criterioAnuncioCarburant.setCriterioAnuncioId(id2);
		criterioAnuncioCarburant.setValuePrincipal(valuePrincipalCarburant);
		criterioAnuncioCarburant.setValueOptional(valueOptionalCarburant);
		criterioAnuncioCarburant.setCriterio(criterioCarburant);
		criterioAnuncioCarburant.setAnuncio(anuncio);
		criterioAnuncioCarburant = criterioAnuncioDao.createOrUpdate(criterioAnuncioCarburant);
		
		anuncio.addCriterioAnuncios(criterioAnuncioMarca);
		anuncio.addCriterioAnuncios(criterioAnuncioCarburant);
	}
	
	@Test
	public void deleteAnuncioTest() {
		Anuncio anuncio = anuncioDao.findByPK(Anuncio.class, 5l);
		Category category = anuncio.getCategory();
		Set<CriterioAnuncio> criterioAnuncios = anuncio.getCriterioAnuncios();
		for(CriterioAnuncio criterioAnuncio : criterioAnuncios) {
			System.out.print("CRITERIO=" + criterioAnuncio.getCriterio().getIdCriterio() + " : ");
			System.out.println("CATEGORY=" + category.getIdCategory() + " " + category.getName());
			CriterioCategoryId id = new CriterioCategoryId();
			id.setCategory(category);
			id.setCriterio(criterioAnuncio.getCriterio());
			criterioCategoryDao.deleteByPK(CriterioCategory.class, id);
		}
		anuncioDao.delete(anuncio);
	}
	
	public static Category getCategoryBean(Category parentCategory, String name, boolean active) {
		Category category = new Category(parentCategory, name, StatusEnum.ACTIVE);//
		category.setDifficulty(1);
		category.setUserConnexion(getUserConnexionBean());
		return category;
	}
	
	public static UserConnexion getUserConnexionBean() {
		UserConnexion userConnexion = new UserConnexion();
		userConnexion.setCreatedBy("tuma");
		userConnexion.setCreatedDate(new java.util.Date());
		return userConnexion;
	}
}
