<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/common/taglib.jsp" %>
<html>

<head>
    <meta charset="UTF-8">
    <title><dec:title/></title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
        rel="stylesheet">

    <!-- Css Styles -->
	
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/hover.css'/>" type="text/css">
    <link rel="stylesheet" href='<c:url value='/template/web/css/font-awesome.min.css'> </c:url>' type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href='<c:url value="/template/web/css/elegant-icons.css"></c:url>' type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/web/css/jquery-ui.min.css"> </c:url>" type="text/css">
    <link rel="stylesheet" href='<c:url value="/template/web/css/magnific-popup.css"></c:url>' type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href='<c:url value="/template/web/css/owl.carousel.min.css"></c:url>' type="text/css">
    <link rel="stylesheet" href='<c:url value="/template/web/css/slicknav.min.css"></c:url>' type="text/css">
    <link rel="stylesheet" href='<c:url value='/template/web/css/style.css'> </c:url>' type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/sweetalert2/sweetalert2.min.css' />" />
   
    <script src='<c:url value="/template/web/js/jquery-3.3.1.min.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/bootstrap.min.js"></c:url>'></script>
</head>

<body>
    <%@ include file="/common/web/header.jsp"%>

    <dec:body></dec:body>
    <%@ include file="/common/web/footer.jsp" %>

    <!-- Js Plugins -->

    <script src='<c:url value="/template/web/js/bootstrap.min.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/jquery.magnific-popup.min.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/jquery-ui.min.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/mixitup.min.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/jquery.countdown.min.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/jquery.slicknav.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/owl.carousel.min.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/jquery.nicescroll.min.js"></c:url>'></script>
    <script src='<c:url value="/template/web/js/main.js"></c:url>'></script>
    <script
        src="<c:url value='/template/admin/assets/Simple-Customizable-Pagination-Plugin-with-jQuery-Bootstrap-Twbs-Pagination/jquery.twbsPagination.js' />">
    </script>
    <script src="<c:url value='/template/admin/assets/sweetalert2/sweetalert2.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/uploadFile/upload.js' />"></script>
	<script src="<c:url value='/template/tada/tata.js' />"></script>
    <script type="text/javascript">
        function addToCart(id) {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/webbanhang/api/cart/" + id,
                success: function (response) {
                	tata.success('OK', 'Thêm vào giỏ hàng thành công',{
                		position: 'tr',
                		animate: 'slide'
                	});
                  
                    $(".cart").html(Object.keys(response).length);
                },
                error: function (res) {
                    console.log(res);
                }
            });
        }
    </script>
	<script type="text/javascript">
		function removeCart(id) {
			debugger;
		    $.ajax({
		        type: "GET",
		        url: "http://localhost:8080/webbanhang/api/cart/remove/"+id,
		        success: function (response) {
		        	setTimeout(() => {
			                window.location.href="${urlDetailsCart}";
			        }, 1000); 
		        	tata.success('OK', 'Thêm vào giỏ hàng thành công',{
                		position: 'tr',
                		animate: 'slide'
                	});  
		        	
		                         
		            $(".cart").html(Object.keys(response).length);
		        },
		        error: function (res) {
		            console.log(res);
		        }
		    });
		}
	</script>
	<script src="<c:url value='/template/clientlogic/web/FormCheckOut.js' />"></script>
</body>

</html>