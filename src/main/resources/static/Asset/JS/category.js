const productContainer = document.querySelector(".grid-container")
const itemTemplate = document.querySelector("#item-box-template")

const brandContainer = document.querySelector("#brand-container")
const brandTemplate = document.querySelector("#brand-template")

const productType = localStorage.getItem('category')


function fillBrand(brand) {
	const box = brandTemplate.content.cloneNode(true)

	const input = box.querySelector("input")
	const label = box.querySelector("label")

	input.id = brand
	input.value = brand
	label.for = brand
	label.textContent = brand

	brandContainer.appendChild(box)
}

if (productType == 'CPU') {
	fillBrand('Intel')
	fillBrand('AMD')
} else if (productType == 'VGA') {
	fillBrand('Asus')
	fillBrand('GIGABYTE')
	fillBrand('MSI')
} else if (productType == 'Mainboard') {
	fillBrand('Asus')
	fillBrand('GIGABYTE')
	fillBrand('MSI')
	fillBrand('NZXT')
} else if (productType == 'RAM') {
	fillBrand('Kingmax')
	fillBrand('TeamGroup')
	fillBrand('SamSung')
	fillBrand('Asus')
	fillBrand('Hynix')
	fillBrand('Corsair')
	fillBrand('Lexar')
	fillBrand('GIGABYTE')
	fillBrand('Crucial')
	fillBrand('Kingston')
	fillBrand('Lexar')
	fillBrand('Gskill')
} else if (productType == 'SSD') {
	fillBrand('SamSung')
	fillBrand('TeamGroup')
	fillBrand('Lexar')
	fillBrand('Intel')
	fillBrand('KimTigo')
	fillBrand('MSI')
	fillBrand('Apacer')
	fillBrand('Adata')
	fillBrand('WD Blue')
} else if (productType == 'PSU') {
	fillBrand('DeepCool')
	fillBrand('Asus')
	fillBrand('Mik')
	fillBrand('Jetek')
	fillBrand('Corsair')
	fillBrand('Seasonic')
	fillBrand('Thermaltake')
	fillBrand('MSI')
	fillBrand('Antec')
	fillBrand('SilverStone')
} else if (productType == 'Case') {
	fillBrand('DeepCool')
	fillBrand('Xigamtek')
	fillBrand('Asus')
	fillBrand('Phanteks')
	fillBrand('NZXT')
	fillBrand('Mik')
	fillBrand('GIGABYTE')
	fillBrand('MSI')
	fillBrand('E-DRA')
	fillBrand('Thermaltake')
} else if (productType == 'Cooler') {
	fillBrand('DeepCool')
	fillBrand('E-DRA')
	fillBrand('Thermaltake')
	fillBrand('ID Cooling')
	fillBrand('Cooler Master')
}

const brandInputs = brandContainer.querySelectorAll("input");

function checkForUpdates() {
	brandInputs.forEach(input => {
		if (input.checked) {
			filterBrand(input.value)
		}
	})
}

function filterBrand(brand) {
	const items = productContainer.querySelectorAll(".grid-item");
	const names = productContainer.querySelectorAll(".title");

	for (var i = 0; i < names.length; i++) {
		const productName = names[i].textContent.toLowerCase()
		const brandName = brand.toLowerCase()
		console.log(productName.includes(brandName))

		const isVisible = names[i].textContent.toLowerCase().includes(brand.toLowerCase());
		items[i].classList.toggle("hide", !isVisible);
	}
}

fetch('http://localhost:8080/gearVn/' + productType)
	.then(res => res.json())
	.then(data => {
		data.map(product => {
			fillData(product)
		})
	})
	.catch(response => {
		console.log(response)
	})

function fillData(product) {
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
}

function ascendSort() {
	productContainer.innerHTML = ''

	fetch('http://localhost:8080/gearVn/' + productType + '/ascend')
		.then(res => res.json())
		.then(data => {
			data.map(product => {
				fillData(product)
			})

			checkForUpdates()
		})
		.catch(response => {
			console.log(response)
		})
}

function descendSort() {
	productContainer.innerHTML = ''

	fetch('http://localhost:8080/gearVn/' + productType + '/descend')
		.then(res => res.json())
		.then(data => {
			data.map(product => {
				fillData(product)
			})

			checkForUpdates()
		})
		.catch(response => {
			console.log(response)
		})
}

function openItem(id) {
	localStorage.setItem('item', id)
	window.location.href = 'http://127.0.0.1:5500/src/main/resources/static/detail.html'
}

