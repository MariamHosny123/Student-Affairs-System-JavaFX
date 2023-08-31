package UpdateCourse;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import student.management.system.StudentManagementSystem;

public class UpdateCourse implements Initializable {

    @FXML
    private TextField course1;

    @FXML
    private TextField course2;

    @FXML
    private TextField course3;

    @FXML
    private TextField course4;

    @FXML
    private TextField gpa;

    @FXML
    private TextField credithour;

    @FXML
    private Button back;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    private Button Search;

    @FXML
    private TextField search;

    @FXML
    private TextField course5;

    @FXML
    private TextField course6;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void Search(ActionEvent event) {

        String ids = search.getText();

        if (ids.equals("")) {
            JOptionPane.showMessageDialog(null, "Id is Blank");

        } else {
            try {

                long id = Long.parseLong(ids);

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

                String sql_query = "select * from students where id=?";
                PreparedStatement stmt = con.prepareStatement(sql_query);
                stmt.setLong(1, id);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    course1.setText(rs.getString("course1"));
                    course2.setText(rs.getString("course2"));
                    course3.setText(rs.getString("course3"));
                    course4.setText(rs.getString("course4"));
                    course5.setText(rs.getString("course5"));
                    course6.setText(rs.getString("course6"));
                    gpa.setText(rs.getString("gpa"));
                    credithour.setText(rs.getString("CreditHours"));

                } else {

                    JOptionPane.showMessageDialog(null, "NOT FOUND");

                }

                con.close();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UpdateCourse.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    void Update(ActionEvent event) {

        String ids = search.getText();

        long id1 = Long.parseLong(ids);

        String course11 = course1.getText();
        String course21 = course2.getText();
        String course31 = course3.getText();
        String course41 = course4.getText();
        String course51 = course5.getText();
        String course61 = course6.getText();
        String gpa1 = gpa.getText();
        String credithour1 = credithour.getText();

        if (course11 == "" || course21 == "" || course31 == "" || course41 == "" || course51 == "" || course61 == "" || gpa1 == "" || credithour1 == "") {

            JOptionPane.showMessageDialog(null, "NOT UPDATED");

        } else {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

                String sql_query = "update students set course1 = ? , course2=? , course3=? , course4=? , course5=? , course6=? , gpa=? , CreditHours=? where id=?";

                //  String sql_query = "insert into students (name,email,address,number,nationality) values (? ,?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql_query);

                stmt.setString(1, course11);
                stmt.setString(2, course21);
                stmt.setString(3, course31);
                stmt.setString(4, course41);
                stmt.setString(5, course51);
                stmt.setString(6, course61);
                stmt.setString(7, gpa1);
                stmt.setString(8, credithour1);
                stmt.setLong(9, id1);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "UPDATED");

                con.close();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UpdateCourse.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    void Delete(ActionEvent event) {

        String ids = search.getText();

        long id1 = Long.parseLong(ids);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

            String sql_query = "delete from students where id=?";

            //  String sql_query = "insert into students (name,email,address,number,nationality) values (? ,?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql_query);

            stmt.setLong(1, id1);

            stmt.executeUpdate();

            course1.setText("");
            course2.setText("");
            course3.setText("");
            course4.setText("");
            course5.setText("");
            course6.setText("");
            gpa.setText("");
            credithour.setText("");
            search.setText("");

            JOptionPane.showMessageDialog(null, "Deleted");

            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateCourse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent pr = FXMLLoader.load(StudentManagementSystem.class.getResource("Home.fxml"));
        Scene scene = new Scene(pr);
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(scene);

    }

    @FXML
    void SearchField(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
