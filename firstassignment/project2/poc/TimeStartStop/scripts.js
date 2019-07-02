window.addEventListener("load", init, false)
function init(){
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
      var minutes = Math.floor(time/60);
      var seconds = time - minutes * 60;
      var totalTimeElapsed = (zeroFill(minutes) + ":" + zeroFill(seconds));
      document.getElementById("timeElapsed").innerHTML = totalTimeElapsed;
      time++;
    }
  }
  function stopTime() {
    clearInterval(testVar);
  }
  function toggleTimeFunc(){
    var valueOfButton = document.getElementById("toggleTime").innerHTML;
    console.log(valueOfButton);
    if(valueOfButton == "Pause"){
      stopTime();
      document.getElementById("toggleTime").innerHTML = "Start";
    }else{
      startTime();
      document.getElementById("toggleTime").innerHTML = "Pause";
    }
  }
  document.getElementById("toggleTime").onclick = toggleTimeFunc;
}
