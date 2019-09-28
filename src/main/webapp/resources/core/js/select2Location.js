$(document).ready(function() {
	
	
//autosugeest with select2 for location view
$(".itemSearch").select2({
    placeholder: "Search for an Product",
    minimumInputLength: 2,
    tags: [],
    ajax: {
        url: "/productsearch/product",
        dataType: 'json',
        type: "GET",
        quietMillis: 100,
        data: function (product2) {
            return {
            	product2: product2
            };
        },
        results: function (data) {
            return {
                results: $.map(data, function (item) {
                    return {
                    	
                        text: item.product2,
                       // item = product.title
                       // slug: item.slug,
                       // id: item.price,
                        id: item.productNodeId
                    }
                })
            };
        }
    }
});


});