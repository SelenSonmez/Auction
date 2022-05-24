package com.example.auction;
import java.sql.*;
import org.sqlite.*;
public class DatabaseConnection {
    static final SQLiteDataSource dataSource = new SQLiteDataSource();
    static Connection con;
    static Statement stmt;

    public static void createDB(){
        try{
            dataSource.setUrl("jdbc:sqlite:Auction.db");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void createDefaultTable(){
        String userQuery = "CREATE TABLE IF NOT EXISTS Users ( "+
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "USERNAME TEXT, "
                +"SURNAME TEXT, "
                +"PASSWORD TEXT, "
                +"CONTACTNO BIGINT, "
                +"ADDRESS TEXT, " +
                "USERTYPE TEXT" +
                ")";

        try{
            con = dataSource.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(userQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void addUser(User user){
        String userType = null;
        if(user instanceof Millers)
            userType = "Miller";
        if(user instanceof Farmer)
            userType = "Farmer";
        if(user instanceof FarmingAgency)
            userType = "Farming Agency";
        if( user instanceof AgricultureAgency)
            userType = "Agriculture Agency";

        String query = "INSERT INTO Users (USERNAME,SURNAME,PASSWORD,CONTACTNO,ADDRESS,USERTYPE) VALUES ("+"'"+user.getName() +"','"+user.getSurname()+ "','"+user.getPassword()
                +"',"+ user.getContactNo()+",'" + user.getAddress()+ "','"+userType+"')";

        try{
            con = dataSource.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
