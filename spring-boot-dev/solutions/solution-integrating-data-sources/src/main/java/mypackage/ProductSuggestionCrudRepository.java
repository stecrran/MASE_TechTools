package mypackage;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface ProductSuggestionCrudRepository extends CrudRepository<ProductSuggestion, Long> {

	@Query("UPDATE ProductSuggestion ps SET ps.recommendedPrice = ?2 where ps.id = ?1")
	@Modifying(clearAutomatically=true)
	@Transactional
	int modifyRecommendedPrice(long id, double newPrice);
	
	
	@Query("UPDATE ProductSuggestion ps SET ps.estimatedAnnualSales = ?2 where ps.id = ?1")
	@Modifying(clearAutomatically=true)
	@Transactional
	int modifyAnnualSales(long id, double newEstimatedAnnualSales);
	
	@Query("UPDATE ProductSuggestion SET recommendedPrice = (recommendedPrice*1.1) where estimatedAnnualSales > ?1")
	@Modifying(clearAutomatically=true)
	@Transactional
	int increasePrice(long popularSales);
	
	
}
