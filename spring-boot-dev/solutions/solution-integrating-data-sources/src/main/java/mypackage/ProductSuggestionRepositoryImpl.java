package mypackage;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProductSuggestionRepositoryImpl implements ProductSuggestionRepository {
	
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Collection<ProductSuggestion> getProductSuggestions() {
		String jpql = "select p from ProductSuggestion p";
		TypedQuery<ProductSuggestion> query = entityManager.createQuery(jpql, ProductSuggestion.class);
		return query.getResultList();
	}

	@Override
	public ProductSuggestion getProductSuggestion(long id) {
		return entityManager.find(ProductSuggestion.class, id);
	}

	@Transactional
	@Override
	public long insertProductSuggestion(ProductSuggestion ps) {
		entityManager.persist(ps);
		entityManager.flush();
		return ps.getId();
	}

	@Transactional
	@Override
	public boolean modifyPrice(long id, double newPrice) {
		ProductSuggestion ps = entityManager.find(ProductSuggestion.class, id);
		if (ps == null) {
			return false;
		} else {
			ps.setRecommendedPrice(newPrice);
			return true;
		}
	}

	@Transactional
	@Override
	public boolean modifySales(long id, long newSales) {
		ProductSuggestion ps = entityManager.find(ProductSuggestion.class, id);
		if (ps == null) {
			return false;			
		} else {
			ps.setEstimatedAnnualSales(newSales);
			return true;
		}
	}

	@Transactional
	@Override
	public void deleteProductSuggestions() {
		Query query = entityManager.createQuery("delete from ProductSuggestion");
		query.executeUpdate();
	}

	@Override
	public int increasePriceForPopularProducts(long sales) {
		String jpql = "update ProductSuggestion " +
				"set recommendedPrice = recommendedPrice*1.1 " +
				"where estimatedAnnualSales >= :s";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("s", sales);
		
		int numRowsAffected = query.executeUpdate();
		return numRowsAffected;
		
	}
	
	

}
