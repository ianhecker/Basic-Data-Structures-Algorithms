/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttesting;

/**
 *
 * @author Ian
 */
public class Student {
    
    private int id;
    private String name;

    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }      
    
    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }        
}
