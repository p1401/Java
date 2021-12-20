package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Product;
import java.util.ArrayList;

public final class shop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_end_begin.release();
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
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                margin-top: 20px;\n");
      out.write("                padding: 0;\n");
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
      out.write("            \n");
      out.write("            footer{\n");
      out.write("                position: relative;\n");
      out.write("                width: 100%;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: space-between;\n");
      out.write("                flex-wrap: wrap;\n");
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
      out.write("\n");
      out.write("            /* Content */\n");
      out.write("\n");
      out.write("            #mainContainer {\n");
      out.write("                width: 1200px;\n");
      out.write("                height:100%;\n");
      out.write("                margin: 40px auto;\n");
      out.write("                padding: 20px 5px;\n");
      out.write("                background: #f1f1f1;\n");
      out.write("                boder:10px solid black;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            div.about {\n");
      out.write("                boder: 10px solid pink;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            /* shop */\n");
      out.write("            .product {\n");
      out.write("                /*              position: absolute;*/\n");
      out.write("                top: 50%;\n");
      out.write("                left: 50%;\n");
      out.write("                transform: translate(0,0);\n");
      out.write("                width: 240px;\n");
      out.write("                height: 300px;\n");
      out.write("                background: #fff;\n");
      out.write("                box-shadow: 0 5px 15px rgba(0,0,0,.25);\n");
      out.write("                border-radius: 5px;\n");
      out.write("                overflow: hidden;\n");
      out.write("                margin: 35px;\n");
      out.write("            }\n");
      out.write("            .product .imgbox {\n");
      out.write("                height: 100%;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            .product .imgbox img {\n");
      out.write("                display: block;\n");
      out.write("                width: 99%;\n");
      out.write("                margin: 20px auto 0;\n");
      out.write("            }\n");
      out.write("            .details {\n");
      out.write("                position: absolute;\n");
      out.write("                width: 100%;\n");
      out.write("                bottom: -50px;\n");
      out.write("                background: #fff; \n");
      out.write("                padding: 10px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                box-shadow: 0 0 0 rgba(0,0,0,0);\n");
      out.write("                transition: .5s;\n");
      out.write("            }/*\n");
      out.write("            */            \n");
      out.write("            .product:hover .details {\n");
      out.write("                bottom: 0;\n");
      out.write("            }\n");
      out.write("            .details h2 {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                font-size: 16px;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            .details h2 span {\n");
      out.write("                font-size: 13px;\n");
      out.write("                color: #ccc;\n");
      out.write("                font-weight: normal;\n");
      out.write("            }\n");
      out.write("            .details .price {\n");
      out.write("                /*                position: absolute;*/\n");
      out.write("                top: 10px;\n");
      out.write("                right: 10px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: #ff4faf;\n");
      out.write("                font-size: 20px;  \n");
      out.write("            }/*\n");
      out.write("            */          \n");
      out.write("            .details a{\n");
      out.write("                display: block;\n");
      out.write("                padding: 5px;\n");
      out.write("                color: #fff;\n");
      out.write("                margin: 15px 0 0;\n");
      out.write("                background: #ff4faf;\n");
      out.write("                text-align: center;\n");
      out.write("                text-decoration: none;\n");
      out.write("                transition: .3s;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .details a:hover {\n");
      out.write("                background: #ff209a; \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .products ul,.products ul li {\n");
      out.write("                list-style: none;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        ");

            HttpSession s = request.getSession(true);
            String us = (String) s.getAttribute("username");
            String admin = (String) s.getAttribute("admin");
            ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("listProduct");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- START HEADER -->\n");
      out.write("        <div id=\"header\" style=\"height: 120px; margin: 0 auto; background-color:#000000;\">\n");
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
      out.write("                <li><a  href=\"about\" >About</a></li>\n");
      out.write("                <li><a  href=\"shop\" >Shop</a></li>\n");
      out.write("\n");
      out.write("                ");
 if (admin != null) {
      out.write("\n");
      out.write("                <li><a  href=\"manager\">Manager account</a></li>\n");
      out.write("                <li><a  href=\"manageritem\">Manager Product</a></li>\n");
      out.write("                    ");
} else {
      out.write("\n");
      out.write("                <li><a  href=\"cart\">My Order</a></li>");
}
      out.write("\n");
      out.write("                <li><a  href=\"logout\">Logout</a></li>\n");
      out.write("                    ");
} else {
      out.write("\n");
      out.write("                <li><a  href=\"about\">About </a></li>\n");
      out.write("                <li><a  href=\"shop\">Shop</a></li>\n");
      out.write("                <li><a  href=\"login\">Login</a></li>\n");
      out.write("                <li><a  href=\"register\">Register</a></li>\n");
      out.write("                <li><a  href=\"contact\">Contact</a></li>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </section>\t\t\n");
      out.write("        <!-- END MENU -->\n");
      out.write("\n");
      out.write("        <!-- START CONTENT PAGE -->\n");
      out.write("\n");
      out.write("        <section id=\"mainContainer\">\n");
      out.write("            <div class=\"about\" >\n");
      out.write("                <h2 style=\"font-size:45px;font-family:Time New Roman\">WELCOME TO OUR SHOP</h2>\n");
      out.write("                <div class=\"products\">\n");
      out.write("                    ");
 for (Product p : list) {
      out.write("\n");
      out.write("                    <ul>\n");
      out.write("                        <li>\n");
      out.write("                            <div class=\"product\">\n");
      out.write("                                <div class=\"imgbox\">\n");
      out.write("                                    <img src=\"img/");
      out.print(p.getProductImage());
      out.write("\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"details\">\n");
      out.write("                                    <h2> ");
      out.print(p.getProductName());
      out.write("<br><span>Product ID: ");
      out.print(p.getProductID());
      out.write("</span></h2>\n");
      out.write("                                    <div class=\"price\"> ");
      out.print(p.getProductPrice());
      out.write(" </div>\n");
      out.write("                                    <a href=\"detail?pid=");
      out.print(p.getProductID());
      out.write("&price=");
      out.print(p.getProductPrice());
      out.write("\"> See Detail </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                    <div class=\"page\">\n");
      out.write("                        <p>");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <!-- end page -->\n");
      out.write("\n");
      out.write("        <!-- start Footer-->\n");
      out.write("        <div id=\"footer\" style=\"height: 220px; margin: 0 auto;padding: 0 20px;background-color: #D3D3D3; border: none solid #8C0209;\">\n");
      out.write("            <p style=\"float:right;margin:30px;font-size:50px;margin-right:200px;\"> <span style=\"color:red\">HZ</span><span style=\"color:#000000\"> Computer</span></p>\n");
      out.write("            <p style=\"float:right;margin-top:120px;margin-right:-260px;\">\n");
      out.write("                <a href=\"https://www.instagram.com/\"><img src=\"src/ins.png\" style=\"width:65px; height:65px;\"></img>\n");
      out.write("                <a href=\"https://www.facebook.com/\"><img src=\"src/fb.png\" style=\"width:65px; height:65px;\"></img>\n");
      out.write("            </p>\n");
      out.write("            <p style=\"float:left;margin-top:20px;margin-left:100px;text-align:left;font-size:20px;\"><br/>\n");
      out.write("                <span style=\"padding-left:100px;\"><a href=\"about\">MORE ABOUT US</a></span><br/>\n");
      out.write("                <span style=\"padding-left:100px;\"><a href=\"contact\">CONTACT</a></span><br/>\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setBegin(1);
    _jspx_th_c_forEach_0.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${maxPage}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_0.setVar("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <a href=\"shop?txtPage=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
