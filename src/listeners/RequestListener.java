package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest request =
                (HttpServletRequest) event.getServletRequest();

        System.out.println("Request initialized!");
        System.out.println("Requested URL: " + request.getRequestURL());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        HttpServletRequest request =
                (HttpServletRequest) event.getServletRequest();

        System.out.println("Request destroyed!");
        System.out.println("Requested URL: " + request.getRequestURL());
    }
}