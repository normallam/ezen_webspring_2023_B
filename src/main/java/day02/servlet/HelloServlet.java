package day02.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name ="helloServlet", value="/hello-servlet") //명시적인 가동성 떄문에 쓰는거라 안써도됨
public class HelloServlet extends HttpServlet {
    // 오른쪽 클릭 -> 생성 -> 오버라이딩메소드
    // -- 서블릿의 라이브 사이클 [생명주기 : 서블릿객체가 생성되고 실행되는 제거 되기까지]
        // init(), doGet(), service(), destroy() : 개발자가 아닌 서블릿 컨테이너가 서블릿들을 관리하면서 호출.
    public String message;

    // 1. 최초로 해당 서블릿의 URL 요청 했을 때 1번 실행 [다음 요청부터는 동일항 서블릿객체 사용하므로]
    @Override
    public void init() throws ServletException {
        System.out.println("HelloServlet.init");
        message = "서블릿 객체 탄생";
    }
    // 2. 해당 서블릿의 URL 요청했을 떄 get, put, delete 등 메소드 매핑 연결 [요청마다 실행]
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); //soutm
        super.service(req, res);
    }
    // 3. 서비스가 호출한 메소드를 get, post, put, delete 등등 실행[매 요청마다 실행]
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.doGet");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println(message);
    }
    // 4. 톰캣[서버]가 종료될때. [서블릿객체 사라짐] 실행
    @Override
    public void destroy() {System.out.println("HelloServlet.destroy");}


}
