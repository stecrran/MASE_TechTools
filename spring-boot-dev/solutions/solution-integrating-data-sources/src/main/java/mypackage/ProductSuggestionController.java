package mypackage;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/productSuggestions")
@CrossOrigin
public class ProductSuggestionController {

	@Autowired
	private ProductSuggestionCrudRepository productSuggestionCrudRepository;
	
	@Autowired
	private ProductSuggestionRepositoryImpl productSuggestionRepositoryImpl;
	
	@GetMapping
	public ResponseEntity<Iterable<ProductSuggestion>> getProductSuggestions(){
		Iterable<ProductSuggestion> productSuggestions = productSuggestionCrudRepository.findAll();
		return ResponseEntity.ok().body(productSuggestions);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductSuggestion> getProductSuggestion(@PathVariable long id){
		Optional<ProductSuggestion> ps = productSuggestionCrudRepository.findById(id);
		if (ps.isEmpty()) {
			return ResponseEntity.notFound().build();	
		}
		else {
			return ResponseEntity.ok().body(ps.get());
		}
	}
	
	@PostMapping
	public ResponseEntity<ProductSuggestion> addProductSuggestion(@RequestBody ProductSuggestion productSuggestion){
		productSuggestion = productSuggestionCrudRepository.save(productSuggestion);
		URI uri = URI.create("/productSuggestions" + productSuggestion.getId());
		return ResponseEntity.created(uri).body(productSuggestion);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductSuggestion> deleteProductSuggestion(@PathVariable long id){
		if (productSuggestionCrudRepository.findById(id) != null) {
			productSuggestionCrudRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
}
