<%@page import="webbanhang.utils.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/home" var="urlHome"/>
<c:url value="/detail_cart" var="urlDetailsCart"/>
<!-- Header Section Begin -->
    <header class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-2">
                    <div class="header__logo">
                        <a href="./index.html"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-7">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="${urlHome}">Home</a></li>
                            <li><a href="./shop.html">Shop</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="dropdown">
                                    <li><a href="./product-details.html">Product Details</a></li>
                                    <li><a href="./shop-cart.html">Shop Cart</a></li>
                                    <li><a href="./checkout.html">Checkout</a></li>
                                    <li><a href="./blog-details.html">Blog Details</a></li>
                                </ul>
                            </li>
                            <li><a href="./blog.html">Blog</a></li>
                            <li><a href="./contact.html">Contact</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__right">
                    	
                        <div class="header__right__auth">
                        	<security:authorize access="isAnonymous()">
                        		<a href="#">Login</a>
                            	<a href="#">Register</a>
                            </security:authorize>
                            <security:authorize access="isAuthenticated()">	                        
	                            <div href="" class="hello-user">Welcome,<%=SecurityUtils.getPrincipal().getFullName()%>
	                            	<ul class="hover-ul">
	                            		<li>
	                            			<a href="#">Thông tin tài khoản</a>
	                            		</li>
	                            		<li>
	                            			<a href="logout">Đăng xuất</a>
	                            		</li>
	                            	</ul>
	                            </div>                    	                            	                        
                        	</security:authorize>
                        </div>
                        
                        
                        <ul class="header__right__widget">
                            <li><span class="icon_search search-switch"></span></li>
                            <li><a href="${urlDetailsCart}"><span class="icon_bag_alt"></span>
                                <div class="tip cart"><%=session.getAttribute("myCartNum") %></div>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="canvas__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->