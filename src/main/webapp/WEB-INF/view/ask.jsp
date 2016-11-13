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
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>AskUs</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/resources/css/mystyle.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script src="${pageContext.request.contextPath}/resources/javascript/js_member.js" ></script>
  <script>
  $(function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    function split( val ) {
      return val.split( /,\s*/ );
    }
    function extractLast( term ) {
      return split( term ).pop();
    }
 
    $( "#tags" )
      // don't navigate away from the field on tab when selecting an item
      .bind( "keydown", function( event ) {
        if ( event.keyCode === $.ui.keyCode.TAB &&
            $( this ).autocomplete( "instance" ).menu.active ) {
          event.preventDefault();
        }
      })
      .autocomplete({
        minLength: 0,
        source: function( request, response ) {
          // delegate back to autocomplete, but extract the last term
          response( $.ui.autocomplete.filter(
            availableTags, extractLast( request.term ) ) );
        },
        focus: function() {
          // prevent value inserted on focus
          return false;
        },
        select: function( event, ui ) {
          var terms = split( this.value );
          // remove the current input
          terms.pop();
          // add the selected item
          terms.push( ui.item.value );
          // add placeholder to get the comma-and-space at the end
          terms.push( "" );
          this.value = terms.join( ", " );
          return false;
        }
      });
  });
  </script>
</head>
<body>
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
								<form id="login-form" action="${pageContext.request.contextPath}/user/login/ask" method="post" commandName="user" role="form" style="display: block;">
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
								<form id="register-form" role="form" style="display: none;" method="POST" action="${pageContext.request.contextPath}/user/add/ask" commandName="user">
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
		</div>
		</div>
</nav>
<c:if test="${sessionScope.uname != null}">
<div class="container">
<form:form method="POST" action="${pageContext.request.contextPath}/post/add/${sessionScope.uname}" commandName="post">

	<div class="form-group">
						<label for="exampleInputTitle">Title</label>
						<input type="title" class="form-control" id="exampleInputTitle" name="post_title" placeholder="Enter a title of your question">
	</div>
	
	
	<div class="form-group">
						<label for="exampleInputTitle">Ask Your Question:</label>
						<textarea class="form-control" placeholder="Describe your question" name="post_details" id="exampleInputQuestion" cols="30" rows="10"></textarea>
	</div>
	
	
	
	<div class="ui-widget">
					  <label for="exampleInputTags">Tag: </label> <br>
					  <input id="tags" size="50" name="post_keywords">  <br>  <br>
	</div>
	<div align="center">
	<button type="submit" class = "btn btn-primary btn-lg" name="postsubmit" id="postsubmit"  value="post">Post</button> 
	 <br>  <br>
	</div>
  </form:form>
  </div>
</c:if>

<c:if test="${sessionScope.uname == null}">
<div class="container">
<h3>You need to login first!</h3>
<form:form method="POST" action="${pageContext.request.contextPath}/post/add/${sessionScope.uname}" commandName="post">

	<div class="form-group">
						<label for="exampleInputTitle">Title</label>
						<input type="title" class="form-control" id="exampleInputTitle" name="post_title" placeholder="Enter a title of your question">
	</div>
	
	
	<div class="form-group">
						<label for="exampleInputTitle">Ask Your Question:</label>
						<textarea class="form-control" placeholder="Describe your question" name="post_details" id="exampleInputQuestion" cols="30" rows="10"></textarea>
	</div>
	
	
	
	<div class="ui-widget">
					  <label for="exampleInputTags">Tag: </label> <br>
					  <input id="tags" size="50" name="post_keywords">  <br>  <br>
	</div>
	<div align="center">
	<button type="submit" class = "btn btn-primary disabled btn-lg" name="postsubmit" id="postsubmit"  value="post">Post</button> 
	 <br>  <br>
	</div>
  </form:form>
  </div>
</c:if>
<!--- footer --->
<div class = "container-fluid"  >
	<table class = "footer" width = "100%">
		<tr>	
			<td align = "left"><h6>Give us your <a href = "#">feedback</a></h6></td>
			<td align = "right"><h6>
				<span class = "glyphicon glyphicon-copyright-mark"></span>AskUs 2015</h6></td>
		</tr>	
	</table>
</div>


</body>
</html>