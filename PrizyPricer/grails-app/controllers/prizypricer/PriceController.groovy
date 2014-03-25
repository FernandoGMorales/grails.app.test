package prizypricer

class PriceController {
	static scaffold = false
	ProductService productService
	static defaultAction = 'list'
	
	def list() {
		params.max = ProductController.MAX_RESULTS
		params.sort = "barcode"
		params.order = "asc"
		def productCount = productService.getProductCount()
		def productList = productService.getAllProducts(params)
		if(productList==null || productList.isEmpty())
				log.info('Product list is either null or empty!') 
		[productList:productList, productCount:productCount]
	}
	
	def listFiltered() {
		def product = productService.findByBarcode(params.barcode)
		if(product!=null) {
			def productList = new ArrayList()
			productList.add(product)
			if(productList==null || productList.isEmpty())
				log.info('Product list is either null or empty!')
			def model = [productList:productList, productCount:1]
			render(view: "list", model:model)
		}
		else redirect action: 'list'
	}
	
	def create() {
		def product = productService.findByBarcode(params.barcode)
		if(product!=null) 
			[productID:product.id, name:product.name, barcode:product.barcode, description:product.description]
		else {
			log.error('Cannot find product with barcode: ' + params.barcode)
			redirect action: 'list'
		}	
	}
	
	def save() {
		def product = productService.getProductByID(Long.valueOf(params.productID))
		if(product!=null) {
			Price price = new Price()
			price.setPrice(params.price as Float)
			price.setStore(params.store)
			price.setNotes(params.notes)
			price.setDate(new Date())
			product.addToPrices(price)
			if(!productService.saveProduct(product)) 
				log.error('Cannot save product with id: ' + params.productID)
		}
		else 
			log.error('Cannot find product with id: ' + params.productID)
		redirect action: 'list'
	}
	
}
