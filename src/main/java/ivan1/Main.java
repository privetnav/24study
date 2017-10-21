package ivan1;

import ivan1.db.dao.UserDAO;
import ivan1.entities.User;
import ivan1.entities.Users;
import ivan1.jaxb.JaxbParser;
import ivan1.jaxb.Parser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.sql.SQLException;

public class Main {
    private static Parser parser = new JaxbParser();
    private static File file=new File("user.xml");
    private static File file2=new File("course.xml");

    public static void main(String[] args) throws JAXBException {
        //List<User> users = new ArrayList<>();
     /*
        User vasya = new User();
        vasya.setFirstName("Илья");
        vasya.setFamily("Петров");
        vasya.setPatronymic("Петрович");
        vasya.setCity("Севастополь");

        User masha = new User();
        masha.setFirstName("Маша");
        masha.setFamily("Иванова");
        masha.setPatronymic("Ивановна");
        masha.setCity("Киев");

        Users group1 = new Users();
        group1.addUser(vasya);
        group1.addUser(masha);

        Courses coursesAll = new Courses();
        Course htmlLevel1 = new Course(1, "html и css. Уровень 1. Основы.");
        Course htmlLevel2 = new Course(2, "html и css. Уровень 2. Продвинутый уровень.");
        Course javascriptLevel1 = new Course(3, "javaScript. Уровень 1. Основы.");
        Course javascriptLevel2 = new Course(4, "javaScript. Уровень 2. Продвинутый уровень.");
        Course jQueryLevel1 = new Course(5, "jQuery. Уровень 1. Основы.");
        Course jQueryLevel2 = new Course(6, "jQuery. Уровень 2. Продвинутый уровень.");

        coursesAll.addCourse(htmlLevel1);
        coursesAll.addCourse(htmlLevel2);
        coursesAll.addCourse(javascriptLevel1);
        coursesAll.addCourse(javascriptLevel2);
        coursesAll.addCourse(jQueryLevel1);
        coursesAll.addCourse(jQueryLevel2);



        parser.saveObject(file, group1);
        parser.saveObject(file2, coursesAll);
*/

        try {

            //Users userList = UserDAO.getAll();
            /*
            for(User user : userList.getUsers()){
                user.printUser();
            }
            */
            //parser.saveObject(file, userList);



            //parser.saveObject(file, userList);
            Users userList = new Users();
            userList = (Users) parser.getObject(file, Users.class);
            for(User user : userList.getUsers()){
                user.printUser();
            }

            UserDAO.saveAll(userList);




        } catch (SQLException e) {
            e.printStackTrace();
        }

/*
        Users userList = (Users) parser.getObject(file, Users.class);
        for(User user : userList.getUsers()){
            user.printUser();
        }
*/
    }
}
