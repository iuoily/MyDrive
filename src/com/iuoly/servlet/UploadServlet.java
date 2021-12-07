package com.iuoly.servlet;

import com.iuoly.dao.FileDao;
import com.iuoly.entity.Files;
import com.iuoly.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * @author iuoly
 */
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
	
	String path = "E:/FileCenter/";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String username = (String) req.getSession().getAttribute("user");
		InputStream inputStream = null;
		FileOutputStream os =null;
		String fname = null;


		File file = new File(path + username);
		if (!file.exists()) {
			file.mkdir();
		}


		try {
		Collection<Part> parts = req.getParts();
		for (Part part : parts) {
			fname = part.getSubmittedFileName().replace("+"," ");
			System.out.println(fname);
/*			String fsize;
			long  fs = part.getSize()/1024;
			System.out.println(fs);
			if (fs > 9999) {
				fsize = fs/1024 + "MB";
			} else {
				fsize = fs + "KB";
			}

			System.out.println(fname + ":" + fsize);*/
			//把文件保存起来
			
			inputStream = part.getInputStream();
			os = new FileOutputStream(file.getAbsolutePath()+ "/" + fname);
			
			//2进制数组
			byte[] data = new byte[1024];
			int length = 0;
			while( (length=inputStream.read(data)) !=-1 ){
				os.write(data, 0, length);
			}
		}

			SqlSession session = MybatisUtils.getSession();
			FileDao fileDao = session.getMapper(FileDao.class);
			Files myfile = new Files(fname,file.length()+"",username);
			int flag = fileDao.save(myfile);
			if(flag == 1) {
				System.out.println("上传成功！");
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os!=null) {
				os.flush();
				os.close();
			}
			if (os!=null) {
				inputStream.close();
			}

			res.sendRedirect("FileList");
		}
	}
}
