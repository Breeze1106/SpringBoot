package com.djs.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	
	/**
	 * 初始化上传文件界面，跳转到index.jsp
	 * @return
	 */
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file,HttpServletRequest request) {
		try {
			//上传目录地址
			String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
			//如果目录不存在，自动创建文件夹
			File dir = new File(uploadDir);
			if(!dir.exists()) {
				dir.mkdir();
			}
			executeUpload(uploadDir, file);
		} catch (Exception e) {
			//打印错误堆栈信息
			e.printStackTrace();
			return "上传失败";
		}
		return "上传成功";
	}
	
	private void executeUpload(String uploadDir,MultipartFile file) throws Exception {
		//文件后缀名
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		
		//上传文件名
		//一般都是微毫秒作为文件名：System.nanoTime()
		String filename = System.nanoTime()+suffix;
		//采用了随机UUID的形式命名
		//String filename = UUID.randomUUID()+suffix;
		
		//服务器端保存的文件对象
		File serverFile = new File(uploadDir+filename);
		//将上传的文件写入到服务器端文件内
		file.transferTo(serverFile);
	}
	
	@RequestMapping(value = "/uploads",method = RequestMethod.POST)
	public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] file) {
		try {
			//上传目录地址
			String  uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
			//如果目录不存在，自动创建文件夹
			File dir = new File(uploadDir);
			if(!dir.exists()) {
				dir.mkdir();
			}
			//遍历文件数组
			for (int i = 0; i < file.length; i++) {
				if(file[i] != null) {
					//调用上传方法
					executeUpload(uploadDir, file[i]);
				}
			}
		} catch (Exception e) {
			//打印错误堆栈信息
			e.printStackTrace();
			return "上传失败";
		}
		return "上传成功";
	}
}
