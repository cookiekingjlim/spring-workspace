package com.kh.mvc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Map에는 보통 path를 던져
		String path = (String) model.get("path");
		String fileName = request.getParameter("filename");
		
		// 업로드 경로가 저장된 파일 객체
		File file = new File(path + fileName);
		
		// 파일 다운로드
		response.setContentType(this.getContentType());
		response.setContentLength((int)file.length());
		
		// 다운로드 파일에 대한 설정
		response.setHeader("Content-Disposition", "attachment; fileName=" + new String(file.getName().getBytes("UTF-8"),"8859_1"));
	
		// 데이터 인코딩이 바이너리 파일임을 명시
		response.setHeader("Content-Transfer-encoding", "binary");
		
		
		// 실제 업로드 파일을 inputStream 으로 읽어서 
		// response에 연결된 outputStream으로 전송하겠다.
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
	}

}
