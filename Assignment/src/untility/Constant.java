/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untility;

/**
 *
 * @author sangh
 */
public class Constant {
    public static final String HOSTNAME = "localhost";

    public static final String USER = "sa";

    public static final String PASSWORD = "sang03";

    public static final String DB = "QLSV";

    public static final String CONNECTION_STRING = "jdbc:sqlserver://" + HOSTNAME + ":1433;databaseName=" + DB;

    public static final String POPUP_HEADER = "Thông báo";
    
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final String PHONENUMBER_PATTERN = "\\d{10}";
    public static final String NAME_PATTERN = ".*[a-zA-Z].*";
}
