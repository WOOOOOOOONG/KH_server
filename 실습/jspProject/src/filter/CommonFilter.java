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

/**
 * Servlet Filter implementation class CommonFilter
 */
//@WebFilter("/CommonFilter")
// filterName을 통해서 어떤 역할을 하는 필터인지 지정해주고
// urlPatterns을 통해서 어떠한 서블릿을 가기전에 거칠 것인지를 지정해준다.
// @WebFilter(filterName="encoding", urlPatterns="/*")
// --> /*로 지정하게 되면 모든 서블릿을 뜻한다.
public class CommonFilter implements Filter {
	/* 서블릿 필터는 request, response가 서블릿이나 JSP등 리소스에 도달하기 전
	 * 필요한 전/후 처리 작업을 맡는다.
	 * 필터는 FilterChain을 통해 여러 개 혹은 연쇄적으로 사용 가능하다.
	 * 
	 * 필터 클래스를 등록하는 방법
	 * 1. WEB-INF/web.xml 파일에 필터를 등록해야지만 사용 가능하다.
	 * 2. 하지만 최근에는 web.xml에 등록하지 않고 @WebFilter라는 어노테이션으로 대체해서 사용하는
	 *    추세이다.
	 */
    /**
     * Default constructor. 
     */
    public CommonFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		/* 컨테이너가 필터 인스턴스롤 제거할 때 호출한다. */
		System.out.println("소멸 되었습니다.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* 컨테이너가 현재 요청에 필터 적용을 하겠다고 판단하면 호출한다.*/
		
		// 서블릿 수행 전 필터 동작하기
		System.out.println("-- do Filter() 동작합니다. --");
		
		// 전송 방식이 post일 때 반드시 request에 대해서 인코딩
		HttpServletRequest hrequest = (HttpServletRequest)request;
		if(hrequest.getMethod().equalsIgnoreCase("post")) {
			System.out.println("post 전송 시에만 encoding 됨");
			request.setCharacterEncoding("utf-8");
		}
		// FilterChian의 doFilter()는 다음 필터를 호출하거나, 마지막이면 servlet, jsp를 호출함
		chain.doFilter(request, response);
		
		// 서블릿 동작 후 코드 실행
		System.out.println("-- doFilter() 이후 처리되는 코드입니다. --");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		/* 컨테이너가 필터를 인스턴스화 할 때 호출한다.
		 * 필터 설정 관련 코드 작성 가능하다.*/
		System.out.println("CommonFilter 초기화");
		
	}

}
