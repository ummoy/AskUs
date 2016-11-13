<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>AskUs</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/resources/css/mystyle.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/javascript/js_member.js" ></script>
</head>
<body>
<!-- navigation bar -->
<nav class = "navbar navbar-inverse">
	<div class = "container-fluid">
		<div class = "navbar-header">
			<button type = "button" class = "navbar-toggle" data-toggle = "collapse" data-target = "#myNavbar">
				 <span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
			</button>
			<a class = "navbar-brand" href = "${pageContext.request.contextPath}/">AskUs</a>
		</div>
		<div class = "collapse navbar-collapse" id = "myNavbar">
			<ul class = "nav navbar-nav" id = "navBar">
				<li class = "active"><a href = "${pageContext.request.contextPath}/"><span class = "glyphicon glyphicon-list"></span>All Questions</a></li>
				<li class = "active"><a href = "${pageContext.request.contextPath}/top"><span class = "glyphicon glyphicon-circle-arrow-up"></span>Top Questions</a></li>
				<li class = "active"><a href = "${pageContext.request.contextPath}/unanswered"><span class = "glyphicon glyphicon-pencil"></span>Un-Answered</a></li>
				<li class = "active"><a href = "${pageContext.request.contextPath}/tags"><span class = "glyphicon glyphicon-tag"></span>Common Tags</a></li>
				<li class = "active"><a href = "members"><span class = "glyphicon glyphicon-list-alt"></span>Members</a></li>
				<li class = "active"><a href = "question"><span class = "glyphicon glyphicon-question-sign"></span>Ask Us</a></li>
			</ul>
			<ul class = "nav navbar-nav navbar-right">
				
				<div>
				<li><a href = "#">
				<c:if test="${sessionScope.uname == null}">	  
				
						<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Member</button></a>
				</c:if>
				<c:if test="${sessionScope.uname != null}">	  
				
						<a href="#"><button type="button" class="btn btn-info btn-lg">Hi, ${sessionScope.uname}</button></a>
						<a href="logout"><button type="button" class="btn btn-info btn-lg">Sign Out</button></a>
				</c:if>
				</li>
				</div>>		
			</ul>				
						<div class="container">
  
  <!-- Trigger the modal with a button -->
  

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">LogIN/SignUP</h4>
        </div>
        <div class="modal-body">
          
		  <div class="container">
    	<div class="row">
			<div class="col-md-6 ">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="${pageContext.request.contextPath}/user/login" method="post" commandName="user" role="form" style="display: block;">
									<div class="form-group">
								<label for="exampleInputEmail1">username</label>
								<input type="username" class="form-control" id="exampleInputUserName" name="user_name" placeholder="Enter username">
							</div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label>
								<input type="password" class="form-control" id="exampleInputPassword1" name="user_password" placeholder="Password">
							</div>
							
							
						
						
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="http://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
								</form>
								<form id="register-form" role="form" style="display: none;" method="POST" action="${pageContext.request.contextPath}/user/add" commandName="user">
									<div class="form-group">
						<label for="exampleInputEmail1">Username</label>
						<input type="username" class="form-control" id="exampleInputUserName" name="user_name" placeholder="Enter username">
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						<input type="password" class="form-control" id="exampleInputPassword1" name="user_password" placeholder="Password">
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">First name</label>
						<input type="firstname" class="form-control" id="exampleInputFirstName" name="user_fname" placeholder="Enter First name">
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">Last name</label>
						<input type="lastname" class="form-control" id="exampleInputLastName" name="user_lname" placeholder="Enter Last name">
					</div>
					
					<div>
						<label for="exampleInputEmail1">Email address</label>
						<input type="email" class="form-control" id="exampleInputEmail1" name="user_email" placeholder="Enter email">
					</div>
					
					<div>
						<label for="exampleInputEmail1">Address</label>
						<input type="address" class="form-control" name="user_address" id="exampleInputEmail1" placeholder="Enter Address">
					</div>
			  
					 <div class="form-group">
						<label for="exampleInputFile">Insert your profile picture</label>
						<input type="text" name="user_pic" id="exampleInputProPic">
					</div>
				
					<div class="checkbox">
						<label>
						  <input type="checkbox"> Check me out
						</label>
					 </div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		  
		  
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
						
						
</nav>	
<!-- desciption jumbotron -->
<div class = "container-fluid">
	<div class = "jumbotron">
		<p> This is where you get the answers to the questions you have in mind </p>
		</p> You have a question...AskUs! </p>
	</div>	
</div>
<!-- desciption jumbotron -->
<div class = "container-fluid">
	<table class = "content" width = "100%" >
		<tr >
			<!-- page content -->
			<td align = "center" width = "70%">
				<table class = "content" align = "center" width = "100%">
					<tr class = "content">	
						<td colspan = "4" class = "header" align = "center"><h2 >Tag Related Questions</h2></td> 								
					</tr>
					<c:if test="${fn:length(listPost) <= 0}">
						<h1>dfdffvfv</h1>
					</c:if>
					<c:if test="${fn:length(listPost) > 0}">
					<c:forEach items="${listPost}" var="post">
					<tr class = "content">
						<td class = "col-sm-1" id = "vote">${post.post_votes}<br/>Votes <!-- displays number of votes, like and dislike option -->
						</td>
							<td class = "col-sm-1" id = "hit">${post.post_views}<br />Hits <!-- number of times the question has been asked -->
						</td>
							<td class = "col-sm-1" id = "ans">${post.post_answers}<br />Answer <!-- number of answers available for the answer -->
						</td>
						<td class = "col-sm-9" id = "question"><a href="<c:url value='posts/${post.post_id}/${post.post_title}' />">${post.post_title} </a><!-- here starts the question -->
							<table>
								<tr>
									<td class = "details">
										<h5>posted by ${post.post_by} on ${post.post_date }</h5>
									</td>
								</tr>
								<tr>
									<td class = "details">
										<h5>tags :&nbsp;${post.post_keywords}</h5>
									</td>
								</tr>
								
								
							</table>
						</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
			</td>			
			<!-- seach & faq -->
			<td align = "center" width = "30%" id = "faqs">
				<table class = "content" align = "center" width = "90%" >	
					<tr >
						<td class = "col-sm-12" align = "center" id = "search ">
						<form action="${pageContext.request.contextPath}/search" method="GET" commandName="post">
							<input align = "center" type = "text" name="post_keywords">
							<button type = "submit" class = "btn btn-success">
							<span class = "glyphicon glyphicon-search"></span></button>
						</form>
						</td> 
					</tr>
					<tr class = "content">
						<td class = "col-sm-12" align = "center" id = "faq">
							<h2>FAQ</h2>
						</td>
					</tr>
					<tr >
						<td class = "col-sm-12" id = "faq">
							<li><a>What are the topics that I can ask here?</a></li>
							<ul class = "ans">
								<li><a>Any topic that is related to the society and educational and knowledgeable purpose.</a></li>
							</ul>	
						</td>
					</tr >
					<tr>
						<td class = "col-sm-12" id = "faq">
							<li><a>What types of questions should I avoid asking?</a></li>
							<ul class = "ans">
								<li><a>Anything that can be offensive to any particular individual or race or nation.</a></li>
							</ul>	
						</td>
					</tr>
					<tr >
						<td class = "col-sm-12" id = "faq">
							<li><a>How many answers can I post for one question?</a></li>
							<ul class = "ans">
								<li><a>There is no limited number for that, unless they are irrelevant.</a></li>
							</ul>	
						</td>
					</tr >
						<tr>
						<td class = "col-sm-10" id = "faq">
							<li><a>Can I answer my own question?</a></li>
							<ul class = "ans">
								<li><a>No, one cannot answer his/her own questions.</a></li>
							</ul>	
						</td>
					</tr>
				</table>
			</td>
		</tr>	
	</table>
</div>
<!-- pagination --> 
<div class="container">             
  <ul class="pagination">
    <li><a href="#">«</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">6</a></li>
    <li><a href="#">»</a></li>
  </ul>
</div>
<!-- Footer -->
<div class = "container-fluid"  >
	<table class = "footer" width = "100%">
		<tr>	
			<td align = "left"><h6>Give us your <a href = "#">feedback</a></h6></td>
			<td align = "right"><h6>
				<span class = "glyphicon glyphicon-copyright-mark"></span>AskUs 2015</h6></td>
		</tr>	
	</table>
</div>