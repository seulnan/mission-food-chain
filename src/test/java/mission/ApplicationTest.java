package mission;

import static org.junit.jupiter.api.Assertions.assertTrue;

import api.TestEnvironment;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ApplicationTest extends TestEnvironment {
    @Test
    void testApplication() {
        run(List.of("[플랑크톤-10],[정어리-3],[고등어-2]"));
        assertTrue(output().contains("3일간 생존했습니다. "));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
