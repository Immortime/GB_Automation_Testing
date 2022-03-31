import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger("TriangleTest");

    @BeforeAll
    static void beforeAll() {
        logger.error("Error");
    }

    @Test
    void isItWorking() throws Exception {
        Assertions.assertEquals(Triangle.SquareTriangle(3, 4, 5), 6);
    }

    @Test
    void doesItHaveZero() throws Exception {
        Assertions.assertEquals(Triangle.SquareTriangle(0, 4, 5), 6);
    }

    @Test
    void doesItHaveNegativeNumbers() throws Exception {
        Assertions.assertEquals(Triangle.SquareTriangle(-3, -4, -5), 6);
    }
}
