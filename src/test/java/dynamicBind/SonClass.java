package dynamicBind;

public class SonClass extends ParentClass {
	
	public void sayHello() {
		System.out.println("this is SonClass");
	}
	
	public static void main(String[] args) {
		RootClass clz = new SonClass();
		clz.sayHello();
	}
}
