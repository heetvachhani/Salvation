function displayTable(data) {
	$('#result').show();

	data.forEach(function(jsonData) {
		let trEle = document.createElement("TR");
		for (let key in jsonData) {
			if (jsonData.hasOwnProperty(key)) {
				trEle.appendChild(createCell(jsonData[key]));
			}
		}
		$('#resultTable tbody').append(trEle);
	});
}

function createCell(cellData) {
	let tdEle = document.createElement("TD");
	tdEle.appendChild(document.createTextNode(cellData));
	return tdEle;
}
