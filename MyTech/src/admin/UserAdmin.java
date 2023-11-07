/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

/**
 *
 * @author USER
 */
public class UserAdmin {
    private int id;
    private String name;
    private String username;
    
    public UserAdmin (int id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }
    
    public int getId() 
    {
        return id;
    }
    public String getName()
    {
        return name;
    }    
    public String getUsername()
    {
        return username;
    }
}
