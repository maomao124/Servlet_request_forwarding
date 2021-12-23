package mao.servlet_request_forwarding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Project name(项目名称)：Servlet_request_forwarding
 * Package(包名): mao.servlet_request_forwarding
 * Class(类名): DoServlet
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/23
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)：
 * Web 应用在处理客户端的请求时，经常需要多个 Web 资源共同协作才能生成响应结果。
 * 但由于 Serlvet 对象无法直接调用其他 Servlet 的 service() 方法，所以 Servlet 规范提供了 2 种解决方案：
 * 请求转发
 * 请求包含
 * 请求转发
 * 请求转发属于服务器行为。容器接收请求后，Servlet 会先对请求做一些预处理，然后将请求传递给其他 Web 资源，来完成包括生成响应在内的后续工作。
 * RequestDispatcher 接口
 * javax.servlet 包中定义了一个 RequestDispatcher 接口，RequestDispatcher 对象由 Servlet 容器创建，
 * 用于封装由路径所标识的 Web 资源。利用 RequestDispatcher 对象可以把请求转发给其他的 Web 资源。
 * Servlet 可以通过 2 种方式获得 RequestDispatcher 对象：
 * 调用 ServletContext 的 getRequestDispatcher(String path) 方法，参数 path 指定目标资源的路径，必须为绝对路径；
 * 调用 ServletRequest 的 getRequestDispatcher(String path) 方法，参数 path 指定目标资源的路径，可以为绝对路径，也可以为相对路径。
 * 返回值类型	        方法	        功能描述
 * void	forward(ServletRequest request,ServletResponse response) 	用于将请求转发给另一个 Web 资源。该方法必须在响应提交给客户端之前被调用
 *  void	include(ServletRequest request,ServletResponse response) 	用于将其他的资源作为当前响应内容包含进来
 *
 *
 */

@WebServlet("/DoServlet")
public class DoServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // 设置向页面输出内容格式
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String webName = (String) request.getAttribute("webName");
        String url = (String) request.getAttribute("url");
        String welcome = (String) request.getAttribute("welcome");
        if (webName != null)
        {
            writer.write("<h3>" + webName + "</h3>");
        }
        if (url != null)
        {
            writer.write("<h3>" + url + "</h3>");
        }
        if (welcome != null)
        {
            writer.write("<h3>" + welcome + "</h3>");
        }
        String username = request.getParameter("username");
        // 获取密码
        String password = request.getParameter("password");
        // 获取性别
        String sex = request.getParameter("sex");
        // 获取城市
        String city = request.getParameter("city");
        // 获取使用语言返回是String数组
        String[] languages = request.getParameterValues("language");
        writer.write("用户名：" + username + "<br/>" + "密码：" + password + "<br/>" + "性别：" + sex + "<br/>" + "城市：" + city
                + "<br/>" + "使用过的语言：" + Arrays.toString(languages) + "<br/>"
        );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }

}
