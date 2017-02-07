import com.common.GenerateStudent;
import com.domain.Student;
import com.repository.StudentClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * <h1>Populate Students Table</h1>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.repository")
public class PopulateStudents {

    /**
     *
     */

    /**
     * <h1>The population student test</h1>
     * <p>This method is a population test.
     * The System should be able to create a seven billion students...
     *
     * While this will add the overhead to the build process...
     * F*ck it. The system can now survive everyone on earth.
     *
     * </p>
     * @throws Exception
     */
    @Test
    public void generateStudents() throws Exception {


        long startTime = System.currentTimeMillis();
        GenerateStudent student = new GenerateStudent();
        List<Student> students = student.students;
        long endTime = System.currentTimeMillis();

        System.out.println("Runtime :" + (endTime - startTime));
        System.out.println("students : " + students.size());

    }






    private Student generateStudent(){
        Student student = new Student();


        return student;
    }


    private String generateFirstName(){

        // todo yeah make a first name generator
        return "";
    }


    private String generateLastName(){
        // todo yeah lastname too..

        return "";
    }

    private String generateMiddleName(){
        // todo and middle name cause the system should have all data for the testcase.

        return "";
    }


    private Date generateBithDate(){

        //todo Where everyone needs a birthday!

        return new Date();
    }


    private String generateHomePhone(){

        //todo And possibly a homephone

        return "";
    }

    private String generateCellPhone(){

        //todo and maybe a cellphone (much more likely)

        return "";
    }

    private String generateEmail(){

        //todo pssh who doesn't have an email these days

        return "";
    }

















}
