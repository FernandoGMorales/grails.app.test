package prizypricer

class Price {
	float price
	String store
	String notes
	Date date
	static belongsTo = [product: Product]

    static constraints = {
		price blank:false
        store blank:false
        notes blank:false
        date blank:false
    }
    
}
