package E07.error;

public class ReportErrores extends Exception{

	public ReportErrores (String e) {
		super(e);
	}
	@Override
	public String toString() {
		return this.getMessage();
	}
}
