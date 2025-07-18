package mission;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void 예외발생테스트() {
        run(List.of("잘못된입력"));
        assertTrue(output().contains("입력 형식이 올바르지 않습니다."));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
