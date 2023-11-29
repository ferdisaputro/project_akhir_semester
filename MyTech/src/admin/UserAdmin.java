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
    private static int id;
    private static String name;
    private static String username;
    
    public static void setId(int id) {
        UserAdmin.id = id;
    }
    public static void setName(String name) {
        UserAdmin.name = name;
    }
    public static void setUsername(String username) {
        UserAdmin.username = username;
    }
    public static int getId() 
    {
        return id;
    }
    public static String getName()
    {
        return name;
    }    
    public static String getUsername()
    {
        return username;
    }
}
