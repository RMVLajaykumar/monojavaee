/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.91
 * Generated at: 2024-07-22 12:40:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_002dprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar", Long.valueOf(1721195111816L));
    _jspx_dependants.put("jar:file:/D:/javaee/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/13-bankapplication-demo/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/fn.tld", Long.valueOf(1323238578000L));
    _jspx_dependants.put("jar:file:/D:/javaee/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/13-bankapplication-demo/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1323238578000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("    integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("    integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Edit Profile</title>\r\n");
      out.write("<style>\r\n");
      out.write("  body {\r\n");
      out.write("    background-color: #f8f9fa;\r\n");
      out.write("  }\r\n");
      out.write("  .container {\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("  }\r\n");
      out.write("  .header {\r\n");
      out.write("    background-color: #007bff;\r\n");
      out.write("    color: #fff;\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("  }\r\n");
      out.write("  .form-container {\r\n");
      out.write("    background-color: #ffffff;\r\n");
      out.write("    padding: 30px;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\r\n");
      out.write("  }\r\n");
      out.write("  .btn-primary {\r\n");
      out.write("    background-color: #28a745;\r\n");
      out.write("    border-color: #28a745;\r\n");
      out.write("  }\r\n");
      out.write("  .btn-primary:hover {\r\n");
      out.write("    background-color: #218838;\r\n");
      out.write("    border-color: #1e7e34;\r\n");
      out.write("  }\r\n");
      out.write("  .btn-secondary {\r\n");
      out.write("    background-color: #6c757d;\r\n");
      out.write("    border-color: #6c757d;\r\n");
      out.write("  }\r\n");
      out.write("  .btn-secondary:hover {\r\n");
      out.write("    background-color: #5a6268;\r\n");
      out.write("    border-color: #545b62;\r\n");
      out.write("  }\r\n");
      out.write("  .btn-danger {\r\n");
      out.write("    background-color: #dc3545;\r\n");
      out.write("    border-color: #dc3545;\r\n");
      out.write("  }\r\n");
      out.write("  .btn-danger:hover {\r\n");
      out.write("    background-color: #c82333;\r\n");
      out.write("    border-color: #bd2130;\r\n");
      out.write("  }\r\n");
      out.write("  .form-group label {\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("  }\r\n");
      out.write("  .form-group input {\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("  }\r\n");
      out.write("  .button-group {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    gap: 10px; /* Space between buttons */\r\n");
      out.write("  }\r\n");
      out.write("  .logout-button {\r\n");
      out.write("    position: fixed;\r\n");
      out.write("    top: 20px;\r\n");
      out.write("    right: 20px;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container mt-4\">\r\n");
      out.write("  <div class=\"row justify-content-center\">\r\n");
      out.write("    <div class=\"col-12\">\r\n");
      out.write("      <div class=\"header text-center\">\r\n");
      out.write("        <h1>Edit Profile</h1>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <a href=\"logout\" class=\"btn btn-danger logout-button\">Logout</a>\r\n");
      out.write("  <div class=\"row justify-content-center mt-4\">\r\n");
      out.write("    <div class=\"col-lg-8 col-md-10 col-sm-12\">\r\n");
      out.write("      <div class=\"form-container\">\r\n");
      out.write("        <form action=\"user\" method=\"post\">\r\n");
      out.write("          <input type=\"hidden\" name=\"command\" value=\"editProfile\">\r\n");
      out.write("          <div class=\"form-group mb-4\"> \r\n");
      out.write("            <label for=\"firstName\">First Name</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"firstName\" placeholder=\"Enter First Name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.first_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"first_name\"> \r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-group mb-4\"> \r\n");
      out.write("            <label for=\"lastName\">Last Name</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"lastName\" placeholder=\"Enter Last Name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.last_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"last_name\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-group mb-4\"> \r\n");
      out.write("            <label for=\"password\">Password</label>\r\n");
      out.write("            <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Enter Password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.password}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"password\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-group mt-4 button-group\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">Update</button>\r\n");
      out.write("            <button type=\"reset\" class=\"btn btn-secondary\">Cancel</button>\r\n");
      out.write("            <a href=\"user\" class=\"btn btn-danger\">Back</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
