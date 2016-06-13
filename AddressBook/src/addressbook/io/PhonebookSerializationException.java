package addressbook.io;

public class PhonebookSerializationException extends Exception {

	private static final long serialVersionUID = 8555383150453712722L;

	public PhonebookSerializationException(String message, Exception cause) {
		super(message, cause);
	}

	public PhonebookSerializationException(Exception cause) {
		super(cause);
	}

}
