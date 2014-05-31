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

    <script src="resources/js/jquery.js"></script>
    <script src="resources/js/core.js" ></script>
    <script src="resources/js/line.js" ></script>
</head>
<body>



<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Diploma</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li ><a href="index">Items</a></li>
                    <li ><a href="sales">Sales</a></li>
                    <li class="active"><a href="analiz">Analize</a></li>
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

                                <td> <a href="choosetoanaliz/${item.id}">${item.name}</a></td>

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
            <h2>The analize of ${actives.name}</h2>


            <c:choose>
                <c:when test="${!empty salesList}">


                    <!-- 2/3. This is the canvas that the graph is drawn on -->
                    <canvas id="cvs" width="640" height="350">[No canvas support]</canvas>

                    <!--
                    3/3. This creates and displays the graph. As it is here, you can call this from the window.onload event,
                    allowing you to put it in your pages header.
                    -->
                    <script>
                        $(document).ready(function ()
                        {
                            var line = new RGraph.Line('cvs', [
                                <c:forEach items="${salesList}" var="sale">
                                ${sale.quantity},
                                </c:forEach>],
                                [<c:forEach items="${ema}" var="n">
                                ${n}, </c:forEach>]
                            )
                                    .set('gutter.left',60)
                                    .set('hmargin', 10)
                                    .set('tickmarks', 'endcircle')
                                    .set('labels', [
                                        <c:forEach items="${salesList}" var="sale">
                                        '${sale.period}',
                                        </c:forEach>

                                    ])
                                    .draw();
                        })
                    </script>








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