<%@ page import="java.io.*, java.util.Arrays, java.net.*"
contentType="application/pdf"
trimDirectiveWhitespaces="true"
%>
<%
	String pdf=request.getParameter("id");
	try {
		File path = new File ("D:/hdsoft-git/hdsoft-git/hdsoft/src/java/activosPDFD/"+pdf);
		InputStream input = new FileInputStream(path);
		
		byte[] data = new byte[0];
		for (int i = input.read(); i != -1; i = input.read()) {
			data = Arrays.copyOf(data, data.length + 1);
			data[data.length - 1] = (byte) i;
		}
		input.close();
		response.setContentLength(data.length);
                response.setHeader("Content-Disposition", "attachment; filename='"+pdf+"'");
		response.getOutputStream().write(data);
		//response.getOutputStream().flush();
	} catch (Exception e) {}
%>