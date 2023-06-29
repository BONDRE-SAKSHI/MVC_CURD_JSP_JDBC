package in.cdac.info.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.cdac.info.bean.Student;
import in.cdac.info.dao.StudentDao;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDao dao = new StudentDao();

	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		PrintWriter out = response.getWriter();

		System.out.println(path);

		switch (path) {

		case "/new":
			showAddStudentFrom(request, response);
			break;
		case "/edit":
			showEditFrom(request, response);
			break;
		case "/update":
			updateStudent(request, response);
			break;
		case "/insert":
			addStudent(request, response);
			break;
		case "/delete":
			deleteStudent(request, response);
			break;
		default:
			showStudentList(request, response);
			out.println("[Add new user]  All Users List");
			break;
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteStudent(id);
		response.sendRedirect("list");

	}

	private void showStudentList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> students = dao.getAllStudents();
		System.out.println(students);
		request.setAttribute("studentList", students);
	
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int standard = Integer.parseInt(request.getParameter("standard"));
		String subject = request.getParameter("subject");
		Student student = new Student(name, standard, subject);

		dao.addStudent(student);
		response.sendRedirect("list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String name = request.getParameter("name");
		int standard = Integer.parseInt(request.getParameter("standard"));
		String subject = request.getParameter("subject");
         System.out.println(name);
		dao.updateStudent( new Student(id, name , standard, subject));
		response.sendRedirect("list");

	}

	private void showEditFrom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = dao.getStudent(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("student", student);
		request.setAttribute("id", student.getId());
		RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
		rd.forward(request, response);

	}

	private void showAddStudentFrom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
		rd.forward(request, response);

	}

}
