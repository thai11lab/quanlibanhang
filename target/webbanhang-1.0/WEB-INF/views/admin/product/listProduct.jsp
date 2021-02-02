<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản lí sản phẩm</title>
</head>
<c:url value="/admin/product" var="urlProducts"/>
<body>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
						<h3 class="header smaller lighter blue">Danh sách sản phẩm</h3>

        <div class="clearfix">
        	<button class="mb-10" id="btn-addProduct">Thêm mới sản phẩm</button>
            <div class="pull-right tableTools-container"></div>
        </div>
        

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <form action="${urlProducts}" method="get" id="formProduct" >
        <div>
        	
            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class="center">
                            <label class="pos-rel">
                                <input type="checkbox" class="ace" />
                                <span class="lbl"></span>
                            </label>
                        </th>
                        <th>Mã sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th class="hidden-480">Hình ảnh của sản phẩm</th>
                        <th>
                            <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                           	Ngày tạo
                        </th>
                        <th class="hidden-480">Giá sản phẩm</th>

                        <th>Hành động</th>
                    </tr>
                </thead>

                <tbody>
                	<c:forEach var="list" items="${listProduct}">
                    <tr>
                        <td class="center">
                            <label class="pos-rel">
                                <input type="checkbox" class="ace" />
                                <span class="lbl"></span>
                            </label>
                             ${pageSize}
                        </td>
						
                        <td>
                            ${list.code}
                           
                        </td>
                        <td>${list.name}</td>
                        <td class="hidden-480"><img src=${list.mainImageUrl} alt="" style="width: 50px;height: 50px;"> </td>
                        <td><%= (new java.util.Date()).toLocaleString() %></td>

                        <td class="hidden-480">
                           	${list.price }
                        </td>

                        <td>
                            <div class="hidden-sm hidden-xs action-buttons">
                                <a class="blue" href="#">
                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                </a>

                                <a class="green" href="#">
                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                </a>

                                <a class="red" href="#">
                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                </a>
                            </div>

                            <div class="hidden-md hidden-lg">
                                <div class="inline pos-rel">
                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                        <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                    </button>

                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                        <li>
                                            <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                                <span class="blue">
                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                </span>
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                <span class="green">
                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                </span>
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                <span class="red">
                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                </span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                    
                </tbody>
                
            </table>
            <nav aria-label="Page navigation" style="float:right">
        		<ul class="pagination" id="pagination"></ul>
    		</nav>
    		<input type="hidden" name="pageIndex" id="pageIndex">
    		
        </div>
        </form>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- /.main-content -->
    <div id="modalProduct" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header no-padding">
                    <div class="table-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <span class="white">&times;</span>
                        </button>
                        Results for "Latest Registered Domains
                    </div>
                </div>

                <form class="form-horizontal" role="form" id="formAddProduct">              
                    <div class="modal-body no-padding">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Mã sản phẩm</label>
                            <div class="col-sm-9">
                                <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-9" name="code" id="code"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tên sản phẩm </label>
                            <div class="col-sm-9">
                                <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-9" name="name" id="name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Giá sản phẩm </label>
                            <div class="col-sm-9">
                                <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-9" name="price" id="price"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Text Field </label>
                            <div class="col-sm-9">
                                <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-9" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Text Field </label>
                            <div class="col-sm-9">
                                <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-9" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Text Field </label>
                            <div class="col-sm-9">
                                <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-9" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Text Field </label>
                            <div class="col-sm-9">
                                <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-9" />
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer no-margin-top" style="display: flex;justify-content: space-around;">
                        <button class="btn btn-sm btn-danger pull-left" data-dismiss="modal" >
                            <i class="ace-icon fa fa-times"></i>
                            Close
                        </button>
                        <button class="btn btn-sm btn-success pull-left"  id="submitProduct" type="submit">
                            Submit
                        </button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- PAGE CONTENT ENDS -->
    <script type="text/javascript">
        $(function () {       
            var totalPages=${totalPage};
            var currentPage = ${pageIndex}   
            window.pagObj = $('#pagination').twbsPagination({
                
                totalPages: totalPages,
                visiblePages: 10,  
                startPage: currentPage,        
                onPageClick: function (event, page) { 
                    if(currentPage != page){  
                        $("#pagaIndex").val(page);
                        $("#formProduct").submit();        
                    }
                    
                }
            }).on('page', function (event, page) {
                
            });
        });
        
        //Xử lí phần thêm sản phẩm
        $("#btn-addProduct").click(function (e) { 
            $('#modalProduct').modal();
        });
        
        $("#formAddProduct").submit(function (e) { 
            e.preventDefault()
            var data ={};
            var formData = $('#formAddProduct').serializeArray();
           	console.log(formData);
            $.each(formData, function (index, value) { 
            	data[""+value.name+""]= value.value;
            });
			$.ajax({
                type: "post",
                url: "http://localhost:8080/webbanhang/api/product/addProduct",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (response) {
            		console.log(response);
                }
            });
        });
        
    </script>
    
</body>

</html>