package th.co.api.salary.validation;

public interface Validator<T> {

	public void validate(T t) throws Exception;
}
