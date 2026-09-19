package application;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

    DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
    

    System.out.println("=== TEST 1 : Department Find By ID");

    Department department = departmentDao.findById(3);
    System.out.println(department);

    System.out.println("=== TEST 2 : Department findAll ===");
    List <Department> list = departmentDao.findAll();
    for (Department d : list){
        System.out.println(d);
    }
    
    System.out.println("=== TEST 4 : Department INSERT");
    Department newDepartment = new Department(null, "Music");
    departmentDao.insert(newDepartment);
    System.out.println("Inserted! New Id = " + newDepartment.getId());

    System.out.println("=== TEST 5 : Department UPDATE");
    department = departmentDao.findById(1);
    department.setName("");
    departmentDao.update(department);
    System.out.println("Update Completed!");

    System.out.println("=== TEST 6 : Department DELETE");
    int id = sc.nextInt();
    departmentDao.deleteById(id);
    System.out.println( "Delete Completed");

    sc.close();


   

    


    }
}
