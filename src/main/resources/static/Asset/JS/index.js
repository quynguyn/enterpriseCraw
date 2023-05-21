function goToCategory(category) {
	localStorage.setItem('category', category);
	console.log(category);
	window.location.href = "category.html";
}