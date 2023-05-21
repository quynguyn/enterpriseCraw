const item = localStorage.getItem('item')

fetch('http://localhost:8080/gearVn/category/' + item)
	.then(res => res.json())
	.then(data => {
		console.log(data)
		const name = document.querySelector(".product-name")
		const price = document.querySelector(".price")
		const image = document.querySelector(".product-images img")
		const gearPrice = document.querySelector("#gearvn-price .price")
		const hacomPrice = document.querySelector("#hacom-price .price")
		const memoryzonePrice = document.querySelector("#memoryzone-price .price")
		const techzonesPrice = document.querySelector("#techzones-price .price")

		name.textContent = data.fullname
		price.textContent = data.price + 'đ'
		gearPrice.textContent = data.price + 'đ'
		image.src = data.img
		console.log()

		fetch("http://localhost:8080/product/" + data.shortname.replaceAll(" ", "%20"))
			.then(res => res.json())
			.then(data => {
				data.map((product => {
					console.log(product.web)
					if (product.web == 'techzones') {
						techzonesPrice.textContent = product.price + 'đ'
					}
				}))
			})
	})



