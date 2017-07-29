package servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class uploadingFile
 */
@WebServlet("/uploadFile")
@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 2,
			maxFileSize = 1024 * 1024 * 10,
			maxRequestSize = 1024 * 1024 * 50
		)
public class uploadingFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "UploadFilesDir";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadingFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Forwarding to jsp page
		request.getRequestDispatcher("/WEB-INF/fileUpload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name"), email = request.getParameter("email");
		User user = new User();
		
		if(name.isEmpty() || email.isEmpty())
		{
			response.sendRedirect("/servletTest/uploadFile");
		}
		else
		{
			user.setName(name); user.setEmail(email);
			request.getSession().setAttribute("userBean", user);
			
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + File.separator + SAVE_DIR;
			
			File fileSaveDir = new File(savePath);
			
			if(!fileSaveDir.exists())
				{
					fileSaveDir.mkdir();
				}
			
			for(Part part : request.getParts()) {
				String fileName = extractFileName(part);
				part.write(savePath + File.separator + fileName);
			}
			
			
			doGet(request, response);
		}
		
		
	}

	private String extractFileName(Part part)
	{
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}

}
