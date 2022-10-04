package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/CSS/register.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css\"\r\n");
      out.write("        integrity=\"sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==\"\r\n");
      out.write("        crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("      <link rel=\"stylesheet\" href=\"../assets/CSS/responsive.css\"/>\r\n");
      out.write("    <title>Register</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- <header class=\"header\">\r\n");
      out.write("        <div class=\"header-logo-container\">\r\n");
      out.write("            <img class=\"header-logo\"\r\n");
      out.write("                src=\"https://th.bing.com/th/id/R.af2b82154a39f7ddd7e1cbcddf32540c?rik=VNWwpCivVSf%2f0g&pid=ImgRaw&r=0\"\r\n");
      out.write("                alt=\"logo-here\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"header-link\">\r\n");
      out.write("            <ul class=\"header-list-link\">\r\n");
      out.write("                <li class=\"active\"><a href=\"./index.html\">Home</a></li>\r\n");
      out.write("                <li>Store</li>\r\n");
      out.write("                <li>Sales</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"header-list-btn\">\r\n");
      out.write("                <button style=\"background-color: transparent;\"><a href=\"./register.html\">sign-up</a></button>\r\n");
      out.write("                <button><a href=\"./login.html\">sign-in</a></button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header> -->\r\n");
      out.write("    <div class=\"login\">\r\n");
      out.write("        <img class=\"login-logo\"\r\n");
      out.write("             src=\"../assets/Images/Logo_After_Login.png\">\r\n");
      out.write("        <form class=\"login-form\" action=\"./Access\" method=\"POST\">\r\n");
      out.write("            <input required class=\"login-form-text\" type=\"text\" name=\"userName\" placeholder=\"Username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("            <input required class=\"login-form-text\" type=\"password\" name=\"password\" placeholder=\"Password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("            <input required class=\"login-form-text\" type=\"password\" name=\"cofirm\" placeholder=\"Confirm password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cofirm}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("            <input required class=\"login-form-text\" type=\"number\" name=\"phone\" placeholder=\"Phone number\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("            <button class=\"login-form-submit\" name=\"op\" value=\"register\">Join with us</button>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <i style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i>\r\n");
      out.write("        </form>\r\n");
      out.write("        <div class=\"login-create\">\r\n");
      out.write("            <a href=\"./login.html\">You already have account ?</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- <footer class=\"footer\">\r\n");
      out.write("        <div class=\"footer-right\">\r\n");
      out.write("            <img class=\"footer-logo\"\r\n");
      out.write("                src=\"https://th.bing.com/th/id/R.af2b82154a39f7ddd7e1cbcddf32540c?rik=VNWwpCivVSf%2f0g&pid=ImgRaw&r=0\"\r\n");
      out.write("                alt=\"logo-here\" />\r\n");
      out.write("            <div>\r\n");
      out.write("                <h1>F-Gear Store</h1>\r\n");
      out.write("                <p>Address: 210/10 LÃª VÄn Sá»¹, PhÆ°á»ng 10, Quáº­n PhÃº Nhuáº­n</p>\r\n");
      out.write("                <p>Contact: 0903333333</p>\r\n");
      out.write("                <div class=\"footer-link\">\r\n");
      out.write("                    <i class=\"fa-brands fa-facebook\"></i>\r\n");
      out.write("                    <i class=\"fa-brands fa-instagram\"></i>\r\n");
      out.write("                    <i class=\"fa-brands fa-youtube\"></i>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"footer-left\">\r\n");
      out.write("            <h3>Payments policy</h3>\r\n");
      out.write("            <h3>Maintenance policy</h3>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer> -->\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"JavaScript/FormValidate.js\"></script>\r\n");
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
}
