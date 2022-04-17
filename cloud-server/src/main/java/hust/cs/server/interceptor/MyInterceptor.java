package hust.cs.server.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: MyInterceptor
 * PackageName:hust.cs.server.interceptor
 * Description:
 * date: 2022/4/13 20:25
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }
}
