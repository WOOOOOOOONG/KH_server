package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import wrapper.EncryptWrapper;

/**
 * Servlet Filter implementation class EncryptFilter
 */
// 이 필터는 암호화가 필요한 서블릿에서만 적용이 되기 때문에 직접 서블릿명을 통해서 필터 적용을 해보자!
// 암호화가 필요한 서블릿은 InsertMemberServlet, LoginServlet, UpdatePwdServlet이다.

@WebFilter(filterName = "encrypt", servletNames = {"InsertMemberServlet", "LoginServlet", "UpdatePwdServlet"})
// 하지만 서블릿명으로 필터를 적용할때는 배포명이 반드시 있어야 한다!!!
// 따라서 해당 서블릿들로 가서 @WebServlet 어노테이션에 name 속성값을 명시해주자!
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 래퍼 : 필터에게 넘어온 request, response를 변경할 때 사용하는 개념
		// request나 response를 특정한 형태로 감싸서 변형 시키는 애
		
		// 전달 받아 온 request를 암호화 래퍼로 감싼 채로 생성
		EncryptWrapper encWrapper = new EncryptWrapper((HttpServletRequest)request);
		
		//chain.doFilter(request, response);
		chain.doFilter(encWrapper, response);
		
		// 이렇게 한다면 이제부터 InsertMemberServlet, LoginServlet .. 등의
		// request.getParameter(key)는 EncryptWrapper에서 오버라이딩 된
		// getParameter 메소드로 실행 된다.
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
