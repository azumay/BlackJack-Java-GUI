package E07.error;

public class ReportErrores extends Exception{
	
	String code;
	
	public ReportErrores() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportErrores(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ReportErrores(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ReportErrores(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ReportErrores(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ReportErrores(String message, String pCode) {
		super(message);
		this.code=pCode;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return code+": "+this.getMessage();
	}
	
	

}
