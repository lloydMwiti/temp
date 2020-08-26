import junit.framework.TestCase;
import org.junit.Test;
import org.sql2o.Sql2o;

public class PersonTest extends TestCase {
    private Sql2o sql2o;

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }
    @Test
    public void testPerson() {
        Person person=new Person(sql2o);
        assertEquals(true,person instanceof Person);
    }

    public void testAddPerson() {
        Person person=new Person(sql2o);

    }
}