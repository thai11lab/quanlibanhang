<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt hàng</title>
</head>
<%@include file="/common/taglib.jsp" %>
<body>
	<!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h6 class="coupon__link"><span class="icon_tag_alt"></span> <a href="#">Have a coupon?</a> Click
                    here to enter your code.</h6>
                </div>
            </div>
            <form action="#" class="checkout__form" >
                <div class="row">
                    <div class="col-lg-8">
                        <h5>Billing detail</h5>
                        <div class="row">
                            <div class="col-lg-12 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Họ tên<span>*</span></p>
                                    <input type="text">
                                </div>
                            </div>
                       
                            <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p>Địa chỉ<span>*</span></p>
                                    <input type="text">
                                </div>
                              
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Phone <span>*</span></p>
                                    <input type="text">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Email <span>*</span></p>
                                    <input type="text">
                                </div>
                            </div>
                           
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="checkout__order">
                                <h5>Đơn hàng của bạn</h5>
                                <div class="checkout__order__product">
                                    <ul>
                                        <li>
                                            <span class="top__text">Sản phẩm</span>
                                            <span class="top__text__right">Thành tiền</span>
                                        </li>
                                        <c:forEach var="listProductOrder" items="${listProductOrder}">
	                                        <li>01. ${listProductOrder.productDto.name} &nbsp;x &nbsp;${listProductOrder.quantity} <span>${listProductOrder.totalPrice}</span></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="checkout__order__total">
                                    <ul>
                                        <li>Thành tiền<span>${totalMoney}</span></li>
                                    </ul>
                                </div>
                                <div class="checkout__order__widget">
                                  	
                                </div>
                                <button type="submit" class="site-btn">Place oder</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- Checkout Section End -->
</body>
</html>