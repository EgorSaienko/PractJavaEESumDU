/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package bookshelf;

import bookshelf.bookstore.Book;
/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args){
       BookShelf my_bsf = BookShelf.getInstance();
       for(int i=0;i<5;i++){
           Book b=Genertor.createBook();
           my_bsf.addBook(b);
       }
       my_bsf.printContent();
    }
}
