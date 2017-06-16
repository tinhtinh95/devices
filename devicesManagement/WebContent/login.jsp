  <!DOCTYPE html>
  <html lang="en">
  <head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery/jquery-1.12.3.min.js" ></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/css/css.css">
  </head>
  <body>
  <center>
  <div class="container">
    <h1>Login</h1>
    <%
        if(request.getParameter("msg")!=null){
        	out.print("<div style=\"width:400px;height:50px\" class=\"alert alert-danger\" role=\"alert\">Wrong username or password</div>");
        }
    
    %>
    <form id="loginform" action="<%=request.getContextPath() %>/login" name="loginform" method="post">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" class="form-control" id="username" placeholder="Your Username" name="username" 
        onKeyUp="return check(this)">
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password" placeholder="Your password" name="password">
      </div>
      
      <button name="submit" type="submit" class="btn btn-login">Login</button>
    </form>
  </div>
  </center>
  </body>
  <script type="text/javascript">
              $(document).ready(function(){
            $("#loginform").validate({
              rules:{
                username:{
                  required: true,
                  maxlength: 30,
                },
                password:{
                  required: true,
                  maxlength: 50,
                },
              },
              messages:{
                username:{
                  required: "<span style='color:red'>Username is required</span>",
                  maxlength: "<span style='color:red'>Username maxlength: 30!</span>",
                },
                password:{
                  required: "<span style='color:red'>Password is required</span>",
                  maxlength: "<span style='color:red'>Password maxlength: 50!</span>",
                },
              },
            });
          });
        
var mikExp = /[$\\@\!\\\#%\^\&\*\(\)\[\]\+\_\{\}\`\~\=\|]/;
function check(val) {
var strPass = val.value;
var strLength = strPass.length;
var lchar = val.value.charAt((strLength) - 1);
if(lchar.search(mikExp) != -1) {
var tst = val.value.substring(0, (strLength) - 1);
val.value = tst;
   }
}

</script>
  </html>
         

