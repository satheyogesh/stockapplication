<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<style>
tab1 {
	padding-left: 4em;
}

.round_box{
border-radius:15px;
background-color:#FFFFFF;
border: 1px solid #5DC4FD;
padding:10px 8px; 
}

.pagebackground{
background-color:#FEFEFE;
}

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
</style>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<!--   <meta http-equiv="refresh" content="10" > -->
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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 --><meta name="google-signin-client_id"
	content="829531720886-70786br6h9df1as2a0o05k4q7t50us7b.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>

<script>



function fetchdata(sym){

// "https://newsapi.org/v2/everything?q=" + sym + "&from=2018-07-09&to=2018-07-09&sortBy=popularity&apiKey=0b7f2e734b794910864e1e8ad6e126ef"
	  $.ajax({
	  				type: 'GET',
	  		        url: "https://api.iextrading.com/1.0/stock/" + sym + "/news/last/20" 
	    }).then(function(data) {
	    
	    var  news = "<div><br>";
	    
	    	$.each(data, function (index, value) {
		    	news = news + "<div class='media round_box'>";
		    	news = news + "<p><font face='verdana' color='darkorange'><b>" +  value.source + "&nbsp;&nbsp;&nbsp;</b></font></p>" ;
		    	news = news + "  <div class='media-body'>";
		    	news = news + "  <h5 class='mt-0'>"+ "<a href='" + value.url + "'><font face='verdana'> " + value.headline + "</font></a>" + "</h5>";
		    	news = news + value.summary;
		    	news = news + "</div>";
		    	news = news + "</div><br>";
 		
	//   	news = news + "<div class='well well-sm'>";
	//    	news = news + "<b>" + value.source + "</b><br>" ;
	//    	news = news + "<a href='" + value.url + "'>" + value.headline + "</a>";
    //    	news = news + "</div>";
        	
    		});
        	news = news + "</div>";
			$('#hidden_' + sym).empty();
			$( '#hidden_' + sym).append(news);
			$( '#hidden_' + sym).show();

		//   var now = new Date(Date.now());
		 //  var formatted = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
	     //  $('.time').append(formatted);

	    });
		
	}
	
	
	
function hideNews(idname)
{
		var id = idname.substring( idname.indexOf('_') + 1 );
		$( '#' + idname).hide();
		$( '#hidden_' + id).hide();
		$('#btnNews_' + id).show();
}	
function showNews(idname)
{
	var id = idname.substring( idname.indexOf('_') + 1 );
	    fetchdata(id);
	    $('#btnNewsClose_' + id).show();
		$('#btnNews_' + id).hide();
}



function hideMoversNews(idname)
{
		var id = idname.substring( idname.indexOf('_') + 1 );
		$( '#' + idname).hide();
		$( '#hiddenMovers_' + id).hide();
		$('#btnMoversNews_' + id).show();
}	
function showMoversNews(idname)
{
	var id = idname.substring( idname.indexOf('_') + 1 );
	    fetchMoversData(id);
	    $('#btnMoversNewsClose_' + id).show();
		$('#btnMoversNews_' + id).hide();
}

function fetchMoversData(sym){

	  $.ajax({
	  				type: 'GET',
	  		        url: "https://api.iextrading.com/1.0/stock/" + sym + "/news/last/20" 
	    }).then(function(data) {
	    
	    var  news = "<div><br>";
	    
	    	$.each(data, function (index, value) {
	    		
	    		news = news + "<div class='media round_box'>";
		    	news = news + "<p><font face='verdana' color='darkorange'><b>" +  value.source + "&nbsp;&nbsp;&nbsp;</b></font></p>" ;
		    	news = news + "  <div class='media-body'>";
		    	news = news + "  <h5 class='mt-0'>"+ "<a href='" + value.url + "'><font face='verdana'>" + value.headline + "</font></a>" + "</h5>";
		    	news = news + value.summary;
		    	news = news + "</div>";
		    	news = news + "</div><br>";
		    	
	   /*  	news = news + "<div class='well well-sm'>";
	    	news = news + "<b>" + value.source + "</b><br>" ;
	    	news = news + "<a href='" + value.url + "'>" + value.headline + "</a>";
        	news = news + "</div>"; */
        	
    		});
        	news = news + "</div>";
			$('#hiddenMovers_' + sym).empty();
			$( '#hiddenMovers_' + sym).append(news);
			$( '#hiddenMovers_' + sym).show();

		//   var now = new Date(Date.now());
		 //  var formatted = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
	     //  $('.time').append(formatted);

	    });
		
	}
  </script>
<style>
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
<body class="pagebackground">

<nav class="navbar navbar-expand-sm navbarbackground navbarBottom">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="stock.jpg" alt="logo" style="width:70px;">
  </a>
    <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link menuFont" href="/home">Home</a>
    </li>
      <li class="nav-item active">
      <a class="nav-link menuFont" href="/movers">Gainers/Loosers</a>
    </li>
      <li class="nav-item">
      <a class="nav-link menuFont" href="#">Contact</a>
    </li>
  </ul>
</nav>

<!-- 	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/home">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav> -->

	<!--  <div class="container text-center"> -->
	<br>
	<div id="gainer" class="col-xs-6 col-md-10">
		<table class="table table-hover">
			<caption style="caption-side: top;">
				<b>Top Gainers</b>
			</caption>
			<thead class="thead-light">
				<tr>
					<th>Symbol</th>
					<th>Name</th>
					<th>Open</th>
					<th>Latest price</th>
					<th>Close</th>
					<th>After hr price</th>
					<th>Change</th>
					<th>Change %</th>
					<th>After hr change</th>
					<th>After hr change %</th>
					<th>More ...</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="icntStock" items="${gainersList}">
					<tr>
						<td><p class="stock-id_${icntStock.getSymbol()}"></p>${icntStock.getSymbol()}</td>
						<td width="300"><p
								class="stock-name_${icntStock.getSymbol()}"></p>${icntStock.getCompanyName()}</td>
						<td><p class="open-price_${icntStock.getSymbol()}"></p>${icntStock.getOpen()}</td>
						<td><p class="stock-price_${icntStock.getSymbol()}"></p>${icntStock.getLatestPrice()}</td>
						<td><p class="close-price_${icntStock.getSymbol()}"></p>${icntStock.getClose()}</td>
						<td><p class="extended-price_${icntStock.getSymbol()}"></p>${icntStock.getExtendedPrice()}</td>
						<td><p class="change_${icntStock.getSymbol()}"></p>${icntStock.getChange()}</td>
						<td><p class="changePercentage_${icntStock.getSymbol()}"></p>${icntStock.getChangePercent() }</td>
						<td><p class="extendedchange_${icntStock.getSymbol()}"></p>${icntStock.getExtendedChange()}</td>
						<td><p
								class="extendedchangePercentage_${icntStock.getSymbol()}"></p>${icntStock.getExtendedChangePercent()}</td>
						<td><button id="btnNews_${icntStock.getSymbol()}"
								onclick="showNews(this.id)">News</button>
							<button id="btnNewsClose_${icntStock.getSymbol()}"
								onclick="hideNews(this.id)" style="display: none;">Close</button>

						</td>
					</tr>
					<tr>
						<td colspan=11>
							<div id="hidden_${icntStock.getSymbol()}"
								class="${icntStock.getSymbol()}" style="display: none;">
							</div>
						</td>
					</tr>


				</c:forEach>
			</tbody>
		</table>

	</div>
	<!-- 			</div> -->
	<br>
	<div class="col-xs-6 col-md-10">
		<table class="table table-hover">
			<caption style="caption-side: top;">
				<b>Top Loosers</b>
			</caption>
			<br>
			<thead class="thead-light">
				<tr>
					<th>Symbol</th>
					<th>Name</th>
					<th>Open</th>
					<th>Latest price</th>
					<th>Close</th>
					<th>After hr price</th>
					<th>Change</th>
					<th>Change %</th>
					<th>After hr change</th>
					<th>After hr change %</th>
					<th>More ...</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="icntStock" items="${loosersList}">
					<tr>
						<td><p class="stock-id_${icntStock.getSymbol()}"></p>${icntStock.getSymbol()}</td>
						<td width="300"><p
								class="stock-name_${icntStock.getSymbol()}"></p>${icntStock.getCompanyName()}</td>
						<td><p class="open-price_${icntStock.getSymbol()}"></p>${icntStock.getOpen()}</td>
						<td><p class="stock-price_${icntStock.getSymbol()}"></p>${icntStock.getLatestPrice()}</td>
						<td><p class="close-price_${icntStock.getSymbol()}"></p>${icntStock.getClose()}</td>
						<td><p class="extended-price_${icntStock.getSymbol()}"></p>${icntStock.getExtendedPrice()}</td>
						<td><p class="change_${icntStock.getSymbol()}"></p>${icntStock.getChange()}</td>
						<td><p class="changePercentage_${icntStock.getSymbol()}"></p>${icntStock.getChangePercent()}</td>
						<td><p class="extendedchange_${icntStock.getSymbol()}"></p>${icntStock.getExtendedChange()}</td>
						<td><p
								class="extendedchangePercentage_${icntStock.getSymbol()}"></p>${icntStock.getExtendedChangePercent()}</td>
						<td><button id="btnNews_${icntStock.getSymbol()}"
								onclick="showNews(this.id)">News</button>
							<button id="btnNewsClose_${icntStock.getSymbol()}"
								onclick="hideNews(this.id)" style="display: none;">Close</button>
						</td>
					</tr>
					<tr>
						<td colspan=11>
							<div id="hidden_${icntStock.getSymbol()}"
								class="${icntStock.getSymbol()}" style="display: none;">
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<br>
	<div class="col-xs-6 col-md-10">
		<table class="table table-hover">
			<caption style="caption-side: top;">
				<b>Most Active
			</caption>
			<br>
			<thead class="thead-light">
				<tr>
					<th>Symbol</th>
					<th>Name</th>
					<th>Open</th>
					<th>Latest price</th>
					<th>Close</th>
					<th>Latest Vol.</th>
					<th>Iex Vol.</th>
					<th>Avg Total Vol.</th>
					<th>After hr price</th>
					<th>Change</th>
					<th>Change %</th>
					<th>After hr change</th>
					<th>After hr change %</th>
					<th>More ...</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="icntStock" items="${mostActiveList}">
					<tr>
						<td><p class="stock-id_${icntStock.getSymbol()}"></p>${icntStock.getSymbol()}</td>
						<td width="300"><p
								class="stock-name_${icntStock.getSymbol()}"></p>${icntStock.getCompanyName()}</td>
						<td><p class="open-price_${icntStock.getSymbol()}"></p>${icntStock.getOpen()}</td>
						<td><p class="stock-price_${icntStock.getSymbol()}"></p>${icntStock.getLatestPrice()}</td>
						<td><p class="close-price_${icntStock.getSymbol()}"></p>${icntStock.getClose()}</td>
						<td><p class="latestVolume_${icntStock.getSymbol()}"></p>${icntStock.getLatestVolume()}</td>
						<td><p class="iexVolume_${icntStock.getSymbol()}"></p>${icntStock.getIexVolume()}</td>
						<td><p class="avgTotalVolume_${icntStock.getSymbol()}"></p>${icntStock.getAvgTotalVolume()}</td>
						<td><p class="extended-price_${icntStock.getSymbol()}"></p>${icntStock.getExtendedPrice()}</td>
						<td><p class="change_${icntStock.getSymbol()}"></p>${icntStock.getChange()}</td>
						<td><p class="changePercentage_${icntStock.getSymbol()}"></p>${icntStock.getChangePercent()}</td>
						<td><p class="extendedchange_${icntStock.getSymbol()}"></p>${icntStock.getExtendedChange()}</td>
						<td><p
								class="extendedchangePercentage_${icntStock.getSymbol()}"></p>${icntStock.getExtendedChangePercent()}</td>
						<td><button id="btnMoversNews_${icntStock.getSymbol()}"
								onclick="showMoversNews(this.id)">News</button>
							<button id="btnMoversNewsClose_${icntStock.getSymbol()}"
								onclick="hideMoversNews(this.id)" style="display: none;">Close</button>
						</td>
					</tr>
					<tr>
						<td colspan=11>
							<div id="hiddenMovers_${icntStock.getSymbol()}"
								class="${icntStock.getSymbol()}" style="display: none;">
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


	<%-- 	            <button id="btnshow_${icntStock.get1Symbol()}" onclick="showDiv(this.id)">View</button>
	            <button id="btn_${icntStock.get1Symbol()}" onclick="hideDiv(this.id)" style="display:none;">Close</button>
 --%>

	<br>
	<br>
	<footer class="container-fluid text-center">
		<p></p>
	</footer>

</body>

</html>