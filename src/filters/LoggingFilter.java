package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class LoggingFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

        String prefix = config.getInitParameter("logPrefix");

        System.out.println(prefix + " - LoggingFilter initialized");
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        System.out.println("Before Servlet");

        HttpServletRequest req = (HttpServletRequest) request;

        String url = req.getRequestURL().toString();

        System.out.println("Requested URL: " + url);

        long startTime = System.nanoTime();

        try {
            chain.doFilter(request, response);
        } finally {

            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1_000_000;

            System.out.println("Execution time: " + duration + " ms");
        }

        System.out.println("After Servlet");
    }

    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}

