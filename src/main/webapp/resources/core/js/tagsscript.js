	

$(document).ready(function() {



	
       
       
//////////////////////////////////////пошук tags/////////////////////////////////////////////	
       
  
       
       
       
       $(document).on('click', '#tagSaveToBase', function(){
    	   alert ("new  save link clicked!");
    	   
    	   var userIdArray = $('#relwikitagstable .ctitle').map(function(ctitle){
    		   return $(ctitle).html(); }).toArray();
    	  
    	
    	   var arr100 = [];
    	   $('#relwikitagstable tr:not(.header)').each(function() {
    	     var that = $(this);
    	     var title = that.find('td').eq(1).text();  
    	     var text = that.find('td').eq(2).text();      
    	  
    	     var obj = { 'title': title , 'text': text };
    	     arr100.push(obj);
    	   });
    	  
    
    	   var table = $('#relwikitagstable');
    	   var data = [];

    	   
    	   table.find('tr').each(function (i, el) {
    	   
    	     if( i != 0){
    	       var $tds = $(this).find('td');
    	    
    	       var row = [];
    	       $tds.each(function (i, el){
    	         row.push($(this).text());
    	   
    	       });
    	       data.push(row);
    	     }
    	         
    	   });
    	 
    	  
    	   var tagTableData = []; 
    	  tagTableData  =  JSON.stringify(data);
    	  returned = $.parseJSON(tagTableData);
    	


    	   var testArr = [];  
    	
      	    
      	    var token = $("#_csrf").val();
      	    $.ajaxSetup({ headers: {'X-CSRF-Token': token } });
      	   
      	 
      	    
      	 
    	   
    
      	  
    	   $.ajax({
              	
                     url: "/tags/save", 
                    data: JSON.stringify(arr100), 
                    type: "POST",
             processData: false, 
             contentType: "application/json",
                success : function(data, textStatus, jqXHR){
              	 
              	 $("#rendingconteinertagsset").html(data);
                                                          },
                                                  
                  error: function(jqXHR, textStatus, errorThrown){
                      alert('add contnt error: ' + errorThrown);
                                                  	         	}
               }); 
         
      
    	   
    	   
       });
       
 
       
    // Changed to On() method to use delegation from container
       $( "#tagSearchFormByPageName" ).on("click", "content222", function() { 
       alert("Delegated Button Clicked")
       }); 

     
 
       
       $(document).on("click", "a.tr" , function() {
    	   $($(this).closest("tr")).remove()
       });
       
  
    
       
       
       
       
       
       
     
       $("#tagSearchFormByPageName").validate({
           rules: {
                  usernamesug: {required: true }
                   },
                   
          messages: {
        	  usernamesug: {required: "Set wiki page name or any start word"}
               
                     },
                     
      submitHandler: function(form) {
   	

    	  var form = document.getElementById("tagSearchFormByPageName");
	      myForm = new FormData(form);
	      var un5 =  $('wikipagename');  //ok
	    

     	   myForm.append('wikipagename', un5);
     	 
   	    
   	    ///////////add csrf///////////////////////////////////////////////////////////
   	    
   	    var token = $("#_csrf").val();
   	    $.ajaxSetup({ headers: {'X-CSRF-Token': token } });
   	  
   	     
   	 
       ////////////end csrf///////////////////////////////////////////////////////////
   	    
   	 
             $.ajax({
                	
                    url : "/tags/search", 
                    data : myForm,
                    type : "POST",
                    headers: {'Content-Type': undefined},
                    enctype: 'multipart/form-data',
                    encoding: "UTF-8",
                    processData: false, 
                    contentType:false,
                    success : function(data, textStatus, jqXHR){
                   	 
                   	 $("#rendingconteinertagsset").html(data);
                                                               },
                                                       
                       error: function(jqXHR, textStatus, errorThrown){
                           alert('add contnt error: ' + errorThrown);
                                                       	         	}
                   
                   
                        }); 
       
           }
      
       
       });
       
    
    	
    		
    			  
    			 
    			 
       
});