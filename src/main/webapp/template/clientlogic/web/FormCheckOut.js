$(".site-btn").click(function (e) {
    e.preventDefault();
    var data = {};
    var formData = $("#formCheckOut").serializeArray();
    formData.map(function (value) {

        data[""+ value.name +""] = value.value;
    });
    addOrder(data);
});

function addOrder(data) {
    debugger;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/webbanhang/api/checkout",
        data: JSON.stringify(data),
        dataType: "json",
        success: function (response) {
			
			tata.success('OK', 'Đặt hàng thành công', {
	                position: 'tr',
	                animate: 'slide',
					duration: 3000
            });    
			setTimeout(() => {
                window.location.href="http://localhost:8080/webbanhang/detail_cart";   
            }, 6000);
			
        },
        error: function (res) {
            tata.error('Ohh', 'Đặt hàng thất bại', {
                position: 'tr',
                animate: 'slide'
            });
        }
    });
}