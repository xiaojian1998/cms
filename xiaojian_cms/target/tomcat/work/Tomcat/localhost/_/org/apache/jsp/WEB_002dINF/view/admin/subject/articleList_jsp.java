/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-07-09 11:40:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.admin.subject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class articleList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>用户列表</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/resource/js/cms.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//查看文章详情\r\n");
      out.write("function toDetail(id){\r\n");
      out.write("\t$(\"#content-wrapper\").load(\"/article/get?id=\"+id)\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function query(){\r\n");
      out.write("\tvar cid=$(\"#channel\").val();\r\n");
      out.write("\tvar catid=$(\"#category\").val();\r\n");
      out.write("\t$(\"#content-wrapper\").load(\"/subject/toAddArticle?cid=\"+cid+\"&catid=\"+catid)\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//如果文章已经属于某个专题,则选中\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$.get(\"/subject/selectArtilceListBySid\",{sid:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'},function(list){\r\n");
      out.write("\t\tfor(var i in list){\r\n");
      out.write("\t\t\t$(\".ids\").each(function(){\r\n");
      out.write("\t\t\t\t\tif($(this).val()==list[i].id)\r\n");
      out.write("\t\t\t\t\t$(this).prop(\"checked\",true);\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("function add(){\r\n");
      out.write("var ids = new Array();\r\n");
      out.write(" $(\".ids:checked\").each(function(i){\r\n");
      out.write("\t ids[i] =$(this).val();\r\n");
      out.write(" })\r\n");
      out.write(" if(ids.length==0){\r\n");
      out.write("\t alert(\"请至少选中一个文章\")\r\n");
      out.write("\t return ;\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" //向专题中添加文章,需要传递两个参数,  ids:文章ID 的数组    .sid:专题的主键\r\n");
      out.write(" $.post(\"/subject/add\",{ids:ids,sid:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'},function(obj){\r\n");
      out.write("\t if(obj){\r\n");
      out.write("\t\t alert(\"添加成功!\")\r\n");
      out.write("\t }else{\r\n");
      out.write("\t\t alert(\"添加失败!\")\r\n");
      out.write("\t }\r\n");
      out.write(" })\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//自动加载文章的栏目\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:\"get\",\r\n");
      out.write("\t\turl:\"/channel/listChannle\",\r\n");
      out.write("\t\tsuccess:function(list){\r\n");
      out.write("\t\t\t$(\"#channel\").empty();\r\n");
      out.write("\t\t\tfor(var i in list){\r\n");
      out.write("\t\t\t\t$(\"#channel\").append(\"<option value='\"+list[i].id+\"'>\"+list[i].name+\"</option>\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#channel\").val('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("\t//为栏目添加绑定事件\r\n");
      out.write("\t$(\"#channel\").change(function(){\r\n");
      out.write("\t\t //先清空原有的栏目下的分类\r\n");
      out.write("\t\t\t $(\"#category\").empty();\r\n");
      out.write("\t\t\tvar cid =$(this).val();//获取当前的下拉框的id\r\n");
      out.write("\t\t\t//根据ID 获取栏目下的分类\r\n");
      out.write("\t\t\t $.get(\"/channel/listCategory\",{cid:cid},function(list){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t for(var i in list){\r\n");
      out.write("\t\t\t  $(\"#category\").append(\"<option value='\"+list[i].id+\"'>\"+list[i].name+\"</option>\")\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t $(\"#category\").val('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${catid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t \r\n");
      out.write("\t })\r\n");
      out.write("\t})\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<button class=\"btn btn-info\" type=\"button\" onclick=\"add()\">添加文章</button>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--  根据文章栏目查询 和 文章分类查询 -->\r\n");
      out.write("\t\t <div style=\"float: right\">\r\n");
      out.write("\t\t<form class=\"form-inline\" >\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"channel\">文章栏目</label>  <object>请选择</object> <select\r\n");
      out.write("\t\t\t\t\tclass=\"form-control\" id=\"channel\"\r\n");
      out.write("\t\t\t\t\tname=\"channelId\">\r\n");
      out.write("\t\t\t\t\t<option></option>\r\n");
      out.write("\t\t\t\t</select> <label for=\"category\">文章分类</label> <object>请选择</object><select\r\n");
      out.write("\t\t\t\t\tclass=\"form-control\" id=\"category\"\r\n");
      out.write("\t\t\t\t\tname=\"categoryId\">\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-info\"  type=\"button\" onclick=\"query()\">查询</button>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>  \r\n");
      out.write("\r\n");
      out.write("\t\t<table class=\"table table-sm  table-hover table-bordered \">\r\n");
      out.write("\t\t\t<thead class=\"thead-light\">\r\n");
      out.write("\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t<td>文章ID</td>\r\n");
      out.write("\t\t\t\t\t<td>作者</td>\r\n");
      out.write("\t\t\t\t\t<td>文章标题</td>\r\n");
      out.write("\t\t\t\t\t<td>发布时间</td>\r\n");
      out.write("\t\t\t\t    <td>栏目</td> \r\n");
      out.write("\t\t\t\t\t<td>分类</td> \r\n");
      out.write("\t\t\t\t\t<td>操作</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("             \r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/admin/subject/articleList.jsp(142,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/admin/subject/articleList.jsp(142,3) '${list }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${list }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/view/admin/subject/articleList.jsp(142,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("a");
    // /WEB-INF/view/admin/subject/articleList.jsp(142,3) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("index");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<tr align=\"center\">\r\n");
          out.write("\t\t\t\t\t<td><input type=\"checkbox\" class=\"ids\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${index.index+1 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.created}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.cname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td> \r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.catname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td> \r\n");
          out.write("\t\t\t\t\t<td><button type=\"button\" class=\"btn btn-info\"\r\n");
          out.write("\t\t\t\t\t\t\tonclick=\"toDetail(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(")\">详情</button></td>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}