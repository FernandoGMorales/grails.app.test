package prizypricer

class Product {
    String name
	String description
	String barcode
	static hasMany = [prices: Price]

    static constraints = {
    }
    
}
