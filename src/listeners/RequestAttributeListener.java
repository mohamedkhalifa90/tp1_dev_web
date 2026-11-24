package listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener
        implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("Request attribute added: "
                + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("Request attribute replaced: "
                + event.getName());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("Request attribute removed: "
                + event.getName());
    }
}