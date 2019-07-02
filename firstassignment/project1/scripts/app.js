//This file initializes the framework of code to create the applets.
function init () {
	// Variables to create new model objects from the model.js file.
	var model1 = new Model();
	var model2 = new Model();
	// Gets the two divs by id and assigns them to variables.
	var app1 = document.getElementById('app1');
	var app2 = document.getElementById('app2');
	//
	var layout = View.getLayout();
	//
	app1.innerHTML = layout;
	app2.innerHTML = layout;
	//
	var ctrl1 = new Controller();
	var ctrl2 = new Controller();
	//
	ctrl1.init(app1, model1, View);
	ctrl2.init(app2, model2, View);
}
