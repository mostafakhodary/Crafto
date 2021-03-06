package crafto.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crafto.util.DbUtils;

@WebServlet("/Main")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MainServlet()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        DbUtils dbUtils = new DbUtils();
        request.setAttribute( "files", dbUtils.getFiles() );
        dbUtils.close();

        request.getRequestDispatcher( "/WEB-INF/Main.jsp" ).forward( request,
            response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
