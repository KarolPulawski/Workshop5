<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="/tweet/allTweetsCurrentUser">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>My tweets</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/tweet/allTweets">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>All tweets</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/tweet/addTweet">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Create tweet</span>
        </a>
    </li>




<li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Messages</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Message panel:</h6>
            <a class="dropdown-item" href="/send">Send new</a>
            <a class="dropdown-item" href="/messages">Received</a>
            <a class="dropdown-item" href="/history">History</a>


            <%--<h6 class="dropdown-header">Login Screens:</h6>--%>
            <%--<a class="dropdown-item" href="login.html">Login</a>--%>
            <%--<a class="dropdown-item" href="register.html">Register</a>--%>
            <%--<a class="dropdown-item" href="forgot-password.html">Forgot Password</a>--%>
            <%--<div class="dropdown-divider"></div>--%>
            <%--<h6 class="dropdown-header">Other Pages:</h6>--%>
            <%--<a class="dropdown-item" href="404.html">404 Page</a>--%>
            <%--<a class="dropdown-item active" href="blank.html">Blank Page</a>--%>
        </div>
    </li>
    <%--<li class="nav-item">--%>
        <%--<a class="nav-link" href="charts.html">--%>
            <%--<i class="fas fa-fw fa-chart-area"></i>--%>
            <%--<span>Charts</span></a>--%>
    <%--</li>--%>
    <%--<li class="nav-item">--%>
        <%--<a class="nav-link" href="tables.html">--%>
            <%--<i class="fas fa-fw fa-table"></i>--%>
            <%--<span>Tables</span></a>--%>
    <%--</li>--%>
</ul>