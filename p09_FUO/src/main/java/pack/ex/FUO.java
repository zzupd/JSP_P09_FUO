package pack.ex;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FUO {
	
	public boolean mtdUpload(HttpServletRequest req) {
		
		boolean chk = false;
		String saveFolder = "D:\\Java_Web_AI\\silsp\\jsp\\p09_FUO\\src\\main\\webapp\\fileStorage";


		int maxSize = 5*1024*1024;   // 5MByte 까지 최대 업로드 허용
		String encType = "UTF-8";

		String subject = "";
		String content = "";

		String originalFile = "";  // 원본 파일명
		String uploadFile = "";    // 업로드된 파일명

		int fileSize = 0;         // 파일 크기(=용량)

		try {
			MultipartRequest multiReq = new MultipartRequest(
						req,
						saveFolder,
						maxSize,
						encType,
						new DefaultFileRenamePolicy()
					);

			subject = multiReq.getParameter("subject");
			content = multiReq.getParameter("content");
			
			originalFile = multiReq.getOriginalFileName("fileName");
			// 원본 파일명
			uploadFile = multiReq.getFilesystemName("fileName");
			// 업로드 후 저장된 파일명
			
			// 파일 크기 산출
			File file = multiReq.getFile("fileName");
			fileSize = (int)file.length();

			System.out.println("subject : " + subject);
			System.out.println("content : " + content);
			System.out.println("originalFile : " + originalFile);
			System.out.println("uploadFile : " + uploadFile);
			System.out.println("fileSize : " + fileSize);
			
			chk = true;
		} catch (IOException e ) {
			System.out.print(e.getMessage());
		}
		
		return chk; 
	}

}
