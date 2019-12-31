package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class ThumbnailInsertServlet
 */
@WebServlet("/insert.th")
public class ThumbnailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// String title = request.getParameter("title");
		// 폼 전송을 multipart/form-data로 전송하는 경우 기존처럼 parameter를 통해
		// 값을 얻어올 수 없다.
		
		// cos.jar 라이브러리(com.orelilly.servlet의 약자)
		// cos.jar가 파일도 받고 폼 태그 내의 다른 값들도 받아주는 역할을 한다.
		// http://www.servlets.com
		
		// 1. enctype이 multipart/form-data로 전송 되었는지 확인한다.
		if(ServletFileUpload.isMultipartContent(request)) {
			// 2_1. 전송파일 용량 제한 : 10Mbyte로 제한하는 경우
			// 1Kbyte = 1024byte
			// 1Mbyte = 1024kbyte
			// 10Mbyte = 1024*1024*10 
			int maxSize = 1024*1024*10;
			
			// 2_2. 웹 서버 컨테이너 경로(WebContent)/resources 추출
			// 해당 컨테이너의 구동중인 웹 애플리케이션의 루트 경로를 알아냄
			String root = request.getSession().getServletContext().getRealPath("/");
			
			// System.out.println("root : " + root);
			
			// 2_3. 파일이 실제로 저장 될 경로
			String savePath = root + "/resources/thumbnail_uploadFiles/";
			
			/* 3. 파일명 변환 및 저장 작업
			 * 
			 * HttpServletRequest --> MultipartRequest
			 * MultipartRequest multipartRequest = new MultipartRequest
			 * (request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			 * 
			 * 일반적으로 사용자가 올린 파일명을 그대로 저장하지 않는다.
			 * - 같은 파일명이 있는 경우 이전 파일을 덮어쓸 수 있다.
			 * - 한글로 된 파일명, 특수 기호나 띄어쓰기 등은 서버에 따라 문제가 생길 수 있다.
			 * 
			 * DefaultFileRenamePolicy는 cos.jar안에 존재하는 클래스로
			 * multipartRequest 객체 생성 시 해당 클래스의 rename() 메소드가 실행 되면서
			 * 파일명의 수정 작업이 이루어짐
			 * ex: aaa.png, aaa1.png, aaa2.png
			 * 
			 * 우리는 DefaultFileRenamePolicy를 사용하지 않고 직접 우리 방식대로
			 * rename() 작업을 위한 클래스를 만들 것이다.
			 * common 패키지 안에 MyFileRenamePolicy를 만들자~~
			 * */
			
			MultipartRequest multipartRequest 
				= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			// --> 이 순간에 MyFileRenamePolicy의 rename() 메소드가 실행되며
			// rename된 파일이 폴더에 저장 된다.
			
			// 4. DB에 저장하기 위해 change_name과 origin_name 각각의 리스트를
			// 만들어주는 작업을 한다.
			
			// 다중 파일을 묶어서 업로드 하기 때문에 컬렉션을 사용
			// 실제로 저장된 파일의 이름을 저장할 ArrayList 생성
			ArrayList<String> changeFiles = new ArrayList<>();
			// 원본 파일의 이름을 저장할 ArrayList 생성
			ArrayList<String> originFiles = new ArrayList<>();
			
			// getFileNames() -> form에서 전송 된 파일 리스트들의 name 값을 반환
			Enumeration<String> files = multipartRequest.getFileNames();
			// -> 전송 순서 역순으로 쌓여 있음
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				//System.out.println("name : " + name);
				
				// 파일이 null이 아닌 경우
				if(multipartRequest.getFilesystemName(name) != null) {
					// getFilessystemName() --> 리네임 된 파일명 리턴
					String changeName = multipartRequest.getFilesystemName(name);
					// getOriginFileName() --> 사용자가 업로드한 파일명 리턴
					String originName = multipartRequest.getOriginalFileName(name);
					
					changeFiles.add(changeName);
					originFiles.add(originName);
				}
			}
			
			// 5. 파일 외에 게시판 제목, 내용, 작성자 회원 번호를 받아와서 Board 객체 생성하기
			String title = multipartRequest.getParameter("title");
			String content = multipartRequest.getParameter("content");
			String bWriter = String.valueOf(((Member)request.getSession().getAttribute("loginUser")).getUserNo());
			
			Board b = new Board();
			b.setbTitle(title);
			b.setbContent(content);
			b.setbWriter(bWriter);
			
			// 6. Attachment 테이블에 삽입할 값 작업하기
			ArrayList<Attachment> fileList = new ArrayList<>();
			// 전송 순서 역순으로 파일이 저장되어 있으므로 반복문을 역으로 수행하기
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(changeFiles.get(i));
				
				// 메인 이미지인 경우 fileLevel 0, 일반 사진은 fileLevel 1
				if(i == originFiles.size() -1) {
					at.setFileLevel(0);
				}else {
					at.setFileLevel(1);
				}
				fileList.add(at);
			}
			
			
			// 7. 사진 게시판 작성용 비즈니스 로직을 처리할 서비스 요청
			int result = new BoardService().insertThumbnail(b, fileList);
			
			if(result > 0) {
				response.sendRedirect("list.th");
			}else {
				// 실패 시 저장된 사진 삭제
				for(int i = 0; i < changeFiles.size(); i++) {
					// 파일 시스템에 저장 된 이름으로 파일 객체 생성함
					File failedFile = new File(savePath + changeFiles.get(i));
					failedFile.delete();
				}
				
				request.setAttribute("msg", "사진 게시판 등록 실패!!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
