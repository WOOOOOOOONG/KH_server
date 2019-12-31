package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		// 전달 받은 원본 파일명을 중복되는 값이 없게끔 변경해서 변경 된 파일명으로 반환
		// 변경명은 파일 업로드 한 시간(년월일시분초) + 1~5자리의 랜덤값을 부여해서 변경
		// ex. 2019112119135512345.jpg
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		int ranNum = (int)(Math.random()*100000); // 최대 다섯자리 랜덤수
		
		// 파일명을 변경해도 확장자를 유지하기 위하여 별도로 확장자명 가져오기
		String name = originFile.getName(); // 원본 파일명 ex. "aaa.png"
		
		String ext = "";
		int dot = name.lastIndexOf("."); // .의 위치 값 알아내기
		
		// 확장자(.)가 존재한다면
		if(dot != -1) {
			// dot 포함해서 확장자 추출
			ext = name.substring(dot); // ex ".png"
		}
		
		// 최종적으로 수정할 파일명
		String fileName = sdf.format(new Date()) + ranNum + ext;
		
		// 파일을 변경 된 파일명으로 생성해서
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
	}

}
