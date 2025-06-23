package tn.smartech.smartechhr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.smartech.smartechhr.services.EmployeeService;

@SpringBootApplication
public class SmartechHrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartechHrApplication.class, args);
    }

    public EmployeeService employeeService;



}
