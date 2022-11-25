package hr.lib;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public final Logger log = LogManager.getLogger(this.getClass());

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		log.info("Servlet async: " + req.isAsyncSupported());
		log.debug("Huy test");
		log.info("Huy test info");
        ServletOutputStream out = resp.getOutputStream();
        out.write("Hello Lotous".getBytes());
        out.flush();
        out.close();
    }
}
