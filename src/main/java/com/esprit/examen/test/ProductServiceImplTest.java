package com.esprit.examen.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.services.IProduitService;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

	@Autowired
	IProduitService productService ;
	
	@Autowired
	ProduitRepository productRepositrory;	
	
	@Test
	public void testAddProduct() {
		Produit p = new Produit("ee","product test",15,new Date(),new Date());
		
			Produit savedProduct= productService.addProduit(p);
			assertEquals(p.getIdProduit(),savedProduct.getIdProduit());
			
	
	}
	
	
	@Test
	public void retrieveStock() {
		productRepositrory.findById(1L);
		assertThat(productService.retrieveProduit(1L));

	}
	
	@Test
	public void testRetrieveAllProducts(){
		List<Produit> produits = productService.retrieveAllProduits();
		assertEquals(4,produits.size());
	}
}
