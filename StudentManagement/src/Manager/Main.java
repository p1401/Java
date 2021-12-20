package Manager;


import Entity.Student;
import java.util.ArrayList;

/**
 *
 * @author duyph
 */
public class Main {

    public static void main(String[] args) {
        Validation validation = new Validation();
        Manager m = new Manager();
        int count = 0;
        //loop until user want to exit program
        while (true) {
            //Show menu option
            m.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    m.createStudent(count);
                    break;
                case 2:
                    m.findAndSort();
                    break;
                case 3:
                    m.updateOrDelete(count);
                    break;
                case 4:
                    m.report();
                    break;
                case 5:
                    return;
            }

        }
    }

}
