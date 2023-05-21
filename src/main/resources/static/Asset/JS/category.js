const productContainer = document.querySelector(".grid-container")
const itemTemplate = document.querySelector("#item-box-template")

const productType = localStorage.getItem('category')

console.log(productType)

fetch('http://localhost:8080/' + productType)
	.then(res => res.json())
	.then(data => {
		data.map(product => {
			// console.log(product)

			const box = itemTemplate.content.cloneNode(true)
			box.id = product._id
			// box.onclick = () => openItem(box.id)

			const name = box.querySelector("#title")
			// const price = box.querySelector(".price")
			const image = box.querySelector("#product-img")

			name.textContent = product.fullname
			// price.textContent = '$' + product.price
			image.src = product.img

			productContainer.appendChild(box)
		})
	})


