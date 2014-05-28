<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap, from Twitter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <style>
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="resources/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="resources/ico/favicon.png">
</head>
<body>



<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Diploma</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Items</a></li>
                    <li><a href="sales">Sales</a></li>
                    <li><a href="#contact">Analize</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">

    <div id="subject">
        <form:form method="post" action="add" commandName="subject">
                   <form:input path="name" />
                   <input type="submit" class="btn btn-success" value="add item" />
        </form:form>

        <h3>Items</h3>
        <c:if test="${!empty subjectList}">
            <table class="table table-striped">
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>actions</th>
                </tr>
                <c:forEach items="${subjectList}" var="subject">
                    <tr>
                        <td>${subject.id}</td>
                        <td>${subject.name}</td>
                        <td><a href="delete/${subject.id}"><i class="icon-remove-sign"></i></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div><!--END subject-->



    </div>








</div> <!-- /container -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap-transition.js"></script>
<script src="resources/js/bootstrap-alert.js"></script>
<script src="resources/js/bootstrap-modal.js"></script>
<script src="resources/js/bootstrap-dropdown.js"></script>
<script src="resources/js/bootstrap-scrollspy.js"></script>
<script src="resources/js/bootstrap-tab.js"></script>
<script src="resources/js/bootstrap-tooltip.js"></script>
<script src="resources/js/bootstrap-popover.js"></script>
<script src="resources/js/bootstrap-button.js"></script>
<script src="resources/js/bootstrap-collapse.js"></script>
<script src="resources/js/bootstrap-carousel.js"></script>
<script src="resources/js/bootstrap-typeahead.js"></script>




</body>
</html>