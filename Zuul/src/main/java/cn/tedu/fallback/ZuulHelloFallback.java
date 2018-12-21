package cn.tedu.fallback;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.propertyeditors.ByteArrayPropertyEditor;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
@Component
public class ZuulHelloFallback implements ZuulFallbackProvider{

	@Override	//返回路由，通用
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			@Override	//响应头信息，设置返回值类型Content，字符集U8
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}
			
			@Override	//响应体
			public InputStream getBody() throws IOException {
				//返回信息
				String msg = "888";		//出错后，断路器返回值
				return new ByteArrayInputStream(msg.getBytes());
			}
			
			@Override	//返回错误信息
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST.value();
			}
			
			@Override
			public void close() {
			}
		};
	}


}
