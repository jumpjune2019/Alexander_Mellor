$.ready(function() {
	$.get('title').innerHTML = $.string.format("Quiz Game {0}", $.getVersion());
});
window.addEventListener("load", init, false)
function init(){
	var stackID = [];
	var stackAF = [];
	var stackData = [];
	var scoreDataArray = [];
	document.getElementById("getScore").style.display = "none";
	document.getElementById("playAgain").style.display = "none";
	//
	// JSON integration
	//
	// Code for JSON integration.
	// the AJAX functionality a browser provides via JS
	var xhr = new XMLHttpRequest();
	// when status == 200, the file is loaded successfully
	// the callback will be executed;
	xhr.successCallBack = function() {
		// console.log(xhr.responseText);
		var obj = JSON.parse(xhr.responseText);
    // Show terms on page.
    var termArea = document.getElementsByClassName("termWidget");
    var defArea = document.getElementsByClassName("definitionText");
    var amountOfTermAreas = termArea.length;
    var x = 0;
    var randomArray = [];
    var randomTerm = [];
    var randomDef = [];
    // Create an array of random numbers to show a random term from JSON
    do{
      var testRand = Math.floor(Math.random() * Object.keys(obj).length) + 1;
      if(!randomArray.includes(testRand)){
        randomArray.push(testRand);
      }
    }while(randomArray.length < amountOfTermAreas);
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
    // Displays the json objects on the page.
    for(var key in obj){
      termArea[randomTerm[x]].innerHTML = obj[randomArray[x]].term;
      defArea[randomDef[x]].innerHTML = obj[randomArray[x]].definition;
			// scoreDataArray.push({
			// 	key: obj[randomArray[x]].term,
			// 	value: obj[randomArray[x]].definition
			// })
			scoreDataArray[obj[randomArray[x]].definition] = obj[randomArray[x]].term;
      x++;
      if(x >= 5){
        break;
      }
    }
	}
	// hitting a failure
	xhr.failureCallback = function() {
		console.log('Request failed.  Returned status of ' + xhr.status);
	}
	// setting up the file to load
	// this will fail
	// xhr.open('GET', 'data/simple_ajax_1.json');
	xhr.open('GET', 'data/definitions.json');
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
	//
	// Code for drag and drop functionality.
	//
  var dragItem = document.getElementsByClassName("termWidget");
  var dropArea = document.getElementsByClassName("definitionWidget");
  function startDragItemFunc(e) {
    e.dataTransfer.setData("text", e.target.id);
  }
  function dropItemFunc(e) {
    e.preventDefault();
    var data = e.dataTransfer.getData("text");
    var dragEl = document.getElementById(data)
		if(e.target.innerHTML === "Place your answer here."){
      stackData.push(dragEl.innerHTML);
      stackID.push(data);
      stackAF.push(e.target.id);
      e.target.innerHTML = dragEl.innerHTML;
      dragEl.innerHTML = "";
    }
  }
  function dragOverItemFunc(e) {
    e.preventDefault();
  }
  for(var i = 0; i < dragItem.length; i++){
    dragItem[i].addEventListener("dragstart", startDragItemFunc, false);
  }
  for(var i = 0; i < dropArea.length; i++){
    dropArea[i].addEventListener("drop", dropItemFunc, false);
  }
  for(var i = 0; i < dropArea.length; i++){
    dropArea[i].addEventListener("dragover", dragOverItemFunc, false);
  }
	//
	// Timer functionality
	//
	var testVar
  var time = 1;
  function startTime() {
    var myVar = testVar = setInterval(myTimer, 1000);
    function myTimer() {
      function zeroFill(num){
        // zeroFill function found on stackoverflow authored by Peter Bailey
        var width = 2;
        width -= num.toString().length;
        if(width > 0){
          return new Array( width + (/\./.test( num ) ? 2 : 1) ).join( '0' ) + num;
        }
        return num + "";
      }
			var hours = Math.floor(time/3600);
      var minutes = Math.floor(time/60) - (hours * 60);
      var seconds = time - (hours * 3600 + minutes * 60);
      var totalTimeElapsed = (zeroFill(hours) + ":" + zeroFill(minutes) + ":" + zeroFill(seconds));
      document.getElementById("elapsedTime").innerHTML = totalTimeElapsed;
      time++;
    }
  }
  function stopTime() {
    clearInterval(testVar);
  }
  function toggleTimeFunc(){
    var valueOfButton = document.getElementById("toggleTime").innerHTML;
    if(valueOfButton == "Pause"){
      stopTime();
			for(var x = 0; x < dragItem.length; x++){
				dragItem[x].setAttribute("draggable",false);
			}
			document.getElementById("getScore").style.display = "inline";
      document.getElementById("toggleTime").innerHTML = "Resume";
    }else{
      startTime();
			for(var x = 0; x < dragItem.length; x++){
				dragItem[x].setAttribute("draggable",true);
			}
			document.getElementById("getScore").style.display = "none";
      document.getElementById("toggleTime").innerHTML = "Pause";
    }
  }
  document.getElementById("toggleTime").onclick = toggleTimeFunc;
	//
	// Undo function
	//
	// Developed from code snippet courtesy of David Loughran
	function undoFunc(){
    //items are added to stacks through the drop() function. This function simply removes that data from the stacks when called
    //stores information from stacks within temp variables
    var getID = stackID.pop();
  	var getData = stackData.pop();
  	var AFID = stackAF.pop();
    //sets information at target div to original value
  	document.getElementById(getID).innerHTML = getData;
    //re-enables the drag feature on target div
  	document.getElementById(getID).setAttribute('draggable', true);
    //replaces the information at at target div to original value
  	document.getElementById(AFID).innerHTML = "Place your answer here.";
  }
  document.getElementById("undo").onclick = undoFunc;
	//
	// Scoring Functionality
	//
	function getScoreFunc(){
		document.getElementById("playAgain").style.display = "inline";
		document.getElementById("getScore").style.display = "none";
		document.getElementById("toggleTime").style.display = "none";
		document.getElementById("undo").disabled = true;
		var total = document.getElementsByClassName("termWidget").length;
		var score = 0;
		var defArea = document.getElementsByClassName("definitionText");
		var termArea = document.getElementsByClassName("droppedTerm");
		var definitionControl = [];
		var termControl = [];
		for(var i = 0; i < defArea.length; i++){
			if(scoreDataArray[defArea[i].innerHTML] == termArea[i].innerHTML){
				score++
				defArea[i].style.backgroundColor = "#00ff00";
				termArea[i].style.backgroundColor = "#00ff00";
			}else{
				defArea[i].style.backgroundColor = "#ff0000";
				termArea[i].style.backgroundColor = "#ff0000";
			}
		}
		document.getElementById("score").innerHTML = ("You Got " + score + "/" + total + " right.")
	}
	document.getElementById("getScore").onclick = getScoreFunc;
	function playAgainFunc(){
		window.location.reload(true);
	}
	document.getElementById("playAgain").onclick = playAgainFunc;
}
