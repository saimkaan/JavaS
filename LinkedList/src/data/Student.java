package data;

public class Student {

	private String name;
	private int mtrkl;
	private String fach;

	public Student(String name, int mtrkl, String fach) {
		this.name = name;
		this.mtrkl = mtrkl;
		this.fach = fach;
	}

	public int getMtrkl() {
		return mtrkl;
	}

	public String getName() {
		return name;
	}

	public String getFach() {
		return fach;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", mtrkl=" + mtrkl + ", fach=" + fach
				+ "]";
	}

}
