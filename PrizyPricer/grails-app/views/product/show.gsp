<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul> 
				<li><a class="home" href="/PrizyPricer/">Home</a></li>
				<li><g:link class="list" action="list">Product list</g:link></li>	
			</ul>
		</div>
		<div class="content scaffold-show" role="main">
			<h1>Product</h1>
			<ol class="property-list price">
				<li class="fieldcontain">
					<span class="property-label">Barcode:</span>
					<span class="property-value" aria-labelledby="productBarcode-label">${barcode}</span>
				</li>
				<li class="fieldcontain">
					<span class="property-label">Name:</span>
					<span class="property-value" aria-labelledby="productBarcode-label">${name}</span>
				</li>
				<li class="fieldcontain">
					<span class="property-label">Description:</span>
					<span class="property-value" aria-labelledby="productBarcode-label">${description}</span>
				</li>
				<li class="fieldcontain">
					<span class="property-label">Average price:</span>
					<span class="property-value" aria-labelledby="productBarcode-label">
						<g:formatNumber number="${avgPrice}" type="currency" currencyCode="USD" />
					</span>
				</li>
				<li class="fieldcontain">
					<span class="property-label">Highest price:</span>
					<span class="property-value" aria-labelledby="productBarcode-label">
						<g:formatNumber number="${highestPrice}" type="currency" currencyCode="USD" />
					</span>
				</li>
				<li class="fieldcontain">
					<span class="property-label">Lowest price:</span>
					<span class="property-value" aria-labelledby="productBarcode-label">
						<g:formatNumber number="${lowestPrice}" type="currency" currencyCode="USD" />
					</span>
				</li>
				<li class="fieldcontain">
					<span class="property-label">Ideal price:</span>
					<span class="property-value" aria-labelledby="productBarcode-label">
						<g:formatNumber number="${idealPrice}" type="currency" currencyCode="USD" />
					</span>
				</li>
				<li class="fieldcontain"> 
					<span class="property-label">Price count:</span>
					<span class="property-value" aria-labelledby="productBarcode-label">${priceCount}</span>
				</li>
			</ol>
		</div>
	</body>
</html>
