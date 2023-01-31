package advancedSchoolSystem;

public class Fainalize {
	protected void finalize() throws Throwable {
        try {
            System.out.println("Inside finalize method of Hello Class.");

        }
        catch (Throwable e) {
            throw e;
        }
        finally {
            System.out.println("Calling finalize method of the Object class");

            super.finalize();
        }
    }
}
