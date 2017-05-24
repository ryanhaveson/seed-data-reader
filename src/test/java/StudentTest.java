/**
 * Created by rhaveson on 5/24/2017.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import seedDataReader.Student;

public class StudentTest {
    @Test
    public void studentSetandGetShouldWork() {
        int age = 21;
        String name = "Ryan Haveson";

        Student myStudent = new Student();
        myStudent.setAge(age);
        myStudent.setName(name);

        assertEquals("age get should be age set", age, myStudent.getAge());
        assertEquals("Name get should be age set", name, myStudent.getName());
    }
}
