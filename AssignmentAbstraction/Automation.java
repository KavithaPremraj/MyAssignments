package Week3.AssignmentAbstraction;

public class Automation extends MultipleLanguage{

	public void Selenium() {
		System.out.println("Learning Selenium in TestLeaf");
		
	}

	public void Java() {
		System.out.println("Learning Java in TestLeaf");
		
	}

	@Override
	public void ruby() {
		System.out.println("Yet to Learn");
		
	}
	public static void main(String[] args) {
		Automation automate = new Automation();
		automate.Selenium();
		automate.Java();
		automate.python();
		automate.ruby();

	}

}
