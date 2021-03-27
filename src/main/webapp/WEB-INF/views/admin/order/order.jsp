<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lí đơn hàng</title>
<%@include file="/common/taglib.jsp" %>
</head>
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
						<h3 class="header smaller lighter blue">Danh sách đơn hàng</h3>

        <div class="clearfix" style="display: flex;">
        	
        </div>
        
		
        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <form:form action="${urlProducts}" role="form" id="formProduct" modelAttribute="model" method="get">
        <div>
        	<div style="margin-bottom: 10px;">
        		<div style="width: 100%;display: flex;height:100%">
        			<div style="display: flex;flex-grow: 1">
        				<div style="display: flex;flex-direction: column;">
        					<label for="keyword">Từ khóa cần tìm kiếm</label>
        					<input type="text" class="" name="keyword" placeholder="Từ khóa..." style="margin-right: 10px;">
        				</div>
        				<div style="display: flex;flex-direction: column;">
        					<label for="dateFrom">Ngày đặt</label>
        					<input type="date" class="" name="dateOrder" style="margin-right:10px;height: 35px" placeholder="Ngày đặt hàng">
        				</div>
        				<div style="display: flex;flex-direction: column;">
	        				<label>Ngày giao hàng</label>
	        				<input type="date" class="" name="dateRecive" style="margin-right: 10px;height: 35px">
        				</div>
        				<div style="display: flex;flex-direction: column;width:20%">
	        				<label>Trạng thái đơn hàng</label>
	        				<select id="cars" style="height: 35px;width: 100%" name="status">
	        				  <option value="0">Chưa giao hàng</option>
							  <option value="1">Chưa giao hàng</option>
							  <option value="2">Đang vận chuyển</option>
							  <option value="3">Đã giao hàng</option>
							</select>
						</div>
        			</div>
	        		
	        		<button class="btn btn-xs btn-success mb-10" type="submit" style="width: 10%">Tìm kiếm</button>
	       		</div>     
        	</div>
        	   	
            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                <thead>             	
                    <tr>                       
                        <th>Mã đơn hàng</th>
                        <th>Tên khách hàng</th>
                        <th>Địa chỉ</th>
                        <th class="hidden-480">Số điện thoại</th>
                        <th>
                            <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                           	Ngày đặt hàng
                        </th>
                        <th>
                            <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                           	Ngày giao hàng
                        </th>
                        <th class="hidden-480">Giá sản phẩm</th>
						<th class="hidden-480">Trạng thái</th>
                        <th>Hành động</th>
                    </tr>
                </thead>

                <tbody>
                	<c:forEach var="itemOrder" items="${listOrder}">               		
	                    <tr>							
	                        <td>
	                            ${itemOrder.code}
	                           
	                        </td>
	                        <td>${itemOrder.customerName}</td>
	                      	<td>${itemOrder.customerAddress}</td>
	                       	<td>${itemOrder.customerPhone}</td>
	               			<td>${itemOrder.createdDate}</td>
							<td>${itemOrder.deliveryDate}</td>
	                        <td>${itemOrder.totalMoney}</td>
							<td>${itemOrder.status == 1 ?"Chưa giao hàng":itemOrder.status==2?"Đã giao hàng":"Đang vận chuyển"}</td>
	                        <td>
	                            <div class="hidden-sm hidden-xs action-buttons">
	                                
                                    <a class="btn btn-xs btn-warning ">
	                                    <i class="ace-icon fa fa-flag bigger-120" >
                                                
                                        </i>
                                    </a>
	                                <button class="btn btn-xs btn-info btn-UpdateProduct" value="">
	                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
	                                </button>
	                                <input type="hidden" id="id"  value="${itemProduct.id}" > 
	                            </div>	                            
	                        </td>
	                    </tr>
                    </c:forEach>
                                 
                </tbody>
                <c:set var="listProductJstl" value="${listOrder}"></c:set>
                
                <tfoot align="center" style="display:<c:out value="${not empty listProductJstl ?'none':''}" ></c:out>">
			        <tr>
			           <td colspan="9">Không có dữ liệu</td>
			        </tr>
    			</tfoot>
                
            </table>
            <nav aria-label="Page navigation" style="float:right">
        		<ul class="pagination" id="pagination"></ul>
    		</nav>
    		<input type="hidden" name="pageIndex" id="pageIndex" value="1">
    		<input type="hidden" name="pageSize" id="pageSize" value="10">
    		
        </div>
        </form:form>
        <input type="hidden" id="idUpdate">
                    </div>
                </div>
            </div>
        </div>
    </div><!-- /.main-content -->
    
    
    <div id="editModalProduct" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header no-padding">
                    <div class="table-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <span class="white">&times;</span>
                        </button>
                        Cập nhật sản phẩm
                    </div>
                </div>

                <form class="form-horizontal" role="form" id="formEditProduct" enctype="multipart/form-data">              
                    <div class="modal-body no-padding">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Mã sản phẩm</label>
                            <div class="col-sm-9">
                                <input type="text"  placeholder="Mã sản phẩm" class="col-xs-10 col-sm-9" name="code" id="code"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tên sản phẩm </label>
                            <div class="col-sm-9">
                                <input type="text"  placeholder="Tên sản phẩm" class="col-xs-10 col-sm-9" name="name" id="name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Giá sản phẩm </label>
                            <div class="col-sm-9">
                                <input type="text"  placeholder="Giá sản phẩm" class="col-xs-10 col-sm-9" name="price" id="price"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Link website </label>
                            <div class="col-sm-9">
                                <input type="text"  placeholder="website" class="col-xs-10 col-sm-9" name="websiteUrl" id="websiteUrl"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Ảnh sản phẩm </label>
                            <div class="col-sm-9">
                                <input type="file"  placeholder="website" class="col-xs-10 col-sm-9" name="file" id="file"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Mô tả </label>
                            <div class="col-sm-9">
                                <textarea  class="col-xs-10 col-sm-9" name="description" id="description">
                                	
                                </textarea>
                            </div>
                        </div>
                        <div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-right"> Thể loại </label>
										<div class="col-sm-9" style="width: 300px;">
											<select name="idCategories" multiple="multiple" class="3col active" >
												<c:forEach var="itemCategory" items="${listCategory}">
													<option value="${itemCategory.id}">${itemCategory.name}</option>
												</c:forEach>
                                                
                                            </select>							
										</div>
						</div>
                    </div>
                    <div class="modal-footer no-margin-top" style="display: flex;justify-content: space-around;">
                        <button class="btn btn-sm btn-danger pull-left" data-dismiss="modal" >
                            <i class="ace-icon fa fa-times"></i>
                            Close
                        </button>
                        <button class="btn btn-sm btn-success pull-left" id="submitEditProduct" >
                            Submit
                        </button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- PAGE CONTENT ENDS -->
    <script type="text/javascript">
	    $(function () {
	        $('select[multiple].active.3col').multiselect({
	            columns: 1,
	            placeholder: 'Thể loại',
	            search: true,
	            searchOptions: {
	                'default': 'Search States'
	            },
	            selectAll: true
	        });
	
	    });
        $(function () {       
            var totalPages=${totalPage};
            var currentPage = ${pageIndex}  
            var pageSize = ${pageSize}
            window.pagObj = $('#pagination').twbsPagination({
                
                totalPages: totalPages,
                visiblePages: 10,  
                startPage: currentPage,        
                onPageClick: function (event, page) { 
                    if(currentPage != page){  
                        $("#pageIndex").val(page);
                        $("#pageSize").val(pageSize);
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
        
        $("#submitProduct").click(function (e) { 
            e.preventDefault()
             debugger;
            var data ={};
            var formData = $('#formAddProduct').serializeArray();
          	var categoriesId =[];
            $.each(formData, function (index, value) { 
            	if (value.name == "idCategories") {
            		categoriesId.push(value.value);
				}else{
					data[""+value.name+""]= value.value;
				}
            	
            });
            data['idCategories']=categoriesId;
            
            
           
			addProduct(data);
        });


        // function addProduct(data){
        //     var dataClient = data;
        //     var updateJsonProduct = $.ajax({
        //     	type: "POST",
        //         contentType: "application/json",
        //         url: "http://localhost:8080/webbanhang/api/product",
        //         data: JSON.stringify(data),
        //         dataType: "json",         
            
        //         success: function (response) {
        //     		console.log(response);    
                    
        //     		swal("Good job!", "Thêm sản phẩm thành công!", "success")                       		
        //             setTimeout(() => {
        //                 window.location.href="${urlProducts}&id="+response.id+"&message=insert_success";
        //             }, 2000);
            		
        //         },
        //         error: function(response){
        //             console.log("sadjiasj");
        //             swal("Thất bại!", "Thêm sản phẩm thất bại!", "error")
        //         }
        //     });
        // }

        function addProduct(data){
            var updateJsonProduct = $.ajax({
            	type: "POST",
                contentType: "application/json",
                url: "http://localhost:8080/webbanhang/api/product",
                data: JSON.stringify(data),
                dataType: "json",         
            
                success: function (response) {
            		uploadFileWhenAdd(response.id);
                },
                error: function(response){
                    console.log("sadjiasj");
                    swal("Thất bại!", "Thêm sản phẩm thất bại!", "error")
                }
            });
        }

        function uploadFileWhenAdd(productId){
            var formData = new FormData();
            var productId = productId;
            var files = document.getElementById("file").files;
            if (files.length === 0) {
				return false;
			}
            file = document.getElementById("file").files[0];            
            formData.append("file", file);
            formData.append("productId",productId);
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "http://localhost:8080/webbanhang/api/upload",
                data: formData,
                processData: false,
                contentType: false,
                cache: false,
                success: function (response) {
             		swal("Good job!", "Thêm sản phẩm thành công!", "success")                       		
             		setTimeout(() => {
                        window.location.href="${urlProducts}";
                    }, 2000);             
                },
                error:function(res){
					console.log(res);
                }
            });
        }

       $(".btn-UpdateProduct").on("click", function (e) {
           e.preventDefault();
           var id = $(this).parent().find("#id").val();
           findProductById(id);
           console.log("áhduah",findProductById(id));
       });

	    function findProductById(id){   
            var productObj; 
	 	   $.ajax({
                type: "GET",
                url: "http://localhost:8080/webbanhang/api/product/"+id,
                // data: "JSON",
                // dataType: "dataType",
                success: function (product) {
                   $('#editModalProduct').modal();
                   $("#editModalProduct #code").val(product.code);
                   $("#editModalProduct #name").val(product.name);
                   $("#editModalProduct #price").val(product.price); 
                   $("#editModalProduct #description").val(product.description);
                   $("#editModalProduct #websiteUrl").val(product.websiteUrl);
                   
                   $("#idUpdate").val(product.id);            			
                }
            });
            
	    }
        
        $("#submitEditProduct").click(function (e) { 
            e.preventDefault();
    
            var data ={};
            var formData = $('#formEditProduct').serializeArray();
            var categoriesId =[];
           	//console.log(formData);
             $.each(formData, function (index, value) { 
            	if (value.name == "idCategories") {
            		categoriesId.push(value.value);
				}else{
					data[""+value.name+""]= value.value;
				}
            	
            });
            data['idCategories']=categoriesId;
			editProduct(data);
			debugger;
        });
        
	    function editProduct(data){
	    	id = $("#idUpdate").val(); 
	    	$.ajax({    
                contentType: "application/json",           
                url: "http://localhost:8080/webbanhang/api/product/update/"+id,
                type: "PUT",
                data:JSON.stringify(data),
                dataType: "json",
                success: function (response) {
                    console.log(response);    
                    
            		swal("Good job!", "Cập nhật thành công!", "success")                       		
                    setTimeout(() => {
                        window.location.href="${urlProducts}";
                    }, 2000);
                },
                error: function(response){
                    console.log("sadjiasj");
                    swal("Thất bại!", "Cập nhật thất bại!", "error")
                }
            });
	    }
        function deleteProduct(event,id){
        	event.preventDefault();
        	swal({
        		  title: "Bạn có chắc muốn xóa?",
        		  text: "",
        		  type: "warning",
        		  showCancelButton: true,
        		  confirmButtonClass: "btn-danger",
        		  confirmButtonText: "Yes",
        		  cancelButtonText: "No",
        		  closeOnConfirm: false,
        		  closeOnCancel: false
        		}).then(function(isConfirm){
                    if(isConfirm.value){
                        deleteById(id);
                    }
                });
                
        }
        function deleteById(id){
            $.ajax({
                type: "DELETE",
                url: "http://localhost:8080/webbanhang/api/product/delete/"+id,
                success: function (response) {
                    console.log(response);    
                    
            		swal("Good job!", "Xóa thành công!", "success")                       		
                    setTimeout(() => {
                        window.location.href="${urlProducts}";
                    }, 2000);
                },
                error: function(response){
                    console.log("sadjiasj");
                    swal("Thất bại!", "Xóa thất bại!", "error")
                }
            });
        }
	    // $(".btn-DeleteProduct").click(function (e) { 
        //     e.preventDefault();
        //     var id = $(this).parent().find("#id").val();
        //     deleteProduct();
        //     // $.ajax({
        //     //     type: "DELETE",
        //     //     url: "url",
        //     //     data: "data",
        //     //     dataType: "dataType",
        //     //     success: function (response) {
                    
        //     //     }
        //     // });
            
        // });
    </script>
    
</body>
</html>