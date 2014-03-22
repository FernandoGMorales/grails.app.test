package prizypricer

class PriceController {
	static scaffold = true
	
	def index() {
		redirect(action:"list")
	}
	
	def list() {
		params.max = ProductController.MAX_RESULTS
		params.sort = "barcode"
		params.order = "asc"
		def productCount = Product.count()
		def productList = Product.list(params) 
		[productList:productList, productCount:productCount]
	}
	
	def search() {
	}
	
	def create() {
		def product = Product.findByBarcode(params.barcode)
		log.error(product)
		if(product!=null) 
			[productID:product.id, name:product.name, barcode:product.barcode, description:product.description]
		else redirect action: 'list'	
	}
	
	def save() {
		Product product = Product.get(params.productID)
		if(product!=null) {
			Price price = new Price()
			println(params.price)
			println(params.store)
			println(params.notes)
			price.setPrice(params.price as Float)
			price.setStore(params.store)
			price.setNotes(params.notes)
			price.setDate(new Date())
			product.addToPrices(price)
			if(!product.save()) 
				println("Error!")
		}
		redirect action: 'list'
	}
	
}
