function getResponse(){
  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", "http://localhost:8080/WebProject_war/login?username="+document.getElementById("username").value()+"&password="+document.getElementById("password").value(), true);
  xhttp.addEventListener( "load", function(event) {
    alert( event.target.responseText );
  } );
  xhttp.addEventListener( "error", function( event ) {
    alert( event );
  } );
  xhttp.send();
}

 
