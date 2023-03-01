package kodloma.io.rentACar;

import kodloma.io.rentACar.core.utilities.exceptions.BusinessException;
import kodloma.io.rentACar.core.utilities.exceptions.ProblemDetails;
import kodloma.io.rentACar.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@ComponentScan(basePackages = {"kodloma.io.rentACar"})
@RestControllerAdvice
@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails= new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemDetails validationProblemException=new ValidationProblemDetails() ;
		validationProblemException.setMessage("VALIDATION.EXCEPTION");
		validationProblemException.setValidationErrors(new HashMap<String,String>());
		for (FieldError fieldError :methodArgumentNotValidException.getBindingResult().getFieldErrors()
				) {
 validationProblemException.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return validationProblemException;
	}
	@Bean

	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
