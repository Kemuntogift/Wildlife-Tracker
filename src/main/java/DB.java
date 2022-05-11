import org.sql2o.*;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "postgres", "KEMUNTO543210");
// heroku database credentials
//    String connectionString = "jdbc:postgresql://ec2-3-224-164-189.compute-1.amazonaws.com:5432/db43k9ldso3p7f"; //!
//    Sql2o sql2o = new Sql2o(connectionString, "adnqphfufcerat", "5a299a34fea7f2b331b0c17e797bd96312fa95e91a21ccee1f4ae443aaa4be7c"); //!
}
