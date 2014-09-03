<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
        <link rel="shortcut icon" href="resources/images/symbol.png" type="image/x-icon" />
        <link href="resources/css/reset.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/960.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/coolMenu.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="resources/css/css_reset.css" rel="stylesheet" type="text/css">
        <link href="resources/css/main_style.css" rel="stylesheet" type="text/css">
        <link href="resources/css/theme.css" rel="stylesheet" type="text/css">

        <script type="text/javascript" src="resources/js/modernizr-1.6.min.js"></script>
    </head>
    <div id="topbar">
        <div id="topbar_wraper">
            <div class="date_stamp">
                &nbsp;&nbsp;Welcome
                <sec:authentication property="principal.username" />
            </div>
            <div class="global_links">
                <a href="admin.html">Home</a> | <a href='<c:url value="/j_spring_security_logout"/>'>Logout</a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div id="banner">
        <div class="bannerwraper">
            <div id="logo">
                <img src="resources/images/avalonlogo.png" hspace="10" border="0" align="middle">
            </div>

            <div style="float: right; margin-top: 50px; margin-top: 55px;"></div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div id="menubar">
        <div class="menubarwraper">



            <div class="container_16">
                <div class="grid_16">




                    <ul id="coolMenu">

                        <li><a href="#">Request&nbsp;&nbsp;&nbsp;&nbsp;</a>

                            <ul class="noJS">
                                <div class="row">
                                    <div class="filesubmenubarwraper">
                                        <lj>
                                            <a href="approval.html">New</a>
                                        </lj>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="filesubmenubarwraper">
                                        <lj>
                                            <a href="pendingapprovals.html">Pending </a>
                                        </lj>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="filesubmenubarwraper">
                                        <lj>
                                            <a href="approvedrequests.html">Approved</a>
                                        </lj>
                                    </div>
                                </div>                                

                            </ul>
                        </li>


						<li><a href="admintab.html">Configure&nbsp;&nbsp;&nbsp;&nbsp;</a>

                        </li>






                        <li><a href="admintab.html">Admin&nbsp;&nbsp;&nbsp;&nbsp;</a>

                            <ul class="noJS">

                                <div class="row"> 

                                    <sec:authorize access="hasRole('CREATEROLE')">

                                        <div class="row">
                                            <div class="reviewsubmenubarwraper">
                                                <lm>
                                                    <a href="newUserRoleDetails.html">New Role</a>
                                                </lm>
                                            </div>
                                    </sec:authorize>

                                    <sec:authorize access="hasRole('MANAGEROLE')">

                                        <div class="row">
                                            <div class="reviewsubmenubarwraper">
                                                <lm>
                                                    <a href="manageUserRole.html">Manage Role</a>
                                                </lm>
                                            </div>
                                    </sec:authorize>

                                    <sec:authorize access="hasRole('CREATEUSER')">
                                        <div class="row">
                                            <div class="reviewsubmenubarwraper">
                                                <lm>
                                                    <a href="createuser.html">New User</a>
                                                </lm>
                                            </div>
                                    </sec:authorize>

                                    <sec:authorize access="hasRole('MANAGEUSER')">
                                        <div class="row">
                                            <div class="reviewsubmenubarwraper">
                                                <lm>
                                                    <a href="manageSystemUser.html">Manage User</a>
                                                </lm>
                                            </div>
                                    </sec:authorize>


                                    </div>
                            </ul>
                        </li>
                        
                       
                    </ul>


                    </div>
                    </div>
                    </div>
                    </div>

