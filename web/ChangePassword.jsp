<%-- 
    Document   : login
    Created on : May 31, 2023, 5:38:22 PM
    Author     : VICTUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <!-- Link Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <!-- Link Icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Link CSS -->
        <link rel="stylesheet" href="UI/css/style.css">
        <link rel="stylesheet" href="UI/css/styleForm.css">
        <!-- formValidate JS -->
        <script src="UI/js/formValidate.js"></script>
    </head>
    <body>
        <div class="container nopadding">
            <!-- Login Form -->
            <div class="login form">
                <!-- Screen Header -->
                <header>Change Password</header>
                <!-- Display Signup Error -->
                <div class="form-message">${requestScope.mess1}</div>
                <!-- Main Form -->
                <form id="ChangePass-form" action="ChangePasswordController">
                    <!-- Password -->
                    <div class="form-group">
                        <label for="oldpass" class="form-label">Password</label>
                        <input id="oldpass" name="oldpass" type="text" placeholder="Enter Password"
                               class="form-control"><br>
                        <label for="newpass" class="form-label">New Pass</label>
                        <input id="newpass" name="newpass" type="text" placeholder="Enter Password"
                               class="form-control"><br><!-- comment -->
                        <label for="cfpass" class="form-label">Confirm Pass</label>
                        <input id="cfpass" name="cfpass" type="text" placeholder="Enter Password"
                               class="form-control"><br>
                        <span class="form-message"></span>
                    </div>
                </form>
                <!-- Form Buttons -->
                <div class="row">
                    <!-- Screen switch -->
                    <div class="col-lg-9">
                    </div>
                    <!-- Summit button -->
                    <div class="col-lg-3">
                        <div class="summit-button">
                            <button type="submit" form="ChangePass-form">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            Validator({
                form: '#login-form',
                formGroupSelector: '.form-group',
                errorSelector: '.form-message',
                rules: [
                    Validator.minLength('#password', 6)
                ]
            });
        </script>
    </body>
</html>
