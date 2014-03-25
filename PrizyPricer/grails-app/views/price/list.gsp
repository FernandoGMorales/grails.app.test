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
		<div class="nav">
			<formset>
				<legend>Search by barcode</legend>
				<g:form action="listFiltered">
					<g:textField name="barcode"/>
					<g:submitButton name="search" value="Search"/>
				</g:form>
			</formset>
		</div>
		<h1>Select the product in order to add the price</h1>
		<div>
			<table>
				<tr>
					<th>Barcode</th>
					<th>Name</th>
					<th>Description</th>
				</tr>
				<g:each in="${productList}" var="product">
					<tr>
						<td><a href="${createLink(action:'create', params:[barcode:product.barcode])}">${product.barcode}</a></td>
						<td>${product.name}</td>
						<td>${product.description}</td>
					</tr>
				</g:each>
			</table>
		</div>
		<div class="pagination">
			<g:paginate controller="price" total="${productCount}"/>
		</div>
	</body>
</html>
