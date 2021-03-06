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
            <a class="brand" href="#">Diploma</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li ><a href="index">Items</a></li>
                    <li class="active"><a href="sales">Sales</a></li>
                    <li><a href="analiz">Analize</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>






<div class="container">
<div class="row">
    <div class="span4">
        <h3>Items</h3>

        <c:choose>
            <c:when test="${!empty subjectList}">
                <table class="table table-bordered table-hover itemenu" >

                    <c:forEach items="${subjectList}" var="item">
                        <tr>

                            <td> <a href="choose/${item.id}">${item.name}</a></td>

                        </tr>
                    </c:forEach>
                </table>
            </c:when>

            <c:otherwise>
                <a href="/index">add</a>some items

            </c:otherwise>
        </c:choose>
    </div>
    <div class="span8">
        <h2>The sales of ${actives.name}</h2>
        <form:form commandName="sale" method="post" action="addsale">
            <form:input path="period"  placeholder="period"/>
            <form:input path="quantity" placeholder="quantity"/>
            <input type="submit" class="btn btn-success" value="add sale" />
        </form:form>

        <c:choose>
            <c:when test="${!empty salesList}">
                <table class="table table-striped">
                    <c:forEach items="${salesList}" var="sale">
                        <tr>
                            <td>${sale.period}</td>
                            <td>${sale.quantity}</td>
                            <td><a href="deletes/${sale.id}"><i class="icon-remove-sign"></i></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                add some sales to ${actives.name}
            </c:otherwise>
        </c:choose>


    </div>
</div>


</div>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/js/jquery.js"></script>


<script>
    $(document).ready(function() {
        $( "td:contains('${actives.name}')" ).css( 'font-weight','bold' );
    });
</script>



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