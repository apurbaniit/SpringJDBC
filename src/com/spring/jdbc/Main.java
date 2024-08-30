package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
        //int status=dao.saveEmployee(new Employee(101,"Amit",35000));
       // System.out.println(status+ " Record Inserted!!");

//        List<Employee> allEmployee = dao.getAllEmployees();
//
//        for(Employee emp:allEmployee)
//        {
//            System.out.println(emp);
//        }

        Scanner s=new Scanner(System.in);
        System.out.println("Please end employee ID");
        int emp_id=s.nextInt();
        System.out.println("Please end employee Name");
        String emp_Name=s.next();
        System.out.println("Please end employee Salary");
        float emp_sal=s.nextFloat();
        dao.saveEmployeeByPreparedStatement(new Employee(emp_id,emp_Name,emp_sal));


    }
}