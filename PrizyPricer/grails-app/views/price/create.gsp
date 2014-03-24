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
			<g:form action="save" params="[productID:productID]">
				<fieldset class="form">
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
							<g:field type="number" name="price" min="0" step="0.01" required="true"/>
						</li>
						<li class="fieldcontain">
							<span class="property-label">Store:</span>
							<g:field type="text" name="store" maxlength="20" required="true"/>
						</li>
						<li class="fieldcontain">
							<span class="property-label">Notes:</span>
							<g:field type="text" name="notes" maxlength="20" required="true"/>
						</li>
					</ol>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="save" value="save" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
