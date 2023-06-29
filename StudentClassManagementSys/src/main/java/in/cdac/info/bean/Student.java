package in.cdac.info.bean;

public class Student {
	private int id;
	private String name;
	private int standard;
	private String subject;
	public Student(int id, String name, int standard, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.subject = subject;
	}
	
	public Student(String name, int standard, String subject) {
		super();
		this.name = name;
		this.standard = standard;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", standard=" + standard + ", subject=" + subject + "]";
	}

    
}
