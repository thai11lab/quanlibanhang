<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Admin Page" /></title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />

<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/jquery.multiselect.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css' />" />


<!-- text fonts -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css' />" />



<!-- ace styles -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css' />"
	class="ace-main-stylesheet" id="main-ace-style" />


<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
		<link rel="stylesheet" href="<c:url value='/template/admin/assets/sweetalert2/sweetalert2.min.css' />" />
	<script src="<c:url value='/template/clientlogic/checkUrlParameter/checkUrlParameter.js' />"></script>
	
</head>
<body class="no-skin">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- header -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- header -->
		
		<dec:body/>

		<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- footer -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
	
	

	<script
		src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.multiselect.js' />"></script>
	
	
	
    <script src="<c:url value='/template/admin/assets/Simple-Customizable-Pagination-Plugin-with-jQuery-Bootstrap-Twbs-Pagination/jquery.twbsPagination.js' />"></script>
   <script src="<c:url value='/template/admin/assets/sweetalert2/sweetalert2.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/uploadFile/upload.js' />"></script>
		
</body>
</html>