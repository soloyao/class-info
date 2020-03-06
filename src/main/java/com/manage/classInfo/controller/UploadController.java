package com.manage.classInfo.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName:UploadController
 * @Description:文件上传管理
 * @date:2020年3月6日 上午10:45:51
 */
@RestController
public class UploadController {
	/**
	 * 文件上传
	 * @param request
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		String fileName = null;
		try {
			fileName = System.currentTimeMillis() + file.getOriginalFilename();
			String path = "D:/springbootUpload";//保存至D:/springbootUpload文件夹
			File destFile = new File(path + "/" + fileName);
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdir();
			}
			file.transferTo(destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
