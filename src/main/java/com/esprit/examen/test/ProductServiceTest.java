package com.esprit.examen.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.services.ProduitServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	ProduitRepository productRepository;
	@Autowired
	ProduitServiceImpl productService;
	
	@Test
	public void testAddProduct() {
	Produit p = new Produit(null, "ee","product test",10, null, null, null, null, null);
		
			Produit savedProduct= productService.addProduit(p);
			assertEquals(p.getIdProduit(),savedProduct.getIdProduit());
			
	
	}
	
	@Test
	public void retrieveProduit() {
		productRepository.findById(2L);
		assertThat(productService.retrieveProduit(2L));

	}
	
	@Test
	public void testRetrieveAllProducts(){
		List<Produit> produits = productService.retrieveAllProduits();
		assertEquals(5,produits.size());
	}
	

	
}
