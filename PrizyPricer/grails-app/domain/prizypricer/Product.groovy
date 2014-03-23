package prizypricer

class Product {
    String name
	String description
	String barcode
	static hasMany = [prices: Price]

    static constraints = {
		name blank:false
		description blank:false
		barcode blank:false
    }
    
    static mapping = {
        prices lazy: false
    }
    
}
