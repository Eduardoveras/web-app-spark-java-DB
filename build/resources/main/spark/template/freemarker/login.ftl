<#include "/siteHeader.ftl">
<body">
<!-- Header -->
<div id="header">
    <h1>${message}</h1>
</div>
<div id="container">
    <br>
    <!-- Login Form -->
    <div id="login">
        <fieldset>
            <legend>Login to Start to Blog</legend>
            <br>
            <form class="col s12">
                <div class="row">
                    <div class="input-field col s12">
                        <input id="email" type="email" class="validate">
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="pass" type="password" class="validate">
                        <label for="pass">Password</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12">
                        <p>
                            <input type="checkbox" id="remember">
                            <label for="remember">Remember me</label>
                        </p>
                    </div>
                </div>
                <div class="divider"></div>
                <div class="row">
                    <div class="col m12">
                        <p class="right-align">
                            <input class="btn btn-large waves-effect waves-light" type="submit" name="action" value="Submit"></input>
                        </p>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
    <br>
    <div>
        <!-- <img src="img/write.jpg" alt="Image Not Found" /> -->
    </div>
</div>
<!-- Footer -->
<div id="footer">
    <h3>Blog all day, Blog all night!</h3>
</div>
</body>
</html>