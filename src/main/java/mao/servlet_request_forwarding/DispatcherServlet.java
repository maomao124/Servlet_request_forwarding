package mao.servlet_request_forwarding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project name(项目名称)：Servlet_request_forwarding
 * Package(包名): mao.servlet_request_forwarding
 * Class(类名): DispatcherServlet
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/23
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)：
 * Context 域对象和 request 域对象对比，具有以下 4 点差异：
 * 1） 生命周期不同
 * Context 域对象的生命周期从容器启动开始，到容器关闭或者 Web 应用被移除时结束；
 * request 域对象的生命周期从客户端向容器发送请求开始，到对这次请求做出响应后结束。
 * 2） 作用域不同
 * Context 域对象对整个 Web 应用内的所有Servlet都有效；
 * request 域对象只对本次请求涉及的 Servlet 有效。
 * 3） Web 应用中数量不同
 * 整个 Web 应用中只有一个 Context 域对象；
 * 由于 Servlet 能处理多个请求，因此 Web 应用中的每个 Servlet 实例都可以有多个 request 域对象。
 * 4） 实现数据共享的方式不同
 * Context 域对象可以独立完成动态资源之间的数据共享；
 * Request 域对象需要与请求转发配合使用才能实现动态资源之间的数据共享。
 */

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // 设置向页面输出内容格式
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        // 尝试在请求转发前向response缓冲区写入内容，最后在页面查看是否展示
        writer.write("<h1>这是转发前在响应信息内的内容！</h1>");
        // 向reuqest域对象中添加属性，传递给下一个web资源
        request.setAttribute("123", "7456");
        // 转发
        request.getRequestDispatcher("/DoServlet").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}
