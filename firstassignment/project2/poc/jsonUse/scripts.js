window.addEventListener("load", init, false);
function init() {
	var termsArray = [];
	var definitionArray = [];
	// the AJAX functionality a browser provides via JS
	var xhr = new XMLHttpRequest();
	// when status == 200, the file is loaded successfully
	// the callback will be executed;
	xhr.successCallBack = function() {
		// console.log(xhr.responseText);
		var obj = JSON.parse(xhr.responseText);
		// Show terms on page.
		for(var x = 1; x <= Object.keys(obj).length; x++){
			termsArray[x - 1] = obj[x].term;
			definitionArray[x - 1] = obj[x].definition;
		}
	}
	// hitting a failure
	xhr.failureCallback = function() {
		console.log('Request failed.  Returned status of ' + xhr.status);
	}
	// setting up the file to load
	// this will fail
	// xhr.open('GET', 'data/simple_ajax_1.json');
	xhr.open('GET', 'test.json');
	// setting up the event and wait for the file to load
	// students will look up this event and figure out how to trigger it!
	xhr.onerror = function() {
		console.log("Oh crap! Poop has hit the fan!!");
		console.log("status = " + xhr.status);
	}
	xhr.onload = function() {
		if (xhr.status === 200) {
			xhr.successCallBack();
		}
		else {
			xhr.failureCallback();
		}
	};
	// invoking the AJAX call
	xhr.send();
	function playAgainFunc(){
    var randomArray = [];
    var randomTerm = [];
    var randomDef = [];
		var tempTerms = [];
		var tempDef = [];
		var termArea = document.getElementsByClassName("termArea");
    var defArea = document.getElementsByClassName("defArea");
		var amountOfTermAreas = termArea.length;
		// Fill temp arrays
		do{
      var testRand = Math.floor(Math.random() * termsArray.length) + 1;
      if(!randomArray.includes(testRand)){
        randomArray.push(testRand);
    	}
    }while(randomArray.length < amountOfTermAreas);
		console.log(randomArray);
		for(var x = 0; x < amountOfTermAreas; x++){
			tempTerms[x] = termsArray[randomArray[x]];
			tempDef[x] = definitionArray[randomArray[x]];
		}
		for(var x = 0; x < amountOfTermAreas; x++){
			termsArray.splice(randomArray[x]);
			definitionArray.splice(randomArray[x]);
		}
		for(var x=0; x < tempTerms.length; x++){
			console.log(tempTerms[x] + ": " + tempDef[x]);
		}
    // Randomly sorts 1-5 for putting terms on the page
    do{
      var testRand = Math.floor(Math.random() * amountOfTermAreas);
      if(!randomTerm.includes(testRand)){
        randomTerm.push(testRand);
      }
    }while(randomTerm.length < amountOfTermAreas)
    // Randomly sorts 1-5 for putting definitions on the page
    do{
      var testRand = Math.floor(Math.random() * amountOfTermAreas);
      if(!randomDef.includes(testRand)){
        randomDef.push(testRand);
      }
    }while(randomDef.length < amountOfTermAreas)
    // Displays the array objects on the page.
    for(var x = 0; x < amountOfTermAreas; x++){
			termArea[randomTerm[x]].innerHTML = tempTerms[randomTerm[x]];
			defArea[randomDef[x]].innerHTML = tempDef[randomDef[x]];
		}
	}
	document.getElementById("newTerms").onclick = playAgainFunc;
}
