package prizypricer

class ProductController {
	static final int MAX_RESULTS = 5
	ProductService productService
	def idealPriceService
    static scaffold = false
    //static Script script = new GroovyShell().parse(new File("scripts/formula.groovy"))
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
	
	def show() {
		def product = productService.findByBarcode(params.barcode)
		if(product!=null) {
			def avgPrice = 0
			def highestPrice = 0
			def lowestPrice = 0
			def priceCount = 0
			def idealPrice = 0
			def priceList = productService.getPrices(product);
			if(priceList!=null && !priceList.isEmpty()) {
				avgPrice = priceList.sum()/priceList.size()
				highestPrice = priceList.max()
				lowestPrice = priceList.min()
				priceCount = priceList.size()
				idealPrice = idealPriceService.apply(priceList)
			}
			else 
				log.info('Price list is either null or empty!')
			def model = [name:product.name, barcode:product.barcode, description:product.description, avgPrice:avgPrice, 
					highestPrice:highestPrice, lowestPrice:lowestPrice, priceCount:priceCount, idealPrice:idealPrice]
			return model
		}
		else {
			log.error('Cannot find product with barcode: ' + params.barcode)
			redirect action: 'list'
		}
	}
    
}
