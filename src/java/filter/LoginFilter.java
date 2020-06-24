package filter;

import entity.Kullanici;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse res = (HttpServletResponse) sr1;

        String url = req.getRequestURI();

        Kullanici k = (Kullanici) req.getSession().getAttribute("valid_user");

        if (k == null) {
            if (url.contains("create") || url.contains("index") || url.contains("update") || url.contains("logout")) {
                res.sendRedirect(req.getContextPath() + "/giris/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }

        } else {
            if (url.contains("login")) {
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            }else if(url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath()+"/giris/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }

        }

    }

}
