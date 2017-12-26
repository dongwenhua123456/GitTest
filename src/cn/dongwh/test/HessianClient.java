package cn.dongwh.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

import cn.dongwh.model.User;
import cn.dongwh.service.IFileUploadService;
import cn.dongwh.service.IService;

public class HessianClient {
	public static void main(String[] args) throws MalformedURLException, FileNotFoundException {
		/*String url = "http://localhost:8006/HessianServer/ServiceServlet";
		HessianProxyFactory proxyFactory = new HessianProxyFactory();
		IService service = (IService)proxyFactory.create(IService.class, url);
		User user = service.getUser();
		System.out.println(user.getName());*/
		
		String url = "http://localhost:8006/HessianServer/FileUploadService";
		HessianProxyFactory proxyFactory = new HessianProxyFactory();
		IFileUploadService uploader = (IFileUploadService)proxyFactory.create(IFileUploadService.class, url);
		InputStream in = new BufferedInputStream(new FileInputStream("D:\\111.txt"));
		uploader.upload("111.txt", in);
		System.out.println("test");
		System.out.println("test2");
		System.out.println("test3");
	}

}
