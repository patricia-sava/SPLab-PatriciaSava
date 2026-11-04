package ro.uvt.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        // Logare Înainte de procesarea cererii
        System.out.println("[LOG BEFORE] Request URL: " + req.getRequestURI() + " | Method: " + req.getMethod());

        // Trecerea cererii mai departe în lanț (Chain of Responsibility)
        chain.doFilter(request, response);

        // Logare După procesarea cererii
        System.out.println("[LOG AFTER] Request processed for URL: " + req.getRequestURI());
    }
}