package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dangnhap_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>HZ Computer</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"src/favicon.ico\">\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Mukta', sans-serif;\n");
      out.write("            background: url(\"src/background.jpg\")      no-repeat ;\n");
      out.write("            background-size: 2000px 1000px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /*/////////////// FONT STYLES ////////////////////*/\n");
      out.write("        .content-all {\n");
      out.write("            max-width: 500px;\n");
      out.write("            position: relative;\n");
      out.write("            margin: 200px auto;\n");
      out.write("            width: 50%;\n");
      out.write("            background-color: whitesmoke;\n");
      out.write("            border-radius: 20px;\n");
      out.write("        }\n");
      out.write("        .content-bottom {\n");
      out.write("            padding: 40px 40px;\n");
      out.write("            margin: 10px 10px;\n");
      out.write("            position: relative; \n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /*/////////////// FORM STYLES ////////////////////*/\n");
      out.write("\n");
      out.write("        form .field-group {\n");
      out.write("            background: rgba(255, 255, 255, 0.15);\n");
      out.write("            display: flex;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            padding: 2px 10px 2px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .field input {\n");
      out.write("            padding: 10px 0 10px 15px;\n");
      out.write("            font-size: 17px;\n");
      out.write("            font-weight: 300;\n");
      out.write("            letter-spacing: 1px;\n");
      out.write("            background: transparent;\n");
      out.write("            font-family: 'Mukta', sans-serif;\n");
      out.write("            width: 380.25px;\n");
      out.write("            background-color: #ccc;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .field input:hover{\n");
      out.write("            background-color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form .register a {\n");
      out.write("            font-size: 15px;\n");
      out.write("            letter-spacing: 2px;\n");
      out.write("            font-weight: normal;\n");
      out.write("            text-transform: uppercase;\n");
      out.write("            color: red !important;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"content-all\">\n");
      out.write("            <div class=\"content-bottom\">\n");
      out.write("                <form action=\"login\" method=\"post\">\n");
      out.write("                    <div>\n");
      out.write("                        <a href=\"home\"><img src=\"src/log.png\" style=\"margin-left: 100px;margin-top:-80px;width:200px;height:200px;\"></img></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"field-group\">\n");
      out.write("                        <span aria-hidden=\"true\"></span>\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input name=\"username\" id=\"text1\" type=\"text\" value=\"\" placeholder=\"Username\" required >\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"field-group\">\n");
      out.write("                        <span aria-hidden=\"true\"></span>\n");
      out.write("                        <div class=\"field\">\n");
      out.write("                            <input name=\"password\" id=\"myInput\" type=\"Password\" placeholder=\"Password\" required >\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"field\" style=\"margin-left: 10px\">\n");
      out.write("                        <input type=\"submit\" class=\"btn\" value=\"LOGIN\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"register\" style=\"margin-left: 120px;margin-top: 15px; \">\n");
      out.write("                        <a href=\"register\">CREATE ACCOUNT</a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                ");

                    if (request.getAttribute("errorMessage") != null) {
                
      out.write("\n");
      out.write("                <h2 style=\"color: red\">");
      out.print( request.getAttribute("errorMessage"));
      out.write("</h2>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
