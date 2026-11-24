package listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        int count = counter.incrementAndGet();

        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", count);

        System.out.println("New session created. Active sessions: " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        int count = counter.decrementAndGet();

        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", count);

        System.out.println("Session destroyed. Active sessions: " + count);
    }
}