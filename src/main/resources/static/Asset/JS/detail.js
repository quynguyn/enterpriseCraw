const item = localStorage.getItem('item')

fetch('http://localhost:8080/gearVns/' + item)
	.then(res => res.json())
	.then(data => {
		console.log(data)
		const name = document.querySelector(".product-name")
		const price = document.querySelector(".price")
		const image = document.querySelector(".product-images img")
		const description = document.querySelector(".description-text")

		name.textContent = data.fullname
		price.textContent = data.price + 'đ'
		image.src = data.img
		description.textContent = data.fullname
	})