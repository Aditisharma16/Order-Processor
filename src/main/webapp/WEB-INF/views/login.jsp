
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OrderProcessor</title>
<link rel="shortcut icon" href="icon.ico?" type="image/x-icon" />

<style><%@include file="/WEB-INF/views/css/login.css"%>

</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
<link rel="icon" href="img/xFevicon.png.pagespeed.ic.hZ51SwHHcH.webp" type="image/png">


  </head>
  <body>
	
    <section class="login_box_area section-margin">
    <div class="container">
    <div class="row">
    <div class="col-lg-6">
    <div class="login_box_img">
    <div class="hover">
   	<img src="https://preview.colorlib.com/theme/aroma/img/home/xhero-banner.png.pagespeed.ic.Da3KtaVoQv.webp" class="imgTest"/>
    
    
    </div>
    </div>
    </div>
    <div class="col-lg-6">
    <div class="login_form_inner">
    <h3>Log in to enter</h3>
    <form:form name="myform" class="row login_form" action='orderlogin' method='POST' autocomplete="off">
    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
	<div id="errmsg">
		 <p>${SPRING_SECURITY_LAST_EXCEPTION.message }</p>
	</div >
	</c:if >
    <div class="col-md-12 form-group">
    <input type="text" class="form-control"  name="uname" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'" >
    </div>
    <div><p class="invisible" id="mym">enter username please</p></div>
    <div class="col-md-12 form-group">
    <input type="password" class="form-control"name="upass" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
   
    </div>
    <div class="col-md-12 form-group">
    <div class="creat_account">
    
    </div>
    </div>
    <div class="col-md-12 form-group">
    <button  type="submit" value="Login" onClick="return validate()" class="button button-login w-100">Log In</button>
    
    </div>
    </form:form>
    </div>
    </div>
    </div>
    </div>
    </section>
   
    

</body>
</html>
