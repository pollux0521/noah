package pollux.noah.handler.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        org.springframework.security.core.Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.setAttribute("greeting", authentication.getName()+" 왔누");
        response.sendRedirect("/");
        
    }
}
