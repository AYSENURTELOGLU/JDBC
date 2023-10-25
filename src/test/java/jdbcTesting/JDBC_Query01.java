package jdbcTesting;

import java.sql.*;

public class JDBC_Query01 {

    // Sizden bir JDBC sorgusu yapmaniz istendiginde ilk yapmaniz gereken is:

    //  Database yoneticinden ilgili database bilgilerini ( database access informaation) almak olmalidir.

    /*
            URL: "jdbc:mysql://45.87.83.5/u168183796_qawonder";
            USERNAME= "u168183796_qawonderuser";
            PASSWORD="1gvyfx6#Q";
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. Adim olarak: Kullanılacak veritabanı için doğru sürücüyü ekle

        Class.forName("com.mysql.jdbc.Driver");  //hangi database ile çalışıyorsak onu belirleme.


        //2. Adim olarak : Veritabani ile iletişimi başlat

        Connection connection =  DriverManager.getConnection(  "jdbc:mysql://45.87.83.5/u168183796_qawonder",
                "u168183796_qawonderuser",
                "1gvyfx6#Q");
        //url usename password ile database baglantısı saglanıyor.


        //3. Adim olarak : sql ifadelerini olustur ve calistir (select, ınsert,ıpdate,delete)


        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  //elimizdeki resultset ayarları

        //bir statement olusturabilmek için mutlaka bir connection ninizin olması gereklidir.
        //statement oluşturmak bizim sorgumuz için yeterli olabilir
        //ancak statementi kullanmak istediğimizde cagirabilmek için onu kaydetmeliyiz.


        //4. Adim olarak : Sql ssorgularını calıstır ve gelen sonuclar işle kaydet vb.

        String query= "SELECT name FROM u168183796_qawonder.staff";

        ResultSet resultSet = statement.executeQuery(query); //sql sorgusunu calıstırıp sonucu result set olarak kaydettik

        resultSet.next(); //iterator mantıgı, imleci bir ileri atar.
       //  1 2 3 4 5 6 7 8 9 10 >>> resultSet.next ile imlec 1in yanına gelir

        System.out.println(resultSet.getString("name")); //Joe

        resultSet.next();

        System.out.println(resultSet.getString("name"));

        //Shıvam

        resultSet.next();

        System.out.println(resultSet.getString("name"));

        resultSet.first();
        System.out.println(resultSet.getString("name"));


        resultSet.absolute(10);
        System.out.println(resultSet.getString("name"));



    }




}
