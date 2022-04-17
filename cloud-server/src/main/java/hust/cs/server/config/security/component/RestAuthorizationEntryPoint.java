package hust.cs.server.config.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import hust.cs.server.pojo.RespBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 当未登录或者token失效时访问接口时，自定义返回结果
 */
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        System.out.println(request.getRequestURL());
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        parameterMap.forEach((key,value)->{
//            System.out.println("key:"+key);
//            for (String s : value) {
//                System.out.println(s);
//            }
//        });


        response.setCharacterEncoding("UTF-8");
        //设置数据格式为json格式
        response.setContentType("application/json");
        //拿到输出流
        PrintWriter out = response.getWriter();
        //未登录或失效
        RespBean bean = RespBean.error("未登录或用户信息过期，请重新登录捏！");
        bean.setCode(401);
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
