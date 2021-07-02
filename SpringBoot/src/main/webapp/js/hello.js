console.log("Xin chào");
const url = "http://localhost:8080/SpringBoot/demo-api";
fetch(url)
	.then(function (response) {
		return response.text()
	})
	.then(function (data) {
		console.log(data)
	})