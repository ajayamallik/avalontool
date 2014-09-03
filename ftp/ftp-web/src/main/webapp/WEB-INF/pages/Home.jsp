<%@ taglib uri="http://www.springframework.org/tags" prefix="sf" %>
    <!DOCTYPE HTML>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>AdminWelcome</title>
        <link href="resources/css/css_reset.css" rel="stylesheet" type="text/css">
        <link href="resources/css/main_style.css" rel="stylesheet" type="text/css">
        <link href="resources/css/theme.css" rel="stylesheet" type="text/css">
        <script language="javascript" src="resources/js/main.js"></script>
        <script language="javascript" src="resources/js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript">
        </script>
    </head>

    <body>
        <%@ include file="/WEB-INF/templates/header.jsp" %>
            <div id="page_container">
                <div id="content_main">
                    <div id="breadcrumb">
                        <ul>
                            <li><a href="#">Home</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="help_link">
                    <!-- <a href="#"/>
			</a> -->
                </div>
                <div class="clearfix"></div>
                <h1></h1>
                <div id="content_main">
                    <div class="clearfix"></div>
                    <div class="section_box">
                        <div class="main_page">
                            <!--   <p class="welcome_text">This application will provide you all the services and functionalities that you will need to track all information related to the school.</p>-->
                            <div class="main_page_left" style="border: 1px solid #BCD1E6; padding: 0px;">
                                <div class="section_box_header">
                                    <h2></h2>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                </div>
                                <div class="clearfix"></div>

                                <div class="pagination_container">
                                    <form action="" name="formEvent" method="POST">
                                        <input type="hidden" name="paginate" id="paginate" />
                                        <input type="hidden" name="itemNo" id="itemNo" />

                                    </form>
                                </div>

                            </div>

                            <div class="main_page_right"></div>

                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

            </div>

            <%@ include file="/WEB-INF/templates/footer.jsp" %>
    </body>

    </html>
