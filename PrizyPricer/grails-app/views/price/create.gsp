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
		<div class="content scaffold-create" role="main">
			<h1>Add price</h1>
			<form action>
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
						<span class="property-label">Price:</span>
						<input type="text"></input>
					</li>
					<li class="fieldcontain">
						<span class="property-label">Store:</span>
						<input type="text"></input>
					</li>
					<li class="fieldcontain">
						<span class="property-label">Notes:</span>
						<input type="text"></input>
					</li>
					<li class="fieldcontain">
						<span class="property-label">Date:</span>
						<input type="text"></input>
					</li>
				</ol>
				<input type="submit" value="save"/>
			</form>
		</div>
	</body>
</html>
