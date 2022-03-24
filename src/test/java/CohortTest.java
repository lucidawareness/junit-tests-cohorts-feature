import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CohortTest {
    Cohort firstCohort;
    Cohort secondCohort;

    @Before
    public void setUp() {
        firstCohort = new Cohort();
        secondCohort = new Cohort();

        Student irvin = new Student(1, "Irvin Ruiz");
        irvin.addGrade(100);

        Student john = new Student(1, "John Cena");
        john.addGrade(90);
        john.addGrade(80);
        john.addGrade(100);
        Student mike = new Student(2, "Mike Jones");
        mike.addGrade(70);
        mike.addGrade(90);
        mike.addGrade(60);

        firstCohort.addStudent(irvin);

        secondCohort.addStudent(john);
        secondCohort.addStudent(mike);
    }

    @Test
    public void testAddStudentToCohort() {
        firstCohort.addStudent(new Student(2,"John Cena"));
        assertEquals("John Cena", firstCohort.getStudents().get(1).getName());
    }

    @Test
    public void testGetStudents() {
        assertEquals(1, firstCohort.getStudents().size());
        assertEquals(2, secondCohort.getStudents().size());
    }

    @Test
    public void testGetAverage() {
        assertEquals(100, firstCohort.getCohortAverage(), 2);
        assertEquals(81.66, secondCohort.getCohortAverage(), 3);
    }
}
