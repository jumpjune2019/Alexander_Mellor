var stackID = [];
var stackAF = [];
var stackData = [];
window.addEventListener("load", init, false)
function init(){
  var dragItem = document.getElementsByClassName("dragObj");
  var dropArea = document.getElementsByClassName("dropObj");
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
}
