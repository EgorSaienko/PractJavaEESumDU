/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.empioyeepract;

/**
 *
 * @author Admin
 */
public class EmpioyeePract {

    public static void main(String[] args) {
         try{
            Empioyee emp=new Empioyee("Bilbo Baggins");
            emp.nameYourself();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }
         try{
            Empioyee emp=new Empioyee(3400);
            emp.youSalary();
        }catch(IncorrectSalaryException ex){
            System.out.println(ex.getMessage());
        }
    }
}
