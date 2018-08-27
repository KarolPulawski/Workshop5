package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoggedFilter", urlPatterns = {"/tweet/*"})
public class LoggedFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession sess = request.getSession();
        if(((Boolean)sess.getAttribute("passCheck"))) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("/signIn");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
