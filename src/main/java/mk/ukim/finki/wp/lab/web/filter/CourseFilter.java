package mk.ukim.finki.wp.lab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class CourseFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest requestT = (HttpServletRequest) request;
        HttpServletResponse responseE = (HttpServletResponse) response;

        String courseId = (String) requestT.getSession().getAttribute("courseId");
        String path = requestT.getServletPath();

        if(!"/courses".equals(path) && !"/courses/add".equals(path) && !path.contains("/courses/delete") && !path.contains("/courses/edit") && courseId == null)
        {
            responseE.sendRedirect("/courses");
        }
        else {
            chain.doFilter(request, response);
        }
    }
}
