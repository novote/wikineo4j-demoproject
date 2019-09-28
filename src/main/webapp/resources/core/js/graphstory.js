//////

/* 
$(document).ready(function(){
	

	$('#btnSaveCasePost').click(function() {
		
		  if($('#formAddPoster')[0].checkValidity()){
              alert("form submitting");
          }
		
	}

  $("#formAddPoster").validate({
    	caseTitle: {
             required: true,
        
         },
         caseDescription: {
             required: true,
             minlength: 5
         }
       
    }
    
    
    });
});


$(document).ready(function() { 
	    // bind form using ajaxForm 
	    $('#formAddPoster').ajaxForm( { beforeSubmit: validate } ); 
	});

function validate(formData, jqForm, options) { 
	
	 
	   var caseTitleValue = $('input[name=caseTitle]').fieldValue(); 
	    var caseDescriptionValue = $('input[name=caseDescription]').fieldValue(); 
	   // var form = jqForm[0]; 
	   // if (!form.caseTitle.value || !form.caseDescription.value) { 
	 if (!caseTitleValue || !caseDescriptionValue) {
	        alert('Please enter a value for both caseTitle and caseDescription'); 
	        return false; 
	    } 
	    alert('Both fields contain values.'); 
	}




//1. case open/close spoiler addCasePost
$('#casePostAddEdit').on('click', 'a#addcasepost', function() {
	console.log( $( this ).text() );

	
		$("#btnSaveCasePost").text('Add Case');

	return false;
});




$('#formAddPoster').on('submit', function(event) {
//	  alert('You submitted the form!');
event.preventDefault();
	  
	  $('#btnSaveCasePost').click(function() {
		//  event.preventDefault();
			//if ($('#postId').val() == ''){
				//$("#btnSaveCasePost").text('Add CasePost');
				//if ($('#caseTitle').val() == ''||$('#caseTitle').val() == ||$('#caseTitle').val() == null){
				
				//	$('#caseTitle').text('');}
		  
			//  $('#formAddPoster').ajaxForm( { beforeSubmit: validate } ); 
				casePostUpload();
				return false;
			}else{
				//$("#btnSaveCasePost").text('Edit CasePost');
				updateCase();
				return false;
			}

	
		});
	});
	
	  */

/*
//bed request
function handleData( responseData ) {

    // Do what you want with the data
    console.log(responseData);
    window.location.href = '/'; 
    //No Javascript on this page
  //  If <script> tags have a "type" attribute, it should equal "text/javascript" or "application/javascript". Also scripts must be parsable (syntactically correct).
}


function casePostUpload()
        {
	//var myForm = form.find('formAddPoster');
	//    myData = new FormData();
	 //   myData.append('multipart',  myForm);
	    
	    var  myForm = new FormData($('#formAddPoster'));
	    myForm.append('multipart',  myForm);
		 
           $
              .ajax({
              	
                  url : "/video/addCasePost",
                  //url: urlFromActionFild,
                  data : myForm,
                 // data : myData,
                  type : 'POST',
                  headers: {'Content-Type': undefined},
                  enctype: 'multipart/form-data',
                  processData: false, 
                  contentType:false,
                //dont  override:false,
                  success : function(data, textStatus, jqXHR){
                	  
                //	$('#casePost').prepend('<br/>  title '+data.caseTitle+' Desc '+data.caseDescription+'<br/></td></tr>');
           			
           		//	$('#caseTitle').val("");
           		//	$('#caseDescription').val(""); // window.location.reload();
                	
                	  
                
                		
                	//}
                	//}
                	  
                	 // $('#content').prepend('<tr><td><a href="'+data.url+'" target="_blank">'+data.title+'</a>   <br/>tags: '+data.tagstr+' ::   Posted by '+data.userNameForPost+' at <a href="/viewpost/'+data.contentId+'">'+data.timestampAsStr+'</a><br/></td></tr>');
          			
                	//  $('#casePost').prepend('<br/>Poster: '+data.casePoster+' ::  title '+data.caseTitle+' at '+data.timestampAsStr+'<br/></td></tr>');
            			
            			//$('#caseTitle').val("");
            			//$('#casePoster').val(""); // window.location.reload();
                	  
                	//  handleData(data);
                	 // if (jqXHR.status === 200){  window.location.href = '/';   }
                	 
                	 
          			//If <script> tags have a "type" attribute, it should equal "text/javascript" or "application/javascript". Also scripts must be parsable (syntactically correct).
          		},
                 
                  	alert('add contnt error: ' + errorThrown);
                  }
              });
        }
        */
/*
$(document).ajaxError(function (event, jqxhr, settings, exception) {

    if (jqxhr.status == 401) { //Forbidden, go to login
        //Use a reload, WIF will redirect to Login
        location.reload(true);
    }
});
*/

/*----------------------------------- CasePost Section---------------------------------*/
//All casepost hending go here

/*
 * 
 * 
 * 
 * 
 * 
$('#btnSaveCasePost').click(function() {
	if ($('#casePostId').val() == ''){
		$("#btnSaveCasePost").text('Add CasePost');
		// formElement = document.querySelector("form");
		//var form = document.forms.namedItem("formAddPoster");
		casePostUpload();
		return false;
	}else{
		$("#btnSaveCasePost").text('Edit CasePost');
		updateCase();
		return false;
	}
});

var caseFormFiles = [];
var caseJsonAll = [];
$(document)
        .on(
                "change",
                "#casePosterLoad",
                function(event) {
                	caseFormFiles = event.target.caseFormFiles;
                	//caseJsonAll = casePostformToJSON();
                })

$(document)
        .on(
                "click",
                "#allCaseSubmit",
                function() {
                	casePostUpload();
                })
                
                
                
  function casePostUpload()
          {
	
	//test find url from fprm 
	var myForm = form.find('formAddPoster');
	var urlFromActionFild = myForm.attr('action');
	
	var fileData = this.files[0],
    myData = new FormData();
   myData.append('image', fileData);
   myData.append('multipart',  myForm);
	
	          
              
             $
                .ajax({
                	
                    url : "/video/addCasePost",
                    //url: urlFromActionFild,
                    //data : myForm,
                    data : myData,
                    type : 'POST',
                    headers: {'Content-Type': undefined},
                    enctype: 'multipart/form-data',
                    processData: false, 
                    contentType:false,
                    success : function(data, textStatus, jqXHR){
            			
            			//$('#casePost').prepend('<tr><td><a href="'+data.url+'" target="_blank">'+data.caseTitle+'</a>   <br/>Ключові слова: '+data.caseTagstr+' ::  <br/>Доступні релізи для загрузки: '+data.caseDownloadLink+' :: <br/>Категория контента: '+data.caseCategory+' :: <br/>Постер контента: '+data.casePoster+' :: Опубліковано '+data.userNameForCasePost+' at <a href="/viewpost/'+data.casePostId+'">'+data.timestampAsStr+'</a><br/></td></tr>');
            			$('#casePost').prepend(<br/>tags: '+data.casePoster+' ::  title '+data.caseTitle+' at '+data.timestampAsStr+'<br/></td></tr>');
            			
            			$('#caseTitle').val("");
            			$('#url').val("");
            			//add test and in 3 line aboute
            			//$('#exampleTextarea').val("");
            			//$('#contentCateg').val("");
            			//$('#formContent').val("");
            			
            			$("#formAddPoster").hide();
            			//$("#addcontent").text('Add Content');
            		},
                    error : function(result){
                        //...;
                    	
                    	alert('add contnt error: ' + errorThrown);
                    }
                });
          }




//1. case open/close spoiler addCasePost
$('#casePostAddEdit').on('click', 'a#addCasePost', function() {
	console.log( $( this ).text() );
	
	if ( $("#casePostForm").is(":visible") ) {
		$("#addCasePost").text('Add Case');
		$("#casePostForm")[0].reset();
		$("#casePostForm").hide();
	}else{
		$("#casePostForm").show();
		$("#addCasePost").text("Cancel");
		$("#btnSaveCasePost").text('Add Case');
		
	}
	return false;
});

//edit 
//?? #url_ #fotourl_
$('body').on('click','a.editCasePost', function() {
	var id = $(this).attr('id');
	id = id.replace("edit_","");
	
	if ( $("#casePostForm").is(":visible") ) {
		$("#addCasePost").text('Add Case');
		$("#casePostForm")[0].reset();
		$("#casePostForm").hide();
	}else{
		var p = $("#casePostAddEdit").position();
		$(window).scrollTop(p.top);
		$("#casePostForm").show();
		$("#addCasePost").text("Cancel");
		$("#casePostId").val(id);
		
		$("#caseTitle").val($("#caseTitle_"+id).text());
		$("#caseDescription").val($("#caseDescription_"+id).text());
		$("#caseCategory").val($("#caseCategory_"+id).text());
		$("#caseGenres").val($("#caseGenres_"+id).text());
		$("#caseActors").val($("#caseActors_"+id).text());
		$("#caseScreenwriter").val($("#caseScreenwriter_"+id).text());
		$("#caseProduserCreator").val($("#caseProduserCreator_"+id).text());
		$("#caseCantry").val($("#caseCantry_"+id).text());		
		$("#caseStudios").val($("#caseStudios_"+id).text());
		$("#caseSaundLenguchTranslete").val($("#caseSaundLenguchTranslete_"+id).text());
		$("#caseCertification").val($("#caseCertification_"+id).text());
		$("#caseReleased").val($("#caseReleased_"+id).text());
		$("#caseTrailer").val($("#caseTrailer_"+id).text());
		$("#downloadUrl").val($("#downloadUrl_"+id).attr('href'));
		$("#caseTagstr").val($("#caseTagstr_"+id).text());
		
		
		$("#btnSaveCasePost").text('Edit Case');
		
	}
	return false;
});

// casePost requst send function



//Helper function for  to serialize all the form fields into a JSON string
// "caseCategory": $('#caseCategory').val(), "caseGenres": $('#caseGenres').val(),
function casePostformToJSON() {
		if($("#tagstr").length == 0) {
		return JSON.stringify({"caseTitle": $('#caseTitle').val(), "caseDescription": $('#caseDescription').val(),
			 "caseActors": $('#caseActors').val(), "caseScreenwriter": $('#caseScreenwriter').val(),
			"caseProduserCreator": $('#caseProduserCreator').val(), "caseCantry": $('#caseCantry').val(), "caseStudios": $('#caseStudios').val(),
			"caseSaundLenguchTranslete": $('#caseSaundLenguchTranslete').val(), "caseCertification": $('#caseCertification').val(), "caseReleased": $('#caseReleased').val(),
			"caseTrailer": $('#caseTrailer').val(), "caseDownloadLink": $('#caseDownloadLink').val()
			});
	}else{
		
		return JSON.stringify({"caseTitle": $('#caseTitle').val(), "caseDescription": $('#caseDescription').val(),
			 "caseActors": $('#caseActors').val(), "caseScreenwriter": $('#caseScreenwriter').val(),
				"caseProduserCreator": $('#caseProduserCreator').val(), "caseCantry": $('#caseCantry').val(), "caseStudios": $('#caseStudios').val(),
				"caseSaundLenguchTranslete": $('#caseSaundLenguchTranslete').val(), "caseCertification": $('#caseCertification').val(), "caseReleased": $('#caseReleased').val(),
				"caseTrailer": $('#caseTrailer').val(), "caseDownloadLink": $('#caseDownloadLink').val(), "caseTagstr": $('#caseTagstr').val() 
			});
	
	}
}



//pasgenum?
//1. with pagenum
$('#moreCasePost').on('click', 'a.next', function() {
	getCasePost(parseInt($("#casePostCount").val())+1);
	return false;
});

//1.1 ??? showCasePostStream  
function getCasePost(skip){
	$.ajax({
		type: 'GET',
		url: '/casesfeed/'+skip,
		dataType: "json",
		success: showCasePostStream
	});
}
 


function showCasePostStream(data){
	var list = data == null ? [] : (data.casePost instanceof Array ? data.casePost : [data.casePost]);
	$tr = $('#moreCasePost');
	$tr.hide();
	$.each(list, function(index, casePost) {
		if(index<3){
			var id =casePost.casePostId;
			ti =(casePost.owner ? '<a class="editCasePost" id="edit_'+id+'">Edit</a> <a class="deleteCasePost" id="delete_'+id+'">Delete</a>' : '');
			
			$('#casePost').append('<tr id="_'+id+'"><td><a href="'+casePost.url+'" id="url_'+id+'" target="_blank">'+casePost.title+'</a> '+ ti +'<br/>tags:<span id="tags_'+id+'">'+casePost.tagstr+'</span> ::   Posted by '+casePost.userNameForPost+' at <a href="/viewcase/'+casePost.casePostId+'">'+casePost.timestampAsStr+'</a> </td></tr>');
		}
	});
	
	if (data.next) {
		casePostcount = parseInt($("#casePostCount").val())+1;
		$("#casePostCount").val(casePostccount);
		$('#casePost').append($tr);
		$tr.show();
	}else{
		$('#casePost').append('<tr><td>No more case :(</td></tr>');
	}
}


*/

/*-----------------------------------END CasePost Section---------------------------------*/



/////////

$( document ).ready(function() {
	 getTags();
	 searchProducts();
	 menu();
	 loadMoArProducts();
});

function menu(){
	 var pgurl = window.location.href;
	 $("#socialli").addClass("active");  
     $("#graphstorynav li a").each(function(){
    	 
          if(pgurl.indexOf($(this).attr("href")) > -1){
        	  $("#socialli").removeClass("active"); 
        	  $(this).parent().addClass("active");  
          }
          
     });
}

$('#updateUserData').on("click", function() {
	updateUserData();
	return false;
});

$('#socialfriendsearch').on("click", function() {
	searchByUsername($('#username').val());
	return false;
});

$('#userstoadd').on('click', 'a.addfriend', function() {
	addfriend($(this).attr('id'));
	$(this).closest("tr").remove();
	return false;
});

$('#following').on('click', 'a.removefriend', function() {
	removefriend($(this).attr('id'));
	return false;
});

$('#morecontent').on('click', 'a.next', function() {
	getcontent(parseInt($("#contentcount").val())+1);
	return false;
});

$('#contentAddEdit').on('click', 'a#addcontent', function() {
	
	if ( $("#contentform").is(":visible") ) {
		$("#addcontent").text('Add Content');
		$("#contentform")[0].reset();
		$("#contentform").hide();
	}else{
		$("#contentform").show();
		$("#addcontent").text("Cancel");
		$("#btnSaveContent").text('Add Content');
		
	}
	return false;
});


$('#btnSaveContent').click(function() {
	if ($('#contentId').val() == ''){
		addContent();
		return false;
	}else{
		updateContent();
		return false;
	}
});

$('#btnSaveContent2').click(function() {
	if ($('#contentId').val() == ''){
		addContent2();
		return false;
	}else{
		updateContent2();
		return false;
	}
});

$('#btnSaveContentByOne').click(function() {
	if ($('#contentId').val() == ''){
		addContent3byOne();
		return false;
	}else{
		updateContent3byOne();
		return false;
	}
});


$('body').on('click','a.deleteContent', function() {
	if (confirm("Are you sure you want to delete this content?")) {
		var id = $(this).attr('id');
		id = id.replace("delete_","");
		
		$.ajax({
			type: 'GET',
			url: '/posts/delete/' + id,
			success: function(data, textStatus, jqXHR){
				id = "tr#_"+id;
				$(id).remove();
				alert('Content deleted');
			}
		});
    }
	return false;
});

$('body').on('click','a.editcontent', function() {
	var id = $(this).attr('id');
	id = id.replace("edit_","");
	
	if ( $("#contentform").is(":visible") ) {
		$("#addcontent").text('Add Content');
		$("#contentform")[0].reset();
		$("#contentform").hide();
	}else{
		var p = $("#contentAddEdit").position();
		$(window).scrollTop(p.top);
		$("#contentform").show();
		$("#addcontent").text("Cancel");
		$("#contentId").val(id);
		$("#title").val($("#contentTitle_"+id).text());
		$("#casePostCommentText").val($("#contentText_"+id).text());
		$("#url").val($("#url_"+id).attr('href'));
		$("#tagstr").val($("#tags_"+id).text());
		$("#btnSaveContent").text('Edit Content');
		
	}
	return false;
});

$('ul').on('click','a.productNodeId', function() {
	var productNodeId= $(this).attr("id");
	var id = "#pdescr_"+productNodeId;

	if ( $(id).is(":visible") ) 
	{
		$(".list-group-item").removeClass("active");
		$(".productdescr").hide();
		$(".productNodeId").text("See Product Description...");
	}
	else
	{
		$(".productNodeId").text("See Product Description...");
		$(".list-group-item").removeClass("active");
		$(".productdescr").hide();
		$(id).parent().addClass("active");
		$(id).show();
		$(this).text("Close");
		createUserProductViewRel(productNodeId);
	}
	
	return false;
});

$('td').on('click','a.productNodeId', function() {
	var productNodeId= $(this).attr("id");
	var id = "#pdescr_"+productNodeId;

	if ( $(id).is(":visible") ) 
	{
		$(".productdescr").hide();
	}
	else
	{
		$(".productdescr").hide();
		$(id).show();
	}
	
	return false;
});

function updateUserData() {
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: '/user/edit',
		dataType: "json",
		data: userformToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('User updated');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('User update error: ' + textStatus);
		}
	});
}

function searchByUsername(u) {
	$.ajax({
		type: 'GET',
		url: '/searchbyusername/' + u,
		dataType: "json",
		success: renderSearchByUsername
	});
}

function addfriend(u) {
	$.ajax({
		type: 'GET',
		url: '/follow/'+u,
		dataType: "json",
		success: renderFollowers
	});
}

function removefriend(u) {
	$.ajax({
		type: 'GET',
		url: '/unfollow/'+u,
		dataType: "json",
		success: renderFollowers
	});
}

function getcontent(skip){
	$.ajax({
		type: 'GET',
		url: '/postsfeed/'+skip,
		dataType: "json",
		success: showContentStream
	});
}


function addContent(){
	
	
	//var contentId =$("#contentId").val();
	var json = ConvertFormToJSON($("#contentform"));
	//var json = сonvertFormToJSON($("#contentform")); контролер не status":403,"error":"Forbidden
	    json = JSON.stringify(json);
    ///////////add csrf///////////////////////////////////////////////////////////
    
    var token = $("#_csrf").val();
    $.ajaxSetup({ headers: {'X-CSRF-Token': token } });
    alert('_csrf  token in login script: ' + token );
    
    ///////////////////////////////////////////////////////////////////////////////
    
    
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/posts/add',
		dataType: "json",
		data: json,
		success: function(data, textStatus, jqXHR){
			alert('url: ' + data.url);
			alert('title: ' + data.title);
			alert('tagstr: ' + data.tagstr);
			alert('timestampAsStr: ' + data.timestampAsStr);
			alert('casePostCommentText: ' + data.casePostCommentText);
			
			$('#content3').prepend('<tr><td><a href="'+data.url+'" target="_blank">'+data.title+'</a>   <br/> tags: '+data.tagstr+' <br/>   Posted by '+data.userNameForPost+' at <a href="/viewpost/'+data.contentId+'">'+data.timestampAsStr+'</a><br/></td></tr>');
			
			$('#title').val("");
			$('#url').val("");
			
			$("#contentform").hide();
			$("#addcontent").text('Add Content');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('add contnt error: ' + errorThrown);
			//add contnt error: SyntaxError: JSON.parse: unexpected character at line 1 column 1 of the JSON data
		}
		
	});
}


function addContent2(){
	
	
	//var contentId =$("#contentId").val();
	var json = ConvertFormToJSON($("#contentform"));
	//var json = сonvertFormToJSON($("#contentform")); контролер не status":403,"error":"Forbidden
	    json = JSON.stringify(json);
	    
    var validJsonString   =  validateJSON(json);
    ///////////add csrf///////////////////////////////////////////////////////////
    
    var token = $("#_csrf").val();
    $.ajaxSetup({ headers: {'X-CSRF-Token': token } });
    alert('_csrf  token in login script: ' + token );
    
    ///////////////////////////////////////////////////////////////////////////////
    
    
	$.ajax({
		//processData: false, 
       // contentType:false,
		//url: '/posts/add',
		url: '/posts/addbs4',
		type: 'POST',
		contentType: 'application/json',
		//dataType: "json",
		data: json,
		success: function(data, textStatus, jqXHR){
			
			$('#title').val("");
			$('#url').val("");
			$('#casePostCommentText').val("");
			$("#contentform").hide();
			$("#addcontent").text('Публікувати галас');
			alert('Content updated');
			
			$("#rendConteinerUpdatedSocialPost").html(data); 
		  	   
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('add contnt error: ' + errorThrown);
			//add contnt error: SyntaxError: JSON.parse: unexpected character at line 1 column 1 of the JSON data
		   //Content type 'text/plain;charset=UTF-8' not supported
			// complete: function(data){ window.location.replace("/social" ); }
		},
		complete: function(){// window.location.replace("/social");
		} 
		
	});
}


function addContent3byOne(){
	

	var json = ConvertFormToJSON($("#contentform"));
	    json = JSON.stringify(json);    
    var validJsonString   =  validateJSON(json);
    ///////////add csrf///////////////////////////////////////////////////////////
    
    var token = $("#_csrf").val();
    $.ajaxSetup({ headers: {'X-CSRF-Token': token } });
    alert('_csrf  token in login script: ' + token );
    
    ///////////////////////////////////////////////////////////////////////////////
    
    
	$.ajax({

		url: '/posts/addbone',
		type: 'POST',
		contentType: 'application/json',
		//dataType: "json",
		data: json,
		success: function(data, textStatus, jqXHR){
			
			$('#title').val("");
			$('#url').val("");
			$('#casePostCommentText').val("");
			$("#contentform").hide();
			$("#addcontent").text('Публікувати галас');
			alert('Content updated');
			
			$("#rendConteinerUpdatedSocialPostByOne").html(data); 
		  	   
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('add contnt error: ' + errorThrown);
			
		},
		complete: function(){} 
		
	});
}






function validateJSON(str) {
    try {
       JSON.parse(str);
    } catch (e) {
     return false;
    }
  return true;
}

function updateContent() {
	
	//var contentId =$("#contentId").val();
	var json = ConvertFormToJSON($("#contentform"));
	json=JSON.stringify(json);
	
	 ///////////add csrf///////////////////////////////////////////////////////////
    
    var token = $("#_csrf").val();
    $.ajaxSetup({ headers: {'X-CSRF-Token': token } });
    alert('_csrf  token in login script: ' + token );
    
    ///////////////////////////////////////////////////////////////////////////////
    
    
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: '/posts/edit',
		dataType: "json",
		data: json,
		success: function(data, textStatus, jqXHR){
			
			//$("#contentText_"+contentId).text(data.casePostCommentText);
			
			//$("#url_"+contentId).attr('href',data.url);
			//$("#tags_"+contentId).text(data.tagstr);
			$("#addcontent").text('Add Content');
			$("#contentform")[0].reset();
			$("#contentform").hide();
			alert('Content updated');
		},
		error: function(jqXHR, textStatus, errorThrown){
			//alert('Content update error: ' + textStatus);
		},
		complete: function(){ window.location.replace("/social");} 
		
	});
}

function createUserProductViewRel(productNodeId){
	$.ajax({
		type: 'GET',
		url: '/consumption/add/'+productNodeId,
		dataType: "json",
		success: function(data, textStatus, jqXHR){
			$("#userProductTrail").empty();
			
			$.each(data.productTrail, function(index, item) {
				$('#userProductTrail').append('<p><b>'+item.title+'</b><br> last viewed on: '+item.dateAsStr+'</p>');
			});
			
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('createUserProductViewRel add error: ' + textStatus);
		}
	});
}

function renderSearchByUsername(data) {
	var list = data == null ? [] : (data.users instanceof Array ? data.users : [data.users]);
	
	$('#userstoadd tr').remove();
	if (list.length <= 0 ) {
		$('#userstoadd').append('<tr><td>No Users Found<td></tr>');
	}
	$.each(list, function(index, users) {
		$('#userstoadd').append('<tr><td>'+users.firstname+' '+users.lastname+'<td><td><a href="#" id="' + users.username + '" class="addfriend">Add as Friend</a></td></tr>');
	});
}

function renderFollowers(data) {
	var list = data == null ? [] : (data.following instanceof Array ? data.following : [data.following]);
	
	$('#following tr').remove();
	
	if (list.length <= 0 ) {
		$('#following').append('<tr><td>No Friends<td></tr>');
	}
	$.each(list, function(index, following) {
		$('#following').append('<tr><td>'+following.firstname+' '+following.lastname+'<td><td><a href="#" id="' + following.username + '" class="removefriend">Remove</a></td></tr>');
	});
}

function showContentStream(data){
	var list = data == null ? [] : (data.content instanceof Array ? data.content : [data.content]);
	$tr = $('#morecontent');
	$tr.hide();
	$.each(list, function(index, content) {
		if(index<3){
			var id =content.contentId;
			ti =(content.owner ? '<a class="editcontent" id="edit_'+id+'">Edit</a> <a class="deletecontent" id="delete_'+id+'">Delete</a>' : '');
			
			$('#content').append('<tr id="_'+id+'"><td><a href="'+content.url+'" id="url_'+id+'" target="_blank">'+content.title+'</a> '+ ti +'<br/>tags:<span id="tags_'+id+'">'+content.tagstr+'</span> ::   Posted by '+content.userNameForPost+' at <a href="/viewpost/'+content.contentId+'">'+content.timestampAsStr+'</a> </td></tr>');
		}
	});
	
	if (data.next) {
		contentcount = parseInt($("#contentcount").val())+1;
		$("#contentcount").val(contentcount);
		$('#content').append($tr);
		$tr.show();
	}else{
		$('#content').append('<tr><td>No more content :(</td></tr>');
	}
}


//Helper function to serialize all the form fields into a JSON string
function userformToJSON() {
	return JSON.stringify({"firstname": $('#firstname').val(), "lastname": $('#lastname').val() });
}

//Helper function to serialize all the form fields into a JSON string  
//не работает с контролером
function contentformToJSON() {
	
	if($("#tagstr").length == 0) {
		return JSON.stringify({"title": $('#title').val(), "casePostCommentText": $('#casePostCommentText').val(), "url": $('#url').val() });
	}else{
		return JSON.stringify({"title": $('#title').val(), "casePostCommentText": $('#casePostCommentText').val(),  "url": $('#url').val(), "tagstr": $('#tagstr').val() });
	}
}
function ConvertFormToJSON(form){
    var array = jQuery(form).serializeArray();
    var json = {};
    
    jQuery.each(array, function() {
        json[this.name] = this.value || '';
    });
    
    return json;
}

function getTags(){
	
	// get tags via autocomplete - THIS IS FOR THE SOCIAL GRAPH / CONTENT SECTION
	$(document).on('keyup.autocomplete','input[name="tagstr"]', function(event){
		if (event.keyCode === $.ui.keyCode.TAB && $( this ).data( "autocomplete" ).menu.active )
		{
			event.preventDefault();
		}

		if(event.keyCode === $.ui.keyCode.COMMA){
			this.value = this.value+" ";
		}

		$(this).autocomplete({
			
			source: function( request, response ) {
				$.getJSON(  "/tag/" + extractLast( request.term.toLowerCase() ) + ".json", response );
			},
			search: function() {
				// custom minLength
				var term = extractLast( this.value );
				if ( term.length < 2 ) {
					return false;
				}
			},
			focus: function() {
				// prevent value inserted on focus
				return false;
			},
			select: function( event, ui ) {
	
				var terms = split( this.value );
				// remove the current input
				terms.pop();
	
				// add the selected item
				terms.push( ui.item.value );
				// add placeholder to get the comma-and-space at the end
				terms.push( "" );
				this.value = terms.join( "," );
				this.value = this.value + " ";
				return false;
			}
		});
	});
}

function searchProducts(){
	
	// get products via autocomplete - THIS IS FOR THE LOCATION GRAPH SECTION
	$(document).on('keyup.autocomplete','input[name="product"]', function(event){
		if (event.keyCode === $.ui.keyCode.TAB && $( this ).data( "autocomplete" ).menu.active )
		{
			event.preventDefault();
		}

		if(event.keyCode === $.ui.keyCode.COMMA){
			this.value = this.value+" ";
		}

		$(this).autocomplete({
			
			source: function( request, response ) {
				$.getJSON(  "/productsearch/" + extractLast( request.term.toLowerCase() ) + ".json", response );
			},
			search: function() {
				// custom minLength
			},
			focus: function() {
				// prevent value inserted on focus
				return false;
			},
			select: function( event, ui ) {
				this.value = ui.item.value;
				$("#productNodeId").val(ui.item.id);
				return false;
			}
		});
	});
}


function split( val ) {
	return val.split( /[,]+\s\s*/ );
}

function extractLast( term ) {
	return split( term ).pop();
}

function loadMoArProducts(){
	/*$('ul#productlist').jscroll({
		loadingHtml: '<div align="center" style="margin: 20px 0 20px 0"><li id="feed_load"><img src="/resources/img/loader.gif" alt="ajax loading indicator" class="ajax-loader"> &nbsp; Loading more products...</li></div>',
		padding: 10,
		nextSelector: 'a.jscroll-next:last',
		callback: postFeedLoad
	});
	*/
}


function postFeedLoad(){
	// you could do somthing here if necessary after a new page loads via jscroll.
	// I added this because that does happen. you're welcome.
}