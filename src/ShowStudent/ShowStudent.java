package ShowStudent;

import AddStudent.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import student.management.system.StudentManagementSystem;

public class ShowStudent implements Initializable {

    @FXML
    private Button back;

    @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, String> col_id;

    @FXML
    private TableColumn<ModelTable, String> col_name;

    @FXML
    private TableColumn<ModelTable, String> col_gpa;

    @FXML
    private TableColumn<ModelTable, String > col_credithours;

    @FXML
    private TableColumn<ModelTable, String> col_course1;

    @FXML
    private TableColumn<ModelTable, String> col_course2;

    @FXML
    private TableColumn<ModelTable, String> col_course3;

    @FXML
    private TableColumn<ModelTable, String> col_course4;

    @FXML
    private TableColumn<ModelTable, String> col_course5;

    @FXML
    private TableColumn<ModelTable, String> col_course6;

    @FXML
    private Button Level1;

    @FXML
    private Button Level2;

    @FXML
    private Button Level3;

    @FXML
    private Button Level4;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    Connection con;
    ResultSet rs;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Parent pr = FXMLLoader.load(StudentManagementSystem.class.getResource("Home.fxml"));
        Scene scene = new Scene(pr);
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

            rs = con.createStatement().executeQuery("select * from students ");

            while (rs.next()) {

                oblist.add(new ModelTable(rs.getString("id"), rs.getString("name"), rs.getString("gpa"), rs.getString("CreditHours"), rs.getString("course1"), rs.getString("course2"), rs.getString("course3"),
                        rs.getString("course4"), rs.getString("course5"), rs.getString("course6")));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));

        col_gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        col_credithours.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));

        col_course1.setCellValueFactory(new PropertyValueFactory<>("course1"));

        col_course2.setCellValueFactory(new PropertyValueFactory<>("course2"));

        col_course3.setCellValueFactory(new PropertyValueFactory<>("course3"));

        col_course4.setCellValueFactory(new PropertyValueFactory<>("course4"));

        col_course5.setCellValueFactory(new PropertyValueFactory<>("course5"));

        col_course6.setCellValueFactory(new PropertyValueFactory<>("course6"));

        table.setItems(oblist);

        //   FFE699
        //  F9C5D5
    }

    @FXML
    void BtnLevel1(ActionEvent event) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

            table.getItems().removeAll(oblist);

            rs = con.createStatement().executeQuery("select * from students WHERE CreditHours <= 36 ");

            while (rs.next()) {

                oblist.add(new ModelTable(rs.getString("id"), rs.getString("name"), rs.getString("gpa"), rs.getString("CreditHours"), rs.getString("course1"), rs.getString("course2"), rs.getString("course3"),
                        rs.getString("course4"), rs.getString("course5"), rs.getString("course6")));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));

        col_gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        col_credithours.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));

        col_course1.setCellValueFactory(new PropertyValueFactory<>("course1"));

        col_course2.setCellValueFactory(new PropertyValueFactory<>("course2"));

        col_course3.setCellValueFactory(new PropertyValueFactory<>("course3"));

        col_course4.setCellValueFactory(new PropertyValueFactory<>("course4"));

        col_course5.setCellValueFactory(new PropertyValueFactory<>("course5"));

        col_course6.setCellValueFactory(new PropertyValueFactory<>("course6"));

        table.setItems(oblist);

    }

    @FXML
    void BtnLevel2(ActionEvent event) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

            table.getItems().removeAll(oblist);

            rs = con.createStatement().executeQuery("select * from students WHERE  CreditHours between 37 and 72 ");

            while (rs.next()) {

                oblist.add(new ModelTable(rs.getString("id"), rs.getString("name"), rs.getString("gpa"), rs.getString("CreditHours"), rs.getString("course1"), rs.getString("course2"), rs.getString("course3"),
                        rs.getString("course4"), rs.getString("course5"), rs.getString("course6")));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));

        col_gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        col_credithours.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));

        col_course1.setCellValueFactory(new PropertyValueFactory<>("course1"));

        col_course2.setCellValueFactory(new PropertyValueFactory<>("course2"));

        col_course3.setCellValueFactory(new PropertyValueFactory<>("course3"));

        col_course4.setCellValueFactory(new PropertyValueFactory<>("course4"));

        col_course5.setCellValueFactory(new PropertyValueFactory<>("course5"));

        col_course6.setCellValueFactory(new PropertyValueFactory<>("course6"));

        table.setItems(oblist);

    }

    @FXML
    void BtnLevel3(ActionEvent event) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

            table.getItems().removeAll(oblist);

            rs = con.createStatement().executeQuery("select * from students WHERE  CreditHours between 73 and 108 ");

            while (rs.next()) {

                oblist.add(new ModelTable(rs.getString("id"), rs.getString("name"), rs.getString("gpa"), rs.getString("CreditHours"), rs.getString("course1"), rs.getString("course2"), rs.getString("course3"),
                        rs.getString("course4"), rs.getString("course5"), rs.getString("course6")));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));

        col_gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        col_credithours.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));

        col_course1.setCellValueFactory(new PropertyValueFactory<>("course1"));

        col_course2.setCellValueFactory(new PropertyValueFactory<>("course2"));

        col_course3.setCellValueFactory(new PropertyValueFactory<>("course3"));

        col_course4.setCellValueFactory(new PropertyValueFactory<>("course4"));

        col_course5.setCellValueFactory(new PropertyValueFactory<>("course5"));

        col_course6.setCellValueFactory(new PropertyValueFactory<>("course6"));

        table.setItems(oblist);

    }

    @FXML
    void BtnLevel4(ActionEvent event) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/1-student_system", "root", "");

            table.getItems().removeAll(oblist);

            rs = con.createStatement().executeQuery("select * from students WHERE  CreditHours between 109 and 144 ");

            while (rs.next()) {

                oblist.add(new ModelTable(rs.getString("id"), rs.getString("name"), rs.getString("gpa"), rs.getString("CreditHours"), rs.getString("course1"), rs.getString("course2"), rs.getString("course3"),
                        rs.getString("course4"), rs.getString("course5"), rs.getString("course6")));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));

        col_gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        col_credithours.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));

        col_course1.setCellValueFactory(new PropertyValueFactory<>("course1"));

        col_course2.setCellValueFactory(new PropertyValueFactory<>("course2"));

        col_course3.setCellValueFactory(new PropertyValueFactory<>("course3"));

        col_course4.setCellValueFactory(new PropertyValueFactory<>("course4"));

        col_course5.setCellValueFactory(new PropertyValueFactory<>("course5"));

        col_course6.setCellValueFactory(new PropertyValueFactory<>("course6"));

        table.setItems(oblist);

    }

}
