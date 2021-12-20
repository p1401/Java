package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dangky_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>HZ Computer</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"src/favicon.ico\">\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                margin-top: 20px;padding: 0;\n");
      out.write("                background: #FFFFFF;\n");
      out.write("                text-align: justify;\n");
      out.write("                font-family: \"Helvetica Neue\", \"Lucida Grande\", \"Segoe UI\", Arial, Helvetica, Verdana, sans-serif;\n");
      out.write("                font-size:  0.875em;\n");
      out.write("                color: #616161;\t/*xám*/\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                padding-top: 10px;\n");
      out.write("                padding-bottom: 50px;\n");
      out.write("                padding-left: 50px;\n");
      out.write("                color: #000000;\n");
      out.write("                font-weight: normal;\n");
      out.write("                font-size: 2em;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            p {\n");
      out.write("                font-size: 14px; \n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Menu */\n");
      out.write("\n");
      out.write("            #menuContaniner {\n");
      out.write("                width: 500px;\n");
      out.write("                float: right;\n");
      out.write("                margin: -60px 0 0 0;\n");
      out.write("                background-color:#000000;\n");
      out.write("            }\n");
      out.write("            ul.main_nav {\n");
      out.write("                margin: 0 auto;\n");
      out.write("                margin-left: -250px;\t\n");
      out.write("                padding: 0;\n");
      out.write("                list-style: none;\n");
      out.write("                height: 50px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            ul.main_nav li {\n");
      out.write("                border-right: 1px solid #BCBCBC;\n");
      out.write("                float: left;\n");
      out.write("                position: relative;\n");
      out.write("                text-align: center;\n");
      out.write("                margin: 0;padding: 0;\n");
      out.write("                display: inline;\n");
      out.write("                height: 45px;\n");
      out.write("                padding-top: 5px;\n");
      out.write("            }\n");
      out.write("            ul.main_nav li a {\n");
      out.write("                width: 100px;\n");
      out.write("                padding: 10px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("                font-weight:bold;\n");
      out.write("                color:gold;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            ul.main_nav li a:hover{\n");
      out.write("                background-color: #FFFFFF;\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("            /* Content */\n");
      out.write("\n");
      out.write("            #mainContainer {\n");
      out.write("                width: 1200px;\n");
      out.write("                height: 100%;\n");
      out.write("                margin: 40px auto;\n");
      out.write("                padding: 20px 5px;\n");
      out.write("                background: #FFFACD;\n");
      out.write("                boder:10px solid black;\n");
      out.write("            }\n");
      out.write("            /* about */\n");
      out.write("            div.about {\n");
      out.write("                boder: 10px solid pink;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* REGISTER FORM*/\n");
      out.write("            input[type=text], select, textarea {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 12px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                margin-top: 6px;\n");
      out.write("                margin-bottom: 16px;\n");
      out.write("                resize: vertical;\n");
      out.write("            }\n");
      out.write("            input[type=password], select, textarea {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 12px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                margin-top: 6px;\n");
      out.write("                margin-bottom: 16px;\n");
      out.write("                resize: vertical;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=submit] {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: white;\n");
      out.write("                padding: 12px 20px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=submit]:hover {\n");
      out.write("                background-color: #45a049;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                border-radius: 0px;\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("                padding: 20px;\n");
      out.write("                width:500px;\n");
      out.write("                margin-left:350px;\n");
      out.write("                margin-top: 50px;\n");
      out.write("                text-align:left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        ");

            HttpSession s = request.getSession(true);
            String us = (String) s.getAttribute("username");
            String admin = (String) s.getAttribute("admin");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- START HEADER -->\n");
      out.write("          <div id=\"header\" style=\"height: 120px; margin: 0 auto; background-color:#000000;\">\n");
      out.write("            <div>\n");
      out.write("                <h1 style=\"float:left; margin-left:50px\">\n");
      out.write("                    <span style=\"\"><a href=\"home\" style=\"text-decoration:none;font-weight:bold;font-size:50px;color:red\">HZ</a> </span>\n");
      out.write("                    <span style=\"\"><a href=\"home\" style=\"text-decoration:none;font-weight:bold;font-size:50px;color:#ABABAB\">Computer</a></span>\n");
      out.write("                </h1>\n");
      out.write("                <p style=\"float:left;margin-top: 70px;font-weight: 900px;margin-left: 5px;word-spacing: 2px;color:red;font-size:15px;\">\n");
      out.write("                    Gaming Store\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- END HEADER -->\n");
      out.write("\n");
      out.write("        <!-- START MENU -->\n");
      out.write("        <section id=\"menuContaniner\">\n");
      out.write("            <ul class=\"main_nav\">\n");
      out.write("\n");
      out.write("                ");
 if (us != null) {
      out.write("\n");
      out.write("                <li ><a  href=\"about\" >About</a></li>\n");
      out.write("                <li ><a  href=\"shop\">Shop</a></li>\n");
      out.write("\n");
      out.write("                ");
 if (admin != null) {
      out.write("\n");
      out.write("                <li ><a  href=\"manager\">Manager account</a></li>\n");
      out.write("                <li ><a  href=\"manageritem\">Manager Product</a></li>\n");
      out.write("                    ");
} else {
      out.write("\n");
      out.write("                <li ><a  href=\"cart\">My Order</a></li>");
}
      out.write("\n");
      out.write("                <li ><a  href=\"logout\">Logout</a></li>\n");
      out.write("                    ");
} else {
      out.write("\n");
      out.write("                <li ><a  href=\"about\">About </a></li>\n");
      out.write("                <li ><a  href=\"shop\">Shop</a></li>\n");
      out.write("                <li ><a  href=\"login\">Login</a></li>\n");
      out.write("                <li ><a  href=\"register\">Register</a></li>\n");
      out.write("                <li ><a  href=\"contact\">Contact</a></li>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </section>\t\n");
      out.write("        <!-- END MENU -->\n");
      out.write("\n");
      out.write("        <!-- START CONTENT PAGE -->\n");
      out.write("\n");
      out.write("        <section id=\"mainContainer\">\n");
      out.write("            <div class=\"about\" >\n");
      out.write("                <h2 style=\"font-size:45px;font-family:Time New Roman\">SIGN UP</h2>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <form action=\"register\" method=\"POST\">\n");
      out.write("                        <p style=\"color: #DF4B3B; font-weight: bold; size: 20px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                        <label>Username</label>\n");
      out.write("                        <input oninput=\"checkUser()\" name=\"user\" type=\"text\" id=\"user-name\" class=\"form-control\" placeholder=\"User name\" required=\"\" autofocus=\"\">\n");
      out.write("                \n");
      out.write("                        <label>Password</label>\n");
      out.write("                        <input oninput=\"checkPass()\" name=\"pass\" type=\"password\" id=\"user-pass\" class=\"form-control\" placeholder=\"Password\" required=\"\" autofocus=\"\">\n");
      out.write("\n");
      out.write("                        <label>Re-enter Password</label>\n");
      out.write("                        <input name=\"repass\" type=\"password\" id=\"user-repeatpass\" class=\"form-control\" placeholder=\"Repeat Password\" required=\"\" autofocus=\"\">\n");
      out.write("\n");
      out.write("                        <label>Email</label>\n");
      out.write("                        <input name=\"email\" type=\"text\" id=\"user-email\" class=\"form-control\" placeholder=\"Email\" required=\"\" autofocus=\"\">\n");
      out.write("\n");
      out.write("                        <input type=\"submit\" value=\"Save\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        <!-- end page -->\n");
      out.write("\n");
      out.write("        <!-- start Footer-->\n");
      out.write("        <div id=\"footer\" style=\"height: 220px; margin: 0 auto;padding: 0 20px;\n");
      out.write("             background-color: #D3D3D3; border: none solid #8C0209;\">\n");
      out.write("            <p style=\"float:right;margin:30px;font-size:50px;margin-right:200px;\"> <span style=\"color:red\">HZ</span><span style=\"color:#000000\"> Computer</span></p>\n");
      out.write("            <p style=\"float:right;margin-top:120px;margin-right:-260px;\">\n");
      out.write("                <a href=\"https://www.instagram.com/\"><img src=\"src/ins.png\" style=\"width:65px; height:65px;\"></img>\n");
      out.write("                <a href=\"https://www.facebook.com/\"><img src=\"src/fb.png\" style=\"width:65px; height:65px;\"></img>\n");
      out.write("            </p>\n");
      out.write("            <p style=\"float:left;margin-top:20px;margin-left:100px;text-align:left;font-size:20px;\"><br/>\n");
      out.write("                \n");
      out.write("                <span style=\"padding-left:100px;\"><a href=\"about\">MORE ABOUT US</a></span><br/>\n");
      out.write("                <span style=\"padding-left:100px;\"><a href=\"contact\">CONTACT</a></span><br/>\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("        <!-- end page -->\n");
      out.write("        <script>\n");
      out.write("            function toggleResetPswd(e) {\n");
      out.write("                e.preventDefault();\n");
      out.write("                $('#logreg-forms .form-signin').toggle() // display:block or none\n");
      out.write("                $('#logreg-forms .form-reset').toggle() // display:block or none\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function toggleSignUp(e) {\n");
      out.write("                e.preventDefault();\n");
      out.write("                $('#logreg-forms .form-signin').toggle(); // display:block or none\n");
      out.write("                $('#logreg-forms .form-signup').toggle(); // display:block or none\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            $(() => {\n");
      out.write("                // Login Register Form\n");
      out.write("                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);\n");
      out.write("                $('#logreg-forms #cancel_reset').click(toggleResetPswd);\n");
      out.write("                $('#logreg-forms #btn-signup').click(toggleSignUp);\n");
      out.write("                $('#logreg-forms #cancel_signup').click(toggleSignUp);\n");
      out.write("            })\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
