package br.com.jgle.acti.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class UrlUtil {

	public static String readContent(String urlStr) throws IOException
	{		
		URL url = null;
		URLConnection connection = null;
		BufferedReader reader = null;
		
		try {

			url = new URL(urlStr);
			connection = buildConnection(url);			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			return reader.readLine();

		} finally {
			try {
				reader.close();
			} catch (Exception e) {}
		}
	}	
	
	public static InputStream obteimInputStreamContent(URL url) throws IOException
	{		
		URLConnection connection = buildConnection(url);		
		return connection.getInputStream();
	}
	
	private static URLConnection buildConnection(URL url) throws IOException
	{
		boolean proxyAtivo = Boolean.valueOf(FileUtil.getPropertyValue("proxy.ativo"));
		
		if(!proxyAtivo)		
			return url.openConnection();		
		
		String proxyUrl = FileUtil.getPropertyValue("proxy.url");
		Integer proxyPorta = new Integer(FileUtil.getPropertyValue("proxy.porta"));
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyUrl, proxyPorta));
		return url.openConnection(proxy);
	}
}
