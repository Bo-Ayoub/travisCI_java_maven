package pack;
import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;
    

    public ProduitService() {
        this.produits = new ArrayList<>();
    }
    
    // get all 
    public List<Produit> getAllProduct() {
        return new ArrayList<>(this.produits);
    }

    
    // Create
    public void ajouterProduit(Produit produit) {
        if (!produitExiste(produit.getId()) && !nomProduitExiste(produit.getNom())) {
            if (produit.getPrix() >= 0 && produit.getQuantite() >= 0) {
                produits.add(produit);
            } else {
                throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
            }
        } else {
            throw new IllegalStateException("Un produit avec le même ID ou nom existe déjà.");
        }
    }

    public boolean produitExiste(long id) {
        return produits.stream().anyMatch(produit -> produit.getId() == id);
    }

    public boolean nomProduitExiste(String nom) {
        return produits.stream().anyMatch(produit -> produit.getNom().equals(nom));
    }
    
    // Read
    public Produit trouverProduitParId(long id) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        throw new IllegalArgumentException("Produit non trouvé avec l'ID : " + id);

    }
    
    //update 
    public void mettreAjourProduit(Produit _produit) {
        Produit produit = trouverProduitParId(_produit.getId());
        if (produit == null) {
            throw new IllegalArgumentException("product non trouvé");
        }

        if (_produit.getPrix() < 0 || _produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
        }

        produit.setNom(_produit.getNom());
        produit.setPrix(_produit.getPrix());
        produit.setQuantite(_produit.getQuantite());
    }
    //delete
    public void deleteProduit(Long id) {
    	
        for (Produit _produit : produits) {
            if (_produit.getId()==id) {
            	
                produits.remove(_produit); 
                break;
                
            }
        }

    }

  
}
