package pack;
import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
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

    private boolean produitExiste(long id) {
        return produits.stream().anyMatch(produit -> produit.getId() == id);
    }

    private boolean nomProduitExiste(String nom) {
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

  
}
