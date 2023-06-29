package in.cdac.info.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.cdac.info.bean.Student;

public class StudentDao {
      
	
  public StudentDao() {
	  
  }
  
  private final String jDBC_DRIVER ="com.mysql.cj.jdbc.Driver"; 
  private final String DB_URL ="jdbc:mysql://localhost/saksha"; 
  private final String DB_USERNAME="root"; 
  private final String DB_PWD ="cdac"; 
  
  
  private static final String SELECT_ALL=" select * from student;";
  private static final String INSERT_STUDENT="INSERT INTO student(name, standard ,subject)VALUES(?,?,?);";
  private static final String UPDATE_STUDENT=" update student set name=?,standard=?,subject =? where id=?;";
  private static final String DELETE_STUDENT=" delete from student where id =?";
  private static final String SELECT_STUDENT_BY_ID="select * from student where id=?";
  
  
  protected Connection getConnection() {
	  Connection connection=null;
	  
	  try {
		getClass();
		Class.forName(jDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PWD);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	  
  }
  //addstudent
  public boolean  addStudent(Student student) {
	  boolean isAdded=false;
	  try (Connection connection =getConnection()){
		  
		  PreparedStatement st= connection.prepareStatement(INSERT_STUDENT);
		  st.setString(1, student.getName());
		  st.setInt(2, student.getStandard());
		  st.setString(3, student.getSubject());
		  System.out.println(st);
		  isAdded = st.executeUpdate()>0;
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return isAdded;
  }
  
  //select by id
  
  public Student getStudent(int id) {
	Student student = null;
	try (Connection connection = getConnection()) {
		PreparedStatement st = connection.prepareStatement(SELECT_STUDENT_BY_ID);

		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			String name = rs.getString("name");
			int standard = rs.getInt("standard");
			String subject = rs.getString("subject");
             student =new Student(id, name, standard, subject);
			return student;
		}

	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	return student;

}
  
  //select all
  
  public List<Student> getAllStudents(){
	  List<Student> students =new ArrayList<Student>();
	   try (Connection connection =getConnection()){
		   PreparedStatement st= connection.prepareStatement(SELECT_ALL);
		   System.out.println(st);
		   ResultSet rs= st.executeQuery();
		   while(rs.next()) {
			   
			   int id =rs.getInt("id");
			   String name =rs.getString("name");
			   int standard = rs.getInt("standard");
			   String subject = rs.getString("subject");
			   
			   Student student = new Student(id, name, standard, subject);
			   students.add(student);
			   
		   }
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	return students;
	  
  }
  //update 
  
  public boolean updateStudent(Student student) {
	  boolean isUpdate =false;
	  try (Connection connection =getConnection()){
		  PreparedStatement st= connection.prepareStatement(UPDATE_STUDENT);
		  
		  st.setString(1, student.getName());
		  st.setInt(2, student.getStandard());
		  st.setString(3, student.getSubject());
		  st.setInt(4, student.getId());
		  
		  isUpdate = st.executeUpdate()>0;
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return isUpdate;
	  
  }
  
  //delete
  
  public boolean deleteStudent(int id) {
	  boolean isDelete =false;
	  try (Connection connection =getConnection()){
		  PreparedStatement st= connection.prepareStatement(DELETE_STUDENT);
		  
		  st.setInt(1, id);
		  isDelete =st.executeUpdate()>0;
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return isDelete;
	  
  }
  
}



