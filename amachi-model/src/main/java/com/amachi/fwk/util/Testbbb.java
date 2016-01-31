package com.amachi.fwk.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.amachi.fwk.model.Anuncio;
import com.amachi.fwk.model.Category;
import com.amachi.fwk.model.Criterio;
import com.amachi.fwk.model.CriterioAnuncio;
import com.amachi.fwk.model.CriterioAnuncioId;
import com.amachi.fwk.model.CriterioCategory;
import com.amachi.fwk.model.CriterioValue;
import com.amachi.fwk.model.CriterioValueChild;
import com.amachi.fwk.model.Departamento;
import com.amachi.fwk.model.Grupo;
import com.amachi.fwk.model.ImageAnuncio;
import com.amachi.fwk.model.Municipio;
import com.amachi.fwk.model.Pays;
import com.amachi.fwk.model.Role;
import com.amachi.fwk.model.User;
import com.amachi.fwk.model.UserConnexion;
import com.amachi.fwk.model.UserGrupo;
import com.amachi.fwk.model.UserRole;




/**
 * Testbbb
 * @author admin
 * @date 2014-02-15
 *
 */
public class Testbbb {



	/**
	 * Method main
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		//SessionFactory factory = config.buildSessionFactory();
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(UserRole.class);
		configuration.addAnnotatedClass(UserGrupo.class);
		
		configuration.addAnnotatedClass(Grupo.class);
		configuration.addAnnotatedClass(Role.class);
		configuration.addAnnotatedClass(User.class);
		
		configuration.addAnnotatedClass(Municipio.class);
		configuration.addAnnotatedClass(Departamento.class);
		configuration.addAnnotatedClass(Pays.class);
		
		configuration.addAnnotatedClass(CriterioCategory.class);
		configuration.addAnnotatedClass(CriterioAnuncio.class);
		
		configuration.addAnnotatedClass(Category.class);
		
		configuration.addAnnotatedClass(CriterioValue.class);
		configuration.addAnnotatedClass(CriterioValueChild.class);
		configuration.addAnnotatedClass(Criterio.class);
		
		configuration.addAnnotatedClass(ImageAnuncio.class);
		configuration.addAnnotatedClass(Anuncio.class);
		
//		//configuration.addAnnotatedClass(CriterioCategory.class);
		
//		//configuration.addAnnotatedClass(Valor.class);
		
//		configuration.addAnnotatedClass(AccountType.class);
//		configuration.addAnnotatedClass(AdType.class);
		
        configuration.configure("hibernate.cfg.xml");
        
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        //ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        new SchemaExport(configuration).create(true, true);
        
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		session.beginTransaction();

		//saveTableCategory(session);
//		saveTableFieldProperty(session);
		//saveCriteriaCategory(session);
		
		
		//saveAdvertisement(session);
		
		
//		Pays pays = new Pays();
//		pays.setPaysName("Bolivia");
//		pays.setPaysId(1);
		//Pays pays = (Pays) session.load(Pays.class, 1);
		//pays = (Pays) session.merge(pays);
		
//		Departamento dep = new Departamento();
//		dep.setDtoName("La Paz");
//		dep.setPays(pays);
//		
//		UserConnexion userConnexion = new UserConnexion();
//		userConnexion.setCreatedBy("tuma");
//		userConnexion.setCreatedDate(new java.util.Date());
//		pays.setUserConnexion(userConnexion);
//		
//		Departamento dep2 = new Departamento();
//		dep2.setDtoName("Beni");
//		dep2.setPays(pays);
//		List<Departamento> listDep = new ArrayList<Departamento>();
//		listDep.add(dep);
//		listDep.add(dep2);
//		pays.setDepartamentos(listDep);
//		dep.setUserConnexion(userConnexion);
//		dep2.setUserConnexion(userConnexion);
//		
//		Municipio municipio = new Municipio();
//		municipio.setMunName("Sorata");
//		municipio.setDepartamento(dep);
//		municipio.setUserConnexion(userConnexion);
//		dep.getMunicipios().add(municipio);
//		session.save(pays);
		//session.delete(pays);

		session.getTransaction().commit();
		System.exit(0);
		
	}
	
	private static void saveAdvertisement(Session session) {
		Category cat = getCategoryBean(null, "Voitures", true);
		session.save(cat);
		
		Anuncio ad = new Anuncio();
		ad.setTitle("titulo");
		ad.setName("name");
		ad.setText("texto del ad");
		ad.setEmail("juan@toto.com");
		ad.setTypeAccount(TypeAccountEnum.PARTICULAR);
		ad.setTypeAnuncio(TypeAnuncioEnum.DEMANDS);
		ad.setDatePublication(new Timestamp(new Date().getTime()));
		ad.setStatus(StatusEnum.ACTIVE);
		//ad.setCategory(cat);
		//ad.getAdvertisementCriterias().add(adCri);
		//session.save(ad);
		
		
		Criterio crit = new Criterio();
		crit.setName("Marca");
		//crit.setTypeData("String");
		crit.setUserConnexion(getUserConnexionBean());
		//TODO
		//crit.getCategories().add(cat);		
		
		CriterioValue criteriaValueBmw = new CriterioValue();
		criteriaValueBmw.setName("BMW");
		criteriaValueBmw.setCriterio(crit);
		CriterioValueChild valueChild = new CriterioValueChild("BMW", "Serie 1");
		criteriaValueBmw.getValues().add(valueChild);
		valueChild = new CriterioValueChild("BMW", "Serie 3");
		criteriaValueBmw.getValues().add(valueChild);
		valueChild = new CriterioValueChild("BMW", "M5");
		criteriaValueBmw.getValues().add(valueChild);
		
		CriterioValue criteriaValueFord = new CriterioValue();
		criteriaValueFord.setName("FORD");
		criteriaValueFord.setCriterio(crit);
		valueChild = new CriterioValueChild("FORD", "F450");
		criteriaValueFord.getValues().add(valueChild);
		
		valueChild = new CriterioValueChild("FORD", "Focus");
		criteriaValueFord.getValues().add(valueChild);
		
		crit.getCriterioValues().add(criteriaValueBmw);
		crit.getCriterioValues().add(criteriaValueFord);
		
		session.save(criteriaValueBmw);
		session.save(criteriaValueFord);
		session.save(crit);
		
		
		
		CriterioAnuncio adCri = new CriterioAnuncio();
		CriterioAnuncioId id = new CriterioAnuncioId();
		id.setAnuncio(ad);
		id.setCriterio(crit);
		adCri.setCriterioAnuncioId(id);
		adCri.setValuePrincipal("BMW");
		adCri.setValueOptional("option BMW");
		adCri.setCriterio(crit);
		adCri.setAnuncio(ad);

		
		ad.getCriterioAnuncios().add(adCri);
		//ad.getValores().add(valor);
		
		session.save(ad);
		session.save(adCri);
			
	}

	private static void saveCriteriaCategory(Session session) {
		Criterio criteria = new Criterio();
		criteria.setName("Energy");
		criteria.setDescription("description");
		//criteria.setTypeData("String");
		criteria.setTypeCriterio(TypeCriterioEnum.SINGLE);
		criteria.setUserConnexion(getUserConnexionBean());
		
		criteria.getCriterioValues().add(null);
		
		Category catParent = getCategoryBean(null, "Vehicule", true);
		//catParent.getCriterias().add(criteria);
		//criteria.getCategories().add(catParent);
		session.save(criteria);
		session.save(catParent);
		
		Category catEnfant = getCategoryBean(catParent, "Voiture", true);
		//catEnfant.getCriterias().add(criteria);
//		session.save(criteria);
//		session.save(catEnfant);
	}

	private static void saveTableCriteria(Session session) {
		Criterio criteria = new Criterio();
		criteria.setName("Energy");
		criteria.setDescription("description");
		criteria.setUserConnexion(getUserConnexionBean());
		criteria.getCriterioValues().add(null);
		session.save(criteria);
	}

	private static void saveTableCategory(Session session) {
		Category category = new Category(null, "Sport", StatusEnum.ACTIVE);
		category.setDifficulty(1);
		category.setUserConnexion(getUserConnexionBean());
		
		session.save(category);
		
//		Category futCat = new Category(category, "Futbol", true);
//		futCat.setDifficulty(2);
//		futCat.setUserConnexion(getUserConnexionBean());
//		session.save(futCat);
//		
//		Category futSalon= new Category(futCat, "FutbolSalon", true);
//		futSalon.setDifficulty(2);
//		futSalon.setUserConnexion(getUserConnexionBean());
//		session.save(futSalon);
//		
//		Category hockeyCat = new Category(category, "Hockey", true);
//		hockeyCat.setDifficulty(2);
//		hockeyCat.setUserConnexion(getUserConnexionBean());
//		session.save(hockeyCat);
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
