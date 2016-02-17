package com.ssg.global.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Map<String, String[]> additionalParams = new HashMap<String, String[]>();
		additionalParams.put("id", new String[] {"filterID"});
		additionalParams.put("filterValue", new String[] {"filterValue"});
		additionalParams.put("filterValueArray", new String[] {"filterValue", "filterValueArray"});
		HtmlRequestWrapper requestWrapper = new HtmlRequestWrapper((HttpServletRequest) request, additionalParams);
		
		HtmlResponseWrapper responseWrapper = new HtmlResponseWrapper((HttpServletResponse) response);
		
		chain.doFilter(requestWrapper, responseWrapper);
		
		if (response.getContentType() != null
                && response.getContentType().contains("text/html")) {

            String content = responseWrapper.getCaptureAsString();

            // replace stuff here
            String replacedContent = content.replaceAll(
                    "<h2[^>]*>(.*?)</h2>",
                    "<h3>$1 - HTML replaced</h3>");

            response.getWriter().write(replacedContent);
        }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
