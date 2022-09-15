package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(FundamentosApplication.class);

	private final ComponentDependency componentDependency;
  private final MyBean myBean;
	private final MyBeanWithDependency myBeanWithDependency;
	private final MyBeanWithProperties myBeanWithProperties;
	private final UserPojo userPojo;
	private final UserRepository userRepository;
	public FundamentosApplication(
					@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
					MyBean myBean,
					MyBeanWithDependency myBeanWithDependency,
					MyBeanWithProperties myBeanWithProperties,
					UserPojo userPojo,
					UserRepository userRepository)
	{
		this.componentDependency = componentDependency;
    this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//classExamples();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		logger.info("User: " +
						userRepository.findByUserEmail("daniela@domain.com")
						.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("user", Sort.by("id")
						.descending())
						.forEach(user -> logger.info("Usuario usando sort: " + user));
	}

	private void saveUsersInDataBase(){
		User user1 = new User("Johjan", "johjan@email.com", LocalDate.of(1998,8,22));
		User user2 = new User("Stiven", "stiven@email.com", LocalDate.of(1998,9,12));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("user1", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("user2", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("user3", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("user4", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("user5", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("user6", "paola@domain.com", LocalDate.of(2021, 4, 10));
		List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9);
		users.forEach(userRepository::save); //Utilizar método save para guardar los datos en la base de datos
	}

	private void classExamples(){ //Ejemplos vistos antes de la clase N°19 del curso
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		logger.info(myBeanWithProperties.function());
		logger.info(userPojo.getEmail() + " - " + userPojo.getAge() + " - " + userPojo.getPassword());
		logger.error("This is an error from the app");
	}
}
