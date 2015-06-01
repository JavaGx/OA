package cn.gx.oa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

public class FileUtils {
	public static String saveUploadFile(File upload) {
		String basePath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/uploadFiles");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("/yyyy/MM/dd/");
		String path=simpleDateFormat.format(new Date());
		path=basePath+path;
		File file=new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		path=path+UUID.randomUUID().toString();
		upload.renameTo(new File(path));
		return path;
	}
}
