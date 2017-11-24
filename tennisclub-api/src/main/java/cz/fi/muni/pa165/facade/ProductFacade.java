package cz.fi.muni.pa165.facade;

import java.util.List;

import com.frenchies.tennisclub.dto.CategoryDTO;
import com.frenchies.tennisclub.dto.NewPriceDTO;
import com.frenchies.tennisclub.dto.ProductChangeImageDTO;
import com.frenchies.tennisclub.dto.ProductCreateDTO;
import com.frenchies.tennisclub.dto.ProductDTO;

public interface ProductFacade {
	public Long createProduct(ProductCreateDTO p);
	public void addCategory(Long productId, Long categoryId);
	public void removeCategory(Long productId, Long categoryId);
	public void changePrice(NewPriceDTO newPrice);
	public void deleteProduct(Long productId);
	public List<ProductDTO> getAllProducts();
	public List<ProductDTO> getProductsByCategory(String categoryName);
	public ProductDTO getProductWithId(Long id);
	public void changeImage(ProductChangeImageDTO productChange);

}
