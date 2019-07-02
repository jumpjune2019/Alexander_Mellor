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
    if(e.target.innerHTML === ""){
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
}
