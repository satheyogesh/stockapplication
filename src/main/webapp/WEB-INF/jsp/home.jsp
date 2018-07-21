<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	
<meta name="google-signin-client_id"
	content="829531720886-70786br6h9df1as2a0o05k4q7t50us7b.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>


<script>


function myfun()
{
	// logout from application
	if(gapi.auth2.init().isSignedIn.get())
		{
		gapi.auth.signOut();
		}
	}

function fetchdata(sym){

	  $.ajax({
	        url: "https://api.iextrading.com/1.0/stock/" + sym + "/quote"
	    }).then(function(data) {
			$('.stock-id_' + sym).empty();
			$('.stock-price_'+ sym).empty();
			$('.time_' + sym).empty();
			$('.week52High_'+ sym).empty();
			$('.week52Low_'+ sym).empty();
			$('.peRatio_'+ sym).empty();
			
	       $('.stock-id_'+ sym).append(data.symbol);
	       $('.stock-price_'+ sym).append(data.latestPrice);
		   $('.week52High_'+ sym).append(data.week52High);
	       $('.week52Low_'+ sym).append(data.week52Low);
	       $('.peRatio_'+ sym).append(data.peRatio);
			$( '#hidden_' + sym).show();

		//   var now = new Date(Date.now());
		 //  var formatted = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
	     //  $('.time').append(formatted);

	    });
		
	}
	
function hideDiv(divId)
{
	var id = divId.substring( divId.indexOf('_') + 1 );
	$( '#hidden_' + id).hide();
	$('#btnshow_' + id).show();
	$('#btn_' + id).hide();

}

function showDiv(idname)
{
	// hididing view button
	$('#' + idname).hide();

	var id = idname.substring( idname.indexOf('_') + 1 );
	$('#btn_' + id).show();

    fetchdata(id);

	//var id = divId.substring( divId.indexOf('_') + 1 );
	//$( '#hidden_' + id).hide();
}

/* $(document).ready(function(){
    $(".stockdiv").click(function(evt){
        var idname = $(this).attr("id");
        fetchdata(idname);
    });
 }); */
 
// $(".stockdiv").click(function() {
//     alert($(this).attr('id'));

// 	});
	
function sleep(milliseconds) {
	  var start = new Date().getTime();
	  for (var i = 0; i < 1e7; i++) {
	    if ((new Date().getTime() - start) > milliseconds){
	      break;
	    }
	  }
	}
	
function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
  
  var xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://localhost:8080/abc');
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.send(googleUser.getAuthResponse().id_token);
  xhr.onload = function() {
    console.log('Signed in as: ' + xhr.responseText);
  };

}
  
  </script>
<style>

 .navbarBottom
        {
            border-bottom:3px solid #169FDA;
        }
        
.menuFont{
font-family:verdana; 
color:#169FDA; 
font-weight: 900;
}

.navbarbackground{
background-color:#FEFEFE;
}

.pageBackgroundFacebook{
background-color:#E9EBEE;
}
.pagebackground{
background-color:#F7F9FA;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: auto;
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: auto;
	top: 0;
	left: 0;
	width: 130px;
	z-index: 1;
}

/* Set black background color, white text and some padding */
footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: #555;
	color: white;
	padding: 15px;
	text-align: center;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
		height: 100%;
		top: 0;
		left: 0;
	}
	.row.content {
		height: 100%;
	}
}
</style>
</head>
<body class="pagebackground" onload="myfun()">

<nav class="navbar navbar-expand-sm navbarbackground navbarBottom">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="stock.jpg" alt="logo" style="width:70px;">
  </a>
    <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link menuFont" href="/home"><b>Home</b></a>
    </li>
    <li class="nav-item">
      <a class="nav-link menuFont" href="/movers"><b>Gainers/Loosers</b></a>
    </li>
    <li class="nav-item">
      <a class="nav-link menuFont" href="#"><b>Contact</b></a>
    </li>
  </ul>
</nav>
<br>
	<div class="container-fluid text-center">
		<!--   <div class="row content">
 -->
		<div class="col-sm-8 text-left">
			<h3>Welcome ${sessionScope.firstname}</h3>
			<br>
			<br>
			<!--           <div class="col-xs-3"> -->
			<!--     		<label for="ex2">Search Stock </label>    		  -->
			<!--   		</div>     -->
			<!--   		<input class="form-control" name="stockSearch" type="text"/><input  class="form-control" type="submit" value="Submit"> -->
			<form class="form-inline" action="/quotes" method="post">
				(e.g AAPL,GOOG,MSFT etc.) <br>
				<div class="form-group">
					<label for="search">Search </label> <input type="stockSearch"
						class="form-control" name="stockSearch">
				</div>
				<button type="submit" class="btn btn-default">Search</button>
				<br>
			</form>

			<hr>
			<div class="bs-example">
				<div class="list-group">

					<c:forEach var="icntStock" items="${stockList}">
						<a href="#" class="list-group-item">
							<div id="${icntStock.get1Symbol()}" class="stockdiv">
								<span class="glyphicon glyphicon-stats"></span> Stock : <br>
								<h4>Stock Name : ${icntStock.get1Symbol()} Price
									:${icntStock.get2Price()}</h4>
								<div id="hidden_${icntStock.get1Symbol()}"
									class="${icntStock.get1Symbol()}" style="display: none;">
									<table class="table table-hover">
										<caption>Key Statistics</caption>

										<tr>
											<td>Stock symbol</td>
											<td><p class="stock-id_${icntStock.get1Symbol()}"></p></td>
										</tr>
										<tr>
											<td>Stock price</td>
											<td><p class="stock-price_${icntStock.get1Symbol()}"></p></td>
										</tr>
										<tr>
											<td>52 week high</td>
											<td><p class="week52High_${icntStock.get1Symbol()}"></p></td>
										</tr>
										<tr>
											<td>52 week low</td>
											<td><p class="week52Low_${icntStock.get1Symbol()}"></p></td>
										</tr>
										<tr>
											<td>PE Ratio</td>
											<td><p class="peRatio_${icntStock.get1Symbol()}"></p></td>
										</tr>
									</table>

								</div>
								<button id="btnshow_${icntStock.get1Symbol()}"
									onclick="showDiv(this.id)">View</button>
								<button id="btn_${icntStock.get1Symbol()}"
									onclick="hideDiv(this.id)" style="display: none;">Close</button>

							</div>
						</a>
					</c:forEach>


				</div>

			</div>
		</div>

		<!--   </div>
 -->
	</div>
	<br>
	<br>
	<footer class="container-fluid text-center">
		<p></p>
	</footer>

</body>

</html>