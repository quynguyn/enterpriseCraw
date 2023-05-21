const productContainer = document.querySelector(".grid-container")
const itemTemplate = document.querySelector("#item-box-template")

const productType = localStorage.getItem('category')

fetch('http://localhost:8080/gearVn/' + productType + '/ascend')
	.then(res => res.json())
	.then(data => {
		data.map(product => {
			const box = itemTemplate.content.cloneNode(true).children[0]
			box.id = product._id
			// box.onclick = () => openItem(box.id)

			const name = box.querySelector("#title")
			// const price = box.querySelector(".price")
			const image = box.querySelector("#product-img")
			const button = box.querySelector("#info-button")

			name.textContent = product.fullname
			// price.textContent = '$' + product.price
			image.src = product.img
			button.onclick = () => openItem(product._id)

			productContainer.appendChild(box)
		})
		// console.log(data)
	})
	.catch(response => {
		console.log(response)
	})

	

function openItem(id) {
	localStorage.setItem('item', id)
	window.location.href = 'http://127.0.0.1:5500/src/main/resources/static/detail.html'
}

