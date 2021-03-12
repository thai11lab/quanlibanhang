<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Chi tiết giỏ hàng</title>
</head>
<%@include file="/common/taglib.jsp" %>
<c:url value="/home/checkout" var="urlCheckOut" />
<c:url value="/home/detail_cart" var="urlDetailsCart" />
<body>
    <!-- Shop Cart Section Begin -->
    <section class="shop-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shop__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Sản phẩm</th>
                                    <th>Giá sản phẩm</th>
                                    <th>Số lượng</th>
                                    <th>Tổng tiền</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="listProductInCart" items="${listProductInCart}">
                                    <tr>
                                        <td class="cart__product__item">
                                            <img src="<c:url value='${listProductInCart.productDto.mainImageUrl}' />"
                                                alt="" style="width: 100px;height: 100px">
                                            <div class="cart__product__item__title">
                                                <h6>${listProductInCart.productDto.name}</h6>
                                            </div>
                                        </td>
                                        <td class="cart__price">${listProductInCart.productDto.price}</td>
                                        <td class="cart__quantity">
                                            <div class="pro-qty">
                                                <input type="text" value="${listProductInCart.quantity}">
                                            </div>
                                        </td>
                                        <td class="cart__total">${listProductInCart.totalPrice}</td>
                                        <td class="cart__close" ><span class="icon_close" onclick="removeCart(${listProductInCart.productDto.id})"></span></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <c:set var="listProductJstl" value="${listProductInCart}"></c:set>
                
			                <tfoot align="center" style="display:<c:out value="${not empty listProductJstl ?'none':''}" ></c:out>">
						        <tr>
						           <td colspan="7">Không có sản phẩm trong giỏ hàng</td>
						        </tr>
			    			</tfoot>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="cart__btn">
                        <a href="#">Continue Shopping</a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="cart__btn update__btn">
                        <a href="#"><span class="icon_loading"></span> Update cart</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="discount__content">
                        <h6>Discount codes</h6>
                        <form action="#">
                            <input type="text" placeholder="Enter your coupon code">
                            <button type="submit" class="site-btn">Apply</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 offset-lg-2">
                    <div class="cart__total__procced">
                        <h6>Cart total</h6>
                        <c:set var="totalMoney1" value="${totalMoney}"></c:set>
                        <ul>
                            <li>Subtotal <span>$ 750.0</span></li>
                            <li>Tổng tiền <span>${totalMoney1}</span></li>
                        </ul>
                         <c:set var="lisproduct" value="${listProductInCart}"></c:set>
	                         <c:if test="${not empty lisproduct}">
	                         	<a href="${urlCheckOut}" class="primary-btn">Đặt hàng</a>
	                         </c:if>
	                                               
                    </div>
                </div>
            </div>
        </div>
       
    </section>
    <!-- Shop Cart Section End -->

</body>
	
</html>