
var MyJavaClass = Java.type('com.practicalneo4j.graphstory.controller.UserController');

var result = MyJavaClass.fun1('John Doe');
print(result);

// Hi there from Java, John Doe
// greetings from java

$('#javaScriptFromjava').on("click", function() {
	//searchByUsername($('#username').val());
	MyJavaClass.fun1('John Doe 2');
	return false;
});