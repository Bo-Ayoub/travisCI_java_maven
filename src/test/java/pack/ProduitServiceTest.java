package pack;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProduitServiceTest {
    private ProduitService produitService;

    @Before
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testAjouterProduit() {
        Produit produit = new Produit();
        produit.setId(1);
        produit.setNom("Produit1");
        produit.setPrix(10.0);
        produit.setQuantite(5);

        produitService.ajouterProduit(produit);
        assertTrue(produitService.produitExiste(1));

        try {
            produitService.ajouterProduit(produit);
            fail("Devrait lancer une IllegalStateException");
        } catch (IllegalStateException e) {
        }
        
      

        
        Produit produitPrixNegatif = new Produit();
        produitPrixNegatif.setId(2);
        produitPrixNegatif.setNom("Produit2");
        produitPrixNegatif.setPrix(-5.0);
        produitPrixNegatif.setQuantite(3);
        try {
            produitService.ajouterProduit(produitPrixNegatif);
            fail("Devrait lancer une IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }

        Produit produitQuantiteNegatif = new Produit();
        produitQuantiteNegatif.setId(3);
        produitQuantiteNegatif.setNom("Produit3");
        produitQuantiteNegatif.setPrix(8.0);
        produitQuantiteNegatif.setQuantite(-2);
        try {
            produitService.ajouterProduit(produitQuantiteNegatif);
            fail("Devrait lancer une IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testTrouverProduitParId() {
        Produit produit1 = new Produit();
        produit1.setId(1);
        produit1.setNom("Produit1");
        produit1.setPrix(10.0);
        produit1.setQuantite(5);

        Produit produit2 = new Produit();
        produit2.setId(2);
        produit2.setNom("Produit2");
        produit2.setPrix(15.0);
        produit2.setQuantite(8);

        produitService.ajouterProduit(produit1);
        produitService.ajouterProduit(produit2);

        assertEquals(produit1, produitService.trouverProduitParId(1));

        try {
            produitService.trouverProduitParId(3);
            fail("Devrait lancer une IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }
    }

    @Test
    public void testProduitExiste() {
        Produit produit1 = new Produit();
        produit1.setId(1);
        produit1.setNom("Produit1");
        produit1.setPrix(10.0);
        produit1.setQuantite(5);

        produitService.ajouterProduit(produit1);

        assertTrue(produitService.produitExiste(1));

        assertFalse(produitService.produitExiste(2));
    }

    @Test
    public void testNomProduitExiste() {
        Produit produit1 = new Produit();
        produit1.setId(1);
        produit1.setNom("Produit1");
        produit1.setPrix(10.0);
        produit1.setQuantite(5);

        produitService.ajouterProduit(produit1);

        assertTrue(produitService.nomProduitExiste("Produit1"));

        assertFalse(produitService.nomProduitExiste("Produit2"));
    }
    @Test
    public void testAjouterProduitWithValidData() {
        Produit produit = new Produit();
        produit.setId(1);
        produit.setNom("Produit1");
        produit.setPrix(10.0);
        produit.setQuantite(5);

        produitService.ajouterProduit(produit);

        assertTrue(produitService.produitExiste(1));
    }
    
    @Test
    public void testAjouterProduitWithZeroPrixAndQuantite() {
        Produit produit = new Produit();
        produit.setId(1);
        produit.setNom("Produit1");
        produit.setPrix(0.0);
        produit.setQuantite(0);

        produitService.ajouterProduit(produit);

        assertTrue(produitService.produitExiste(1));
    }
    @Test
    public void testAjouterProduitWithZeroPrixOrQuantite() {
        Produit produitZeroPrix = new Produit();
        produitZeroPrix.setId(1);
        produitZeroPrix.setNom("ProduitZeroPrix");
        produitZeroPrix.setPrix(0.0);
        produitZeroPrix.setQuantite(5);

        Produit produitZeroQuantite = new Produit();
        produitZeroQuantite.setId(2);
        produitZeroQuantite.setNom("ProduitZeroQuantite");
        produitZeroQuantite.setPrix(10.0);
        produitZeroQuantite.setQuantite(0);

        produitService.ajouterProduit(produitZeroPrix);
        produitService.ajouterProduit(produitZeroQuantite);

        assertTrue(produitService.produitExiste(1));
        assertTrue(produitService.produitExiste(2));
    }
    
    
    

    
    
    
    
    
    

}
