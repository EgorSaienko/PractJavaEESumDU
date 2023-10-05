
import com.mycompany.empioyeepract.Empioyee;
import com.mycompany.empioyeepract.FieldLengthLimitException;
import com.mycompany.empioyeepract.IncorrectSalaryException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class EmpioyeeTest {
    @Test
    public void createEmpioyeeTestString() {
        String name="Bilbo";
        Empioyee testEmp=null;
        try {
            testEmp=new Empioyee(name);
        } catch (FieldLengthLimitException ex) {  
        }
        assertEquals(name, testEmp.getName());
    }
    @Test
    public void exceptionTestingString() {
        String name="Bilboooooooooooooooooo";
        FieldLengthLimitException thrown = assertThrows(
        FieldLengthLimitException.class,
        () -> new Empioyee(name)
        );
        //System.out.print(thrown.getMessage());
        assertTrue(thrown.getMessage().contains("Too much sumbols is name!"));
    }
    
    @Test
    public void createEmpioyeeTestSalary() {
        double salary=3400;
        Empioyee testEmp=null;
        try {
            testEmp=new Empioyee(salary);
        } catch (IncorrectSalaryException ex) {  
        }
        assertEquals(salary, testEmp.getSalary());
    }
    @Test
    public void exceptionTestingSalary() {
        double salary=-3400;
        IncorrectSalaryException thrown = assertThrows(
        IncorrectSalaryException.class,
        () -> new Empioyee(salary)
        );
        //System.out.print(thrown.getMessage());
        assertTrue(thrown.getMessage().contains("Salary cannot be negative!"));
    }
}
    

   