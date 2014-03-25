package prizypricer

class ProductService {

	Product getProductByID(Long productID) {
		return Product.get(productID)
	}

	Integer getProductCount() {
		return Product.count()
	}
	
	List getAllProducts(Map params) {
		return Product.list(params)
	}
	
	Product findByBarcode(String barcode) {
		return Product.findByBarcode(barcode)
	}
	
	Product saveProduct(Product product) {
		return product.save()
	}
	
    List getPrices(Product product) {
		def list = new ArrayList()
		for(price in product.prices) {
			list.add(price.price)
		}
		return list
    }
    
}
