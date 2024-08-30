package com.spring.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public int saveEmployee(Employee e){
//        String query="insert into employee values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
//        return jdbcTemplate.update(query);
//    }
//    public int updateEmployee(Employee e){
//        String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";
//        return jdbcTemplate.update(query);
//    }
//    public int deleteEmployee(Employee e){
//        String query="delete from employee where id='"+e.getId()+"' ";
//        return jdbcTemplate.update(query);
//    }

//    public List<Employee> getAllEmployees() {
//      return jdbcTemplate.query("select * from employee", new ResultSetExtractor<List<Employee>>() {
//
//            @Override
//            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//
//                List<Employee> empList = new ArrayList<Employee>();
//                while (resultSet.next()) {
//                    Employee emp = new Employee();
//                    emp.setId(resultSet.getInt(1));
//                    emp.setName(resultSet.getString(2));
//                    emp.setSalary(resultSet.getInt(3));
//
//                    empList.add(emp);
//
//                }
//                return empList;
//            }
//        });



    public Boolean saveEmployeeByPreparedStatement(final Employee e){
        String query="insert into employee values(?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,e.getId());
                ps.setString(2,e.getName());
                ps.setFloat(3,e.getSalary());

                return ps.execute();

            }
        });



    }

}


