<!DOCTYPE html>
<html>
<head>
<meta name="google-signin-client_id"
	content="829531720886-70786br6h9df1as2a0o05k4q7t50us7b.apps.googleusercontent.com">
</head>
<body>
	<div id="my-signin2"></div>
	<script>
  function redirect (){
      window.location.assign("http://localhost:8080/home");
  }
     function onSuccess(googleUser) {
      console.log('Logged in as: ' + googleUser.getBasicProfile().getName());

      var xhr = new XMLHttpRequest();
      xhr.open('POST', 'http://localhost:8080/abc');
      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.onload = function() {
        console.log('Signed in as: ' + xhr.responseText);
      };
      xhr.send(googleUser.getAuthResponse().id_token);
      redirect ()

    }
    function onFailure(error) {
      console.log(error);
    }
    
    function renderButton() {
      gapi.signin2.render('my-signin2', {
        'scope': 'profile email',
        'width': 240,
        'height': 50,
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure
      });
    } 
  </script>

	<script
		src="https://apis.google.com/js/platform.js?onload=renderButton" async
		defer></script>
	<dev id="tmp"></dev>
</body>
</html>